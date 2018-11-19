package com.sxctc.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * ClassName:FreemarkerUtil</br>
 * Function:freemarker工具类</br>
 * 
 * @author zhichao.liu</br>
 * @version 1.0</br>
 *
 */
public class FreemarkerUtil {

	
	/**
	 * 生成html字符串
	 *
	 * @param params 页面参数map
	 * @param request 请求
	 * @param ftlName 模版名称
	 * @return
	 */
	public static String createHtmlStr(Map<String, String> params, HttpServletRequest request, String ftlName) {
		try {
			// 获取模版路径
			String ftlPath = request.getSession().getServletContext().getRealPath("/WEB-INF/ftl");
			
			// 创建模版配置项
	        Configuration configuration = new Configuration();
	        
	        // 配置模版
			configuration.setDirectoryForTemplateLoading(new File(ftlPath));
	        configuration.setDefaultEncoding("UTF-8");
	        
	        // 获取或创建一个模版。  
	        Template template = configuration.getTemplate(ftlName);
	        
	        //将map中的数据输入到index.ftl这个模板文件中并遍历出来，最后再将整个模板的数据写入到index.html中。
	        StringWriter sw = new StringWriter();
	        template.process(params, new PrintWriter(sw));
	        
	        // 去除输出文档中的转义符
	        String html = sw.toString().replace("\r\n", "").replace("\t", "");
	        
	        /*// 获取html静态页面文件
	        String indexPath = request.getSession().getServletContext().getRealPath("/index.html");
	        //设置文件输入流编码，不然生成的html文件会中文乱码
	        FileWriterWithEncoding out = new FileWriterWithEncoding(indexPath,"UTF-8");
	        template.process(params, out);*/
	        
	        // 返回内容
	        return html;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
