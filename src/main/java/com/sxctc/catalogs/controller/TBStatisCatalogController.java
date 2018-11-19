package com.sxctc.catalogs.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sxctc.business.entity.TBBusiCatalogEntity;
import com.sxctc.business.entity.TBBusinessEntity;
import com.sxctc.business.service.TBBusinessServiceI;
import com.sxctc.catalogs.entity.TBCatalogdataEntity;
import com.sxctc.catalogs.entity.TBCatalogdataTree;
import com.sxctc.catalogs.service.TBCatalogdataServiceI;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: TBStatisCatalogController
 * @Description: 服务目录统计
 * @date 2018/9/3 下午2:12
 * @author liuzc
 * @version V1.0
 */
@Api(value="TBStatisCatalog",description="服务目录统计",tags="tBStatisCatalogController")
@Controller
@RequestMapping("/tBStatisCatalogController")
public class TBStatisCatalogController extends BaseController {

    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(TBStatisCatalogController.class);

    @Autowired
    private TBCatalogdataServiceI tBCatalogdataService;
    @Autowired
    private TBBusinessServiceI tBBusinessService;
    @Autowired
    private SystemService systemService;

    /**
     * 类型分组列表页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView typeGroupList(HttpServletRequest request) {
        String type = request.getParameter("type");
        request.setAttribute("type",type);
        return new ModelAndView("com/sxctc/catalogs/tBStatisCatalogList");
    }

    @RequestMapping(params = "tablist")
    public ModelAndView tablist(HttpServletRequest request) {
        return new ModelAndView("com/sxctc/catalogs/tBStatisCatalogTab");
    }

    /**
     * 部门列表，树形展示
     * @param request
     * @param response
     * @param treegrid
     * @return
     */
    @RequestMapping(params = "datagrid")
    @ResponseBody
    public Object departgrid(TBCatalogdataTree tBCatalogdata, HttpServletRequest request, HttpServletResponse response, TreeGrid treegrid) {
        String types = request.getParameter("catalogtype");
        CriteriaQuery cq = new CriteriaQuery(TBCatalogdataTree.class);
        if("yes".equals(request.getParameter("isSearch"))){
            treegrid.setId(null);
            tBCatalogdata.setId(null);
        }
        if(null != tBCatalogdata.getName()){
            org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCatalogdata);
        }
        if (treegrid.getId() != null) {
            cq.eq("TBPCatalogdata.id", treegrid.getId());
        }
        if (treegrid.getId() == null) {
            cq.isNull("TBPCatalogdata");
        }

