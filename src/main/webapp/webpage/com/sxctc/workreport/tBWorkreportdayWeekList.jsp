<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBWorkreportdayWeekList" checkbox="true" pagination="true" fitColumns="true" title="周报" actionUrl="tBWorkreportdayWeekController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="厅局单位"  field="unitCode"  queryMode="group"  width="120" dictionary="unit_name"></t:dgCol>
   <t:dgCol title="迁移系统名称"  field="projectName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="周报日期开始"  field="reportStartDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="周报日期结束"  field="reportEndDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="今日完成的工作"  field="doneDay"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="未完成的工作"  field="unDoneDay"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="需要协调的工作"  field="coordinateWork"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="日志业务关联表id"  field="busiReportId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayWeekController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/week/tBWorkreportdayWeekList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBWorkreportdayWeekController.do?upload', "tBWorkreportdayWeekList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBWorkreportdayWeekController.do?exportXls","tBWorkreportdayWeekList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBWorkreportdayWeekController.do?exportXlsByT","tBWorkreportdayWeekList");
}

 </script>