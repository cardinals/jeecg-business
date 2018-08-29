<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户地图</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBCustomerMapController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tBCustomerMapPage.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
						<input id="projectName" name="projectName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">项目名称</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							价值度:
						</label>
					</td>
					<td class="value">
						<t:dictSelect field="worthStatus" type="list"  datatype="n"  typeGroupCode="worthStat"  hasLabel="false"  title="价值度" ></t:dictSelect>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">价值度</label>
					</td>
				</tr>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							价值低:
						</label>
					</td>
					<td class="value">
					     	 <input id="worthLow" name="worthLow" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价值低</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							价值中:
						</label>
					</td>
					<td class="value">
					     	 <input id="worthMid" name="worthMid" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价值中</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							价值高:
						</label>
					</td>
					<td class="value">
					     	 <input id="worthHigh" name="worthHigh" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">价值高</label>
						</td>
				</tr>--%>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合作状态:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="cooperateStatus" type="radio"  datatype="n"  typeGroupCode="cooperate"  defaultVal="${tBCustomerMapPage.cooperateStatus}" hasLabel="false"  title="合作状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合作状态</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/customermap/tBCustomerMap.js"></script>		