        cq.eq("type",types);
        cq.add();
        List<TreeGrid> departList =null;
        departList=systemService.getListByCriteriaQuery(cq, false);
        if(departList.size()==0&&tBCatalogdata.getName()!=null){
            cq = new CriteriaQuery(TBCatalogdataTree.class);
            TBCatalogdataTree parDepart = new TBCatalogdataTree();
            tBCatalogdata.setTBPCatalogdata(parDepart);
            org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCatalogdata);
            departList =systemService.getListByCriteriaQuery(cq, false);
        }
        List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
        TreeGridModel treeGridModel = new TreeGridModel();
        treeGridModel.setTextField("name");
        treeGridModel.setParentText("TBPCatalogdata_name");
        treeGridModel.setParentId("TBPCatalogdata_id");
        treeGridModel.setSrc("null");
        treeGridModel.setIdField("id");
        treeGridModel.setChildList("TBCatalogdatas");
        Map<String,Object> fieldMap = new HashMap<String, Object>();
        fieldMap.put("danwei", "danwei");
        fieldMap.put("num", "num");
        fieldMap.put("type", "type");
        fieldMap.put("price", "price");
        fieldMap.put("catalogCode", "catalogCode");
        fieldMap.put("nodeId", "nodeId");
        fieldMap.put("beizhu", "beizhu");
        treeGridModel.setFieldMap(fieldMap);
        treeGrids = systemService.treegrid(departList, treeGridModel);

        JSONArray jsonArray = new JSONArray();
        for (TreeGrid treeGrid : treeGrids) {
            if (treeGrid.getState().equals("open")) {
                Map<String, Object> map = treeGrid.getFieldMap();
                String catalogId = treeGrid.getId();
                BigDecimal price = BigDecimal.ZERO;
                Object obj = map.get("price");
                if (obj != null && StringUtils.isNotBlank(obj.toString())) {
                    price = new BigDecimal(map.get("price").toString());
                }
                String hql = "from TBBusiCatalogEntity where catalogId=?";
                List<TBBusiCatalogEntity> byQueryString = this.tBBusinessService.findHql(hql,catalogId);
                Long total = 0l;
                if (byQueryString.size() > 0) {
                    for (TBBusiCatalogEntity tbBusiCatalogEntity : byQueryString) {
                        Integer checkNum = tbBusiCatalogEntity.getCheckNum();
                        if (checkNum != null && checkNum != 0) {
                            total += checkNum;
                        }
                    }
                }
                if (total != 0 && !price.equals(BigDecimal.ZERO)) {
                    BigDecimal decimal = new BigDecimal(total);
                    map.put("total",decimal.multiply(price));
                }
            }
            jsonArray.add(JSON.parse(treeGrid.toJson()));
        }
        return jsonArray;
    }


    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "datagrid1")
    public void datagrid(TBCatalogdataEntity tBCatalogdata, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
        CriteriaQuery cq = new CriteriaQuery(TBCatalogdataEntity.class, dataGrid);
        String types = request.getParameter("catalogtype");
        if(StringUtil.isEmpty(tBCatalogdata.getId())){
            cq.isNull("fartherid");
        }else{
            cq.eq("fartherid", tBCatalogdata.getId());
            tBCatalogdata.setId(null);
        }
        cq.eq("type",types);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBCatalogdata, request.getParameterMap());
        try{
            //自定义追加查询条件
        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.tBCatalogdataService.getDataGridReturn(cq, true);

        // 遍历查询结果，组装统计字段
        List<TBCatalogdataEntity> results = dataGrid.getResults();
        if (results.size() == 0 || "01".equals(types)) {
            TagUtil.treegrid(response, dataGrid);
            return;
        }

        // 遍历
        for (TBCatalogdataEntity result : results) {
            String catalogId = result.getId();
            BigDecimal price = result.getPrice();
            String hql = "from TBBusiCatalogEntity where catalogId=?";
            List<TBBusiCatalogEntity> byQueryString = this.tBBusinessService.findHql(hql,catalogId);
            Long total = 0l;
            if (byQueryString.size() > 0) {
                for (TBBusiCatalogEntity tbBusiCatalogEntity : byQueryString) {
                    Integer checkNum = tbBusiCatalogEntity.getCheckNum();
                    if (checkNum != null && checkNum != 0) {
                        total += checkNum;
                    }
                }
            }
            if (total != 0 && !price.equals(BigDecimal.ZERO)) {
                BigDecimal decimal = new BigDecimal(total);
                result.setTotal(decimal.multiply(price));
            }
        }

        TagUtil.treegrid(response, dataGrid);
    }

    /**
     * 跳转到使用详情页面
     * @param request request
     * @return
     */
    @RequestMapping(params = "goTypeGrid")
    public ModelAndView goTypeGrid(HttpServletRequest request) {
        String typegroupid = request.getParameter("typegroupid");
        request.setAttribute("typegroupid", typegroupid);
        return new ModelAndView("com/sxctc/catalogs/tBStatisListForGroup");
    }

    /**
     * easyui AJAX请求数据
     *
     * @param request
     * @param response
     * @param dataGrid
     */

    @RequestMapping(params = "typeGroupGrid")
    public void typeGroupGrid(TBBusinessEntity tBBusiness, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid, String typegroupid) {
        CriteriaQuery cq = new CriteriaQuery(TBBusinessEntity.class, dataGrid);
        //查询条件组装器
        org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, tBBusiness, request.getParameterMap());
        try{
            //自定义追加查询条件
            if (StringUtils.isNotBlank(typegroupid)) {
                String hql = "from TBBusiCatalogEntity where catalogId=?";
                List<TBBusiCatalogEntity> byQueryString = this.tBBusinessService.findHql(hql,typegroupid);
                if (byQueryString.size() > 0) {
                    List<String> businessIdArr = new ArrayList<String>();
                    for (TBBusiCatalogEntity tbBusiCatalogEntity : byQueryString) {
                        String businessId = tbBusiCatalogEntity.getBusinessId();
                        businessIdArr.add(businessId);
                    }
                    // 添加条件
                    cq.in("id",businessIdArr.toArray());
                }else {
                    cq.isNull("id");
                }
            }

        }catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }
        cq.add();
        this.tBBusinessService.getDataGridReturn(cq, true);

        // 拼装返回展示参数：总计、数量
        List<TBBusinessEntity> results = dataGrid.getResults();
        // 遍历
        for (TBBusinessEntity result : results) {
            String businessId = result.getId();
            String hql = "from TBBusiCatalogEntity where businessId=? and catalogId=?";
            List<TBBusiCatalogEntity> byQueryString = this.tBBusinessService.findHql(hql,businessId,typegroupid);
            Long total = 0l;
            Integer checkNum = 0;
            BigDecimal price = BigDecimal.ZERO;
            if (byQueryString.size() > 0) {
                for (TBBusiCatalogEntity tbBusiCatalogEntity : byQueryString) {
                    checkNum = tbBusiCatalogEntity.getCheckNum();
                    String catalogId = tbBusiCatalogEntity.getCatalogId();
                    TBCatalogdataEntity entity = this.tBBusinessService.getEntity(TBCatalogdataEntity.class, catalogId);
                    price = entity.getPrice();
                    if (checkNum != null && checkNum != 0) {
                        total += checkNum;
                    }

                }
            }
            if (total != 0 && !price.equals(BigDecimal.ZERO)) {
                BigDecimal decimal = new BigDecimal(total);
                result.setTotal(decimal.multiply(price));
                result.setSum(checkNum);
            }
        }

        TagUtil.datagrid(response, dataGrid);
    }
}
