package test;

import com.sxctc.projectrack.entity.TBChancePoolEntity;
import com.sxctc.util.DateUtil;
import com.sxctc.util.FreemarkerUtil;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.util.DateUtils;
import org.jsoup.helper.DataUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuzc
 * @version V1.0
 * @ClassName: MyTest
 * @Description: //TODO
 * @date 2018/7/19 下午4:32
 */
public class MyTest {

    public static void main(String[] args) {
        try {
            List<String> busiList = new ArrayList<String>();
            List<String> poolList = new ArrayList<String>();
            busiList.addAll(poolList);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
