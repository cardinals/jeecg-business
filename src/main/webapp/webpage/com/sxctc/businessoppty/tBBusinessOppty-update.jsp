<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商机评估</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusinessOpptyController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBBusinessOpptyPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								评估值1win:
							</label>
						</td>
						<td class="value">
						    <input id="evaluateWin" name="evaluateWin" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBBusinessOpptyPage.evaluateWin}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评估值1win</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								评估值3first:
							</label>
						</td>
						<td class="value">
						    <input id="evaluateFirst" name="evaluateFirst" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBBusinessOpptyPage.evaluateFirst}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评估值3first</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								评估值9confirm:
							</label>
						</td>
						<td class="value">
						    <input id="evaluateConfirm" name="evaluateConfirm" type="text" maxlength="10" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBBusinessOpptyPage.evaluateConfirm}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评估值9confirm</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						    <input id="projectName" name="projectName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBBusinessOpptyPage.projectName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/businessoppty/tBBusinessOppty.js"></script>		
