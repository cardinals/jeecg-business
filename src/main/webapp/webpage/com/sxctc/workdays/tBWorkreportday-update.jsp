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
								创建人名称:
							</label>
						</td>
						<td class="value">
						    <input id="createName" name="createName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBWorkreportdayPage.createName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建人名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								创建日期:
							</label>
						</td>
						<td class="value">
									  <input id="createDate" name="createDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tBWorkreportdayPage.createDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">创建日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								厅局单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="tingjvdanweiName" type="list"  typeGroupCode="unit_name"   defaultVal="${tBWorkreportdayPage.tingjvdanweiName}" hasLabel="false"  title="厅局单位" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">厅局单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								系统名称:
							</label>
						</td>
						<td class="value">
						    <input id="xitongName" name="xitongName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBWorkreportdayPage.xitongName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系统名称</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								今日工作内容:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="workDay" style="width:600px;" class="inputxt" rows="6" name="workDay"  ignore="ignore" >${tBWorkreportdayPage.workDay}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">今日工作内容</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								明日工作计划:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="tomDay" style="width:600px;" class="inputxt" rows="6" name="tomDay"  ignore="ignore" >${tBWorkreportdayPage.tomDay}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">明日工作计划</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								今日工作计划:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="workDays" style="width:600px;" class="inputxt" rows="6" name="workDays"  ignore="ignore" >${tBWorkreportdayPage.workDays}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">今日工作计划</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								需要的帮助和支持:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="bangZhu" style="width:600px;" class="inputxt" rows="6" name="bangZhu"  ignore="ignore" >${tBWorkreportdayPage.bangZhu}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">需要的帮助和支持</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="beizhu" style="width:600px;" class="inputxt" rows="6" name="beizhu"  ignore="ignore" >${tBWorkreportdayPage.beizhu}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/workdays/tBWorkreportday.js"></script>		
