<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>周报</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBWorkreportdayWeekController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBWorkreportdayWeekPage.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
                    <c:if test="${toolFlag == '1'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位名称:
							</label>
						</td>
						<td class="value">
                            <t:dictSelect field="unitCode" type="list"  typeGroupCode="unit_name"   defaultVal="${tBWorkreportdayWeekPage.unitCode}" hasLabel="false"  title="厅局单位" readonly="readonly"></t:dictSelect>
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
                            <input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="checked"  value='${tBWorkreportdayWeekPage.projectName}' readonly="true"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">系统名称</label>
						</td>
					</tr>
                    </c:if>
					<tr>
						<td align="right" style="width: 20%;">
							<label class="Validform_label">
								周报日期开始:
							</label>
						</td>
						<td class="value">
                            <input id="reportStartDate1" name="reportStartDate1" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" disabled="disabled" value='<fmt:formatDate value='${tBWorkreportdayWeekPage.reportStartDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                            <input id="reportStartDate" name="reportStartDate" type="hidden" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" readonly="readonly" value='<fmt:formatDate value='${tBWorkreportdayWeekPage.reportStartDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">周报日期开始</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								周报日期结束:
							</label>
						</td>
						<td class="value">
                            <input id="reportEndDate1" name="reportEndDate1" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  ignore="ignore" disabled="disabled" value='<fmt:formatDate value='${tBWorkreportdayWeekPage.reportEndDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                            <input id="reportEndDate" name="reportEndDate" type="hidden" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" readonly="readonly" value='<fmt:formatDate value='${tBWorkreportdayWeekPage.reportEndDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">周报日期结束</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								本周工作内容:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="doneDay" style="width:90%; height: 100px;" class="inputxt" rows="6" name="doneDay"  ignore="ignore" >${tBWorkreportdayWeekPage.doneDay}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本周工作内容</label>
						</td>
					</tr>
                    <c:if test="${toolFlag == '1'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								下周工作计划:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="nextDone" style="width:90%; height: 100px;" class="inputxt" rows="6" name="nextDone"  ignore="ignore" >${tBWorkreportdayWeekPage.nextDone}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">下周工作计划</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								需要协调的工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="coordinateWork" style="width:90%; height: 100px;" class="inputxt" rows="6" name="coordinateWork"  ignore="ignore" >${tBWorkreportdayWeekPage.coordinateWork}</textarea>
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
						  	 	<textarea id="remark" style="width:90%; height: 100px;" class="inputxt" rows="6" name="remark"  ignore="ignore" >${tBWorkreportdayWeekPage.remark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								本周工作总结:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="workSum" style="width:90%; height: 100px;" class="inputxt" rows="6" name="workSum"  ignore="ignore" >${tBWorkreportdayWeekPage.workSum}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">本周工作总结</label>
						</td>
					</tr>
                    </c:if>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/workreport/tBWorkreportdayWeek.js"></script>		
