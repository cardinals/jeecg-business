<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBWorkreportdayList" checkbox="true" pagination="true" fitColumns="false" title="日报列表" actionUrl="tBWorkreportdayController.do?datagrid&busiReportId=${busiReportId}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName" queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日报时间"  field="reportDate"  formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="厅局单位"  field="unitCode" queryMode="single" query="true" dictionary="unit_name"  width="120"></t:dgCol>
   <t:dgCol title="迁移系统名称"  field="projectName" queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="今日完成的工作"  field="doneDay"  queryMode="single"  width="350"></t:dgCol>
   <t:dgCol title="未完成的工作"  field="unDoneDay"  queryMode="single"  width="350"></t:dgCol>
   <t:dgCol title="需要协调的工作"  field="coordinateWork"  queryMode="single"  width="350"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="350"></t:dgCol>
   <t:dgCol title="日志业务关联表id"  field="busiReportId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <%--<t:dgDelOpt title="删除" url="tBWorkreportdayController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/workdays/tBWorkreportdayList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBWorkreportdayController.do?upload', "tBWorkreportdayList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBWorkreportdayController.do?exportXls","tBWorkreportdayList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBWorkreportdayController.do?exportXlsByT","tBWorkreportdayList");
}

 </script>