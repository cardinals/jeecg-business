<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>厅局管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBUnitManageController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tBUnitManagePage.id }"/>
					<input id="unitName" name="unitName" type="hidden" value="${tBUnitManagePage.unitName }"/>
					<input id="userName" name="userName" type="hidden" value="${tBUnitManagePage.userName }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							用户:
						</label>
					</td>
					<td class="value">
							<t:dictSelect id="userCode" field="userCode" dictTable="t_s_base_user" dictCondition="where delete_flag=0" dictField="username" dictText="realname" title="用户" defaultVal="${tBUnitManagePage.userCode}"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用户</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							单位编号:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect id="unitCode" field="unitCode" type="list"  datatype="n"  typeGroupCode="unit_name"  defaultVal="${tBUnitManagePage.unitCode}" hasLabel="false"  title="单位编号" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位编号</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/unitManage/tBUnitManage.js"></script>
 <script type="text/javascript">
     $('#unitCode').change(function(){
         $("#unitName").val($('#unitCode option:selected').text());
     });
     $('#userCode').change(function(){
         $("#userName").val($('#userCode option:selected').text());
     });
 </script>
