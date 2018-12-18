package org.jeecgframework.core.common.controller;

import com.sxctc.projectrack.entity.TBChancePoolEntity;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.jeecgframework.core.common.service.CommonService;
import org.jeecgframework.core.interceptors.DateConvertEditor;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 基础控制器，其他控制器需集成此控制器获得initBinder自动转换的功能
 * @author  张代浩
 * 
 */
@Controller
@RequestMapping("/baseController")
public class BaseController {

	@Autowired
	private SystemService systemService;

	/**
	 * 将前台传递过来的日期格式的字符串，自动转化为Date类型
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
//		SimpleDateFormat dateFormat = new SimpleDateFormat(
//				"yyyy-MM-dd hh:mm:ss");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(
//				dateFormat, true));
		binder.registerCustomEditor(Date.class, new DateConvertEditor());
	}

	/**
	 * 分页公共方法(非easyui)
	 * 
	 * @author Alexander
	 * @date 20131022
	 */
	public List<?> pageBaseMethod(HttpServletRequest request,
			DetachedCriteria dc, CommonService commonService, int pageRow) {
		// 当前页
		// 总条数
		// 总页数

		int currentPage = 1;

		int totalRow = 0;
		int totalPage = 0;
		// 获取当前页
		String str_currentPage = request.getParameter("str_currentPage");
		currentPage = str_currentPage == null || "".equals(str_currentPage) ? 1
				: Integer.parseInt(str_currentPage);
		// 获取每页的条数
		String str_pageRow = request.getParameter("str_pageRow");
		pageRow = str_pageRow == null || "".equals(str_pageRow) ? pageRow
				: Integer.parseInt(str_pageRow);

		// 统计的总行数
		dc.setProjection(Projections.rowCount());

		totalRow = Integer.parseInt(commonService.findByDetached(dc).get(0)
				.toString());
		totalPage = (totalRow + pageRow - 1) / pageRow;

		currentPage = currentPage < 1 ? 1 : currentPage;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
		// 清空统计函数
		dc.setProjection(null);
		// dc.setResultTransformer(dc.DISTINCT_ROOT_ENTITY);
		List<?> list = commonService.pageList(dc, (currentPage - 1) * pageRow,
				pageRow);

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageRow", pageRow);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("totalPage", totalPage);
		return list;
	}

    /**
     * 抽取由逗号分隔的主键列表
     *
     * @param ids
     *            由逗号分隔的多个主键值
     * @return 主键类表
     * @author 张国明 2014-8-21 21:57:16
     */
    protected List<String> extractIdListByComma(String ids) {
        List<String> result = new ArrayList<String>();
        if (StringUtils.hasText(ids)) {
            for (String id : ids.split(",")) {
                if (StringUtils.hasLength(id)) {
                    result.add(id.trim());
                }
            }
        }

        return result;
    }

	/**
	 * @Title standardMoney
	 * @Description 标准化类中的金额（标准化金额类型必须是BigDecimal）
	 * @Param  t 任意类
	 *         standFlag 标准类型：1——>元 标准；2——>万元 标准
	 *         opt 入库/出库（变成standFlag类型）：1——>入库；2——>出库
	 * @Return void
	 * @Author liuzc
	 * @Date 2018/11/29 15:34
	 **/
	public void standardMoney(Object t, int standFlag, int opt) {
		try{
			// 反射创建对象
			Class aClass = t.getClass();
			Object o = aClass.newInstance();

			// 获取所以私有变量
			Field[] fields = aClass.getDeclaredFields();

			// 初始化标准化指标
			BigDecimal bg100 = new BigDecimal(100);
			BigDecimal bg1W = new BigDecimal(10000);

			// 遍历类中BigDecimal类型金额进行标准化
			for (Field field : fields) {

				// 设置可访问私有变量
				field.setAccessible(true);

				// 将属性的首字母大写
				String fieldName = field.getName();
				fieldName = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());

				// 获取变量类型进行判断
				String fieldType = field.getType().getName();
				if (fieldType.equals("java.math.BigDecimal")) {
					// 如果type是类类型，则前面包含"class "，后面跟类名
					Method m = aClass.getMethod("get" + fieldName);

					// 调用getter方法获取属性值
					BigDecimal value = (BigDecimal) m.invoke(t);
					if (value != null) {
						// 进行金额标准化
						// 单位为：元 的标准
						if (standFlag == 1) {
							// 库中数据是以分为单位
							// 将元统一乘以100入库
							if (opt == 1) {
								value = value.multiply(bg100);
							}
							// 将元统一除以100出库
							if (opt == 2) {
								value = value.divide(bg100, 2, RoundingMode.HALF_UP);
							}
						}
						// 单位为：万元 的标准
						if (standFlag == 2) {
							// 库中数据是以分为单位
							// 将万元统一乘以10000入库
							if (opt == 1) {
								value = value.multiply(bg1W);
							}
							// 将万元统一除以10000出库
							if (opt == 2) {
								value = value.divide(bg1W, 2, RoundingMode.HALF_UP);
							}
						}

						// 给属性重新赋值
						field.set(t,value);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Title getVaildBusinessIdList
	 * @Description 查询系统中所有未结束的业务Id
	 * @Param []
	 * @Return java.util.List<java.lang.String>
	 * @Author liuzc
	 * @Date 2018/12/3 16:51
	 **/
	public List<String> getVaildBusinessIdList() {
		// 获取当前用户
		TSUser tsUser = ResourceUtil.getSessionUser();
		String userName = tsUser.getUserName();

		// 进行查询
		String hql1 = "select id from TBBusinessEntity where chanceStatus = ? and joinStatus != ? and createBy = ?";
		List<String> busiList = systemService.findHql(hql1, 0, 7, userName);
		String hql2 = "select businessId from TBChancePoolEntity where winningResult = ? and createBy = ?";
		List<String> poolList = systemService.findHql(hql2, 0, userName);
		String hql3 = "select businessId from TBProfitTargetEntity where projectStatus != ? and createBy = ?";
		List<String> profitList = systemService.findHql(hql3, 2, userName);

		// 进行合并
		busiList.addAll(poolList);
		busiList.addAll(profitList);

		// 返回
		return busiList;
	}
}
