<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>日报管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBWorkreportdayController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBWorkreportdayPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								厅局单位:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="unitCode" type="list"  typeGroupCode="unit_name"   defaultVal="${tBWorkreportdayPage.unitCode}" hasLabel="false"  title="厅局单位" readonly="readonly"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">厅局单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								迁移系统名称:
							</label>
						</td>
						<td class="value">
						    <input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="checked"  value='${tBWorkreportdayPage.projectName}' readonly="true"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">迁移系统名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								今日时间:
							</label>
						</td>
						<td class="value">
						    <input id="reportDate" name="reportDate" type="text" style="width: 150px"  class="Wdate"  ignore="checked" readonly="true" value='<fmt:formatDate value='${tBWorkreportdayPage.reportDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">今日时间</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								今日完成的工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="doneDay" style="width:100%;height: 260px;" class="inputxt" rows="6" name="doneDay"  ignore="checked" >${tBWorkreportdayPage.doneDay}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">今日完成的工作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								未完成的工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="unDoneDay" style="width:100%;height: 260px;" class="inputxt" rows="6" name="unDoneDay"  ignore="ignore" >${tBWorkreportdayPage.unDoneDay}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">未完成的工作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								需要协调的工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="coordinateWork" style="width:100%;height: 260px;" class="inputxt" rows="6" name="coordinateWork"  ignore="ignore" >${tBWorkreportdayPage.coordinateWork}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">需要协调的工作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="remark" style="width:100%;height: 260px;" class="inputxt" rows="6" name="remark"  ignore="ignore" >${tBWorkreportdayPage.remark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/workdays/tBWorkreportday.js"></script>		
