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
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								厅局单位:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="unitCode" type="list"  typeGroupCode=""   defaultVal="${tBWorkreportdayWeekPage.unitCode}" hasLabel="false"  title="厅局单位" ></t:dictSelect>     
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
						    <input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBWorkreportdayWeekPage.projectName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">迁移系统名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								周报日期开始:
							</label>
						</td>
						<td class="value">
									  <input id="reportStartDate" name="reportStartDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tBWorkreportdayWeekPage.reportStartDate}' type="date" pattern="yyyy-MM-dd"/>'/>
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
									  <input id="reportEndDate" name="reportEndDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tBWorkreportdayWeekPage.reportEndDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">周报日期结束</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								今日完成的工作:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="doneDay" style="width:600px;" class="inputxt" rows="6" name="doneDay"  ignore="ignore" >${tBWorkreportdayWeekPage.doneDay}</textarea>
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
						  	 	<textarea id="unDoneDay" style="width:600px;" class="inputxt" rows="6" name="unDoneDay"  ignore="ignore" >${tBWorkreportdayWeekPage.unDoneDay}</textarea>
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
						  	 	<textarea id="coordinateWork" style="width:600px;" class="inputxt" rows="6" name="coordinateWork"  ignore="ignore" >${tBWorkreportdayWeekPage.coordinateWork}</textarea>
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
						  	 	<textarea id="remark" style="width:600px;" class="inputxt" rows="6" name="remark"  ignore="ignore" >${tBWorkreportdayWeekPage.remark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/week/tBWorkreportdayWeek.js"></script>		
