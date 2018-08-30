<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>项目机会池</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBChancePoolController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBChancePoolPage.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right" style="width: 10%">
							<label class="Validform_label">
								历史计划:
							</label>
						</td>
						<td class="value">
							<textarea id="projectPlan" style="width:95%;height: 100px;" class="inputxt" rows="6" name="projectPlan"  ignore="ignore" >${tBChancePoolPage.historyPlan}</textarea>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
 <script src = "webpage/com/sxctc/projectrack/tBChancePool.js"></script>