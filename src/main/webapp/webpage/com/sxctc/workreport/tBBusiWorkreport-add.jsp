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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusiWorkreportController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tBBusiWorkreportPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							厅局编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="unitCode" name="unitCode" type="text" maxlength="4" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">厅局编号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							厅局名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="reportTitle" name="reportTitle" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">厅局名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							日报时间:
						</label>
					</td>
					<td class="value">
					     	 <input id="reportDate" name="reportDate" type="text" maxlength="20" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日报时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							完成工作:
						</label>
					</td>
					<td class="value">
					     	 <input id="doneToday" name="doneToday" type="text" maxlength="300" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完成工作</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							未完成工作:
						</label>
					</td>
					<td class="value">
					     	 <input id="unDoneToday" name="unDoneToday" type="text" maxlength="300" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">未完成工作</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							协调工作:
						</label>
					</td>
					<td class="value">
					     	 <input id="coordinateWork" name="coordinateWork" type="text" maxlength="300" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">协调工作</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							日报类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="reportType" name="reportType" type="text" maxlength="4" style="width: 150px" class="inputxt"  datatype="n"  ignore="ignore" />
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
					     	 <input id="businessId" name="businessId" type="text" maxlength="36" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">业务id</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" maxlength="300" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/workreport/tBBusiWorkreport.js"></script>		
