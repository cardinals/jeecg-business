<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>财务报表导出</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBFinalformExportController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBFinalformExportPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/finalform/tBFinalformExport.js"></script>		
