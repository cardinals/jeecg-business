<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>月报</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBWorkreportdayMonthController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBWorkreportdayMonthPage.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<c:if test="${toolFlag == '1'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位名称:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="unitCode" type="list"  typeGroupCode="unit_name"   defaultVal="${tBWorkreportdayMonthPage.unitCode}" hasLabel="false"  title="厅局单位" readonly="readonly"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								系统名称:
							</label>
						</td>
						<td class="value">
							<input id="reportTitle" name="reportTitle" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="checked"  value='${tBWorkreportdayMonthPage.reportTitle}' readonly="true"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系统名称</label>
						</td>
					</tr>
					</c:if>
					<tr>
						<td align="right" style="width: 20%;">
							<label class="Validform_label">
								月份:
							</label>
						</td>
						<td class="value">
									  <input id="reportDate" name="reportDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" readonly="readonly"  ignore="ignore" value='<fmt:formatDate value='${tBWorkreportdayMonthPage.reportDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">月份</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								本月工作工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="doneToday" style="width:90%; height: 100px;" class="inputxt" rows="6" name="doneToday" ignore="ignore" >${tBWorkreportdayMonthPage.doneToday}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本月工作工作</label>
						</td>
					</tr>
					<c:if test="${toolFlag == '1'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								下月工作计划:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="nextDone" style="width:90%; height: 100px;" class="inputxt" rows="6" name="nextDone"  ignore="ignore" >${tBWorkreportdayMonthPage.nextDone}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">下月工作计划</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								协调工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="coordinateWork" style="width:90%; height: 100px;" class="inputxt" rows="6" name="coordinateWork"  ignore="ignore" >${tBWorkreportdayMonthPage.coordinateWork}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">协调工作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								工作总结:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="workSum" style="width:90%; height: 100px;" class="inputxt" rows="6" name="workSum"  ignore="ignore" >${tBWorkreportdayMonthPage.workSum}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">工作总结</label>
						</td>
					</tr>
					</c:if>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/workreport/tBWorkreportdayMonth.js"></script>		
