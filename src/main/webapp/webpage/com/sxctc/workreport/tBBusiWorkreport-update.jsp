<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>今日日报列表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusiWorkreportController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBBusiWorkreportPage.id }"/>
					<input id="reportType" name="reportType" type="hidden" value="${tBBusiWorkreportPage.reportType }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<c:if test="${toolFlag == '1'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								厅局名称:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="unitCode" type="list"  typeGroupCode="unit_name"   defaultVal="${tBBusiWorkreportPage.unitCode}" hasLabel="false"  title="厅局单位" readonly="readonly"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">厅局编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								迁移系统名称:
							</label>
						</td>
						<td class="value">
							<input id="reportTitle" name="reportTitle" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="checked"  value='${tBBusiWorkreportPage.reportTitle}' readonly="true"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">厅局名称</label>
						</td>
					</tr>
					</c:if>
					<tr>
						<td align="right" style="width: 20%;">
							<label class="Validform_label">
								今日时间:
							</label>
						</td>
						<td class="value">
							<input id="reportDate" name="reportDate" type="text" style="width: 150px"  class="Wdate"  ignore="checked" readonly="true" value='<fmt:formatDate value='${tBBusiWorkreportPage.reportDate}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">今日时间</label>
						</td>
					</tr>
					<c:if test="${toolFlag == '1'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								今日完成的工作:
							</label>
						</td>
						<td class="value">
							<textarea id="doneToday" style="width:90%;height: 100px;" class="inputxt" rows="6" name="doneToday"  ignore="checked" >${tBBusiWorkreportPage.doneToday}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完成工作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								未完成的工作:
							</label>
						</td>
						<td class="value">
							<textarea id="unDoneToday" style="width:90%;height: 100px;" class="inputxt" rows="6" name="unDoneToday"  ignore="checked" >${tBBusiWorkreportPage.unDoneToday}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">未完成工作</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								需要协调的工作:
							</label>
						</td>
						<td class="value">
							<textarea id="coordinateWork" style="width:90%;height: 100px;" class="inputxt" rows="6" name="coordinateWork"  ignore="checked" >${tBBusiWorkreportPage.coordinateWork}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">协调工作</label>
						</td>
					</tr>
					<%--<tr>
						<td align="right">
							<label class="Validform_label">
								日报类型:
							</label>
						</td>
						<td class="value">
						    <input id="reportType" name="reportType" type="text" maxlength="4" style="width: 100%" class="inputxt"  datatype="n"  ignore="ignore"  value='${tBBusiWorkreportPage.reportType}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日报类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								业务id:
							</label>
						</td>
						<td class="value">
						    <input id="businessId" name="businessId" type="text" maxlength="36" style="width: 100%" class="inputxt"  ignore="ignore"  value='${tBBusiWorkreportPage.businessId}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务id</label>
						</td>
					</tr>--%>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
							<textarea id="remark" style="width:90%;height: 100px;" class="inputxt" rows="6" name="remark"  ignore="checked" >${tBBusiWorkreportPage.remark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					</c:if>
					<c:if test="${toolFlag == '0'}">
					<tr>
						<td align="right">
							<label class="Validform_label">
								日志内容:
							</label>
						</td>
						<td class="value">
							<textarea id="doneToday" style="width:90%;height: 100px;" class="inputxt" rows="6" name="doneToday"  ignore="checked" >${tBBusiWorkreportPage.doneToday}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完成工作</label>
						</td>
					</tr>
					</c:if>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/workreport/tBBusiWorkreport.js"></script>		
