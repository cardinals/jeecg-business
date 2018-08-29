<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <c:if test="${toolFlag == '1'}">
  <t:datagrid name="tBWorkreportdayWeekList" checkbox="true" pagination="true" fitColumns="false" title="周报" actionUrl="tBWorkreportdayWeekController.do?datagrid&reportOpt=0" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="厅局单位"  field="unitCode"  queryMode="group"  width="120" dictionary="unit_name"></t:dgCol>
   <t:dgCol title="系统名称"  field="projectName"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="周报日期开始"  field="reportStartDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="周报日期结束"  field="reportEndDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本周工作内容"  field="doneDay"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="下周工作计划"  field="nextDone"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="需要协调的工作"  field="coordinateWork"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="本周工作总结"  field="workSum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="日志业务关联表id"  field="businessId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="周报类型"  field="reportType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <%--<t:dgDelOpt title="删除" url="tBWorkreportdayWeekController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayWeekController.do?goAdd" funname="add"></t:dgToolBar>--%>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayWeekController.do?goUpdate&toolFlag=1" funname="update" operationCode="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayWeekController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayWeekController.do?goUpdate&toolFlag=1" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </c:if>

  <c:if test="${toolFlag == '0'}">
   <t:datagrid name="tBWorkreportdayWeekList" checkbox="true" pagination="true" fitColumns="false" title="周报" actionUrl="tBWorkreportdayWeekController.do?datagrid&reportOpt=1" idField="id" fit="true" queryMode="group">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="80"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="厅局单位"  field="unitCode"  queryMode="group" hidden="true" width="120" dictionary="unit_name"></t:dgCol>
    <t:dgCol title="日报类型"  field="projectName" queryMode="group"  width="80"></t:dgCol>
    <t:dgCol title="周报日期开始"  field="reportStartDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="150"></t:dgCol>
    <t:dgCol title="周报日期结束"  field="reportEndDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="150"></t:dgCol>
    <t:dgCol title="工作内容"  field="doneDay"  queryMode="group"  width="500"></t:dgCol>
    <t:dgCol title="下周工作计划"  field="nextDone" hidden="true" queryMode="group"  width="250"></t:dgCol>
    <t:dgCol title="需要协调的工作"  field="coordinateWork" hidden="true" queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="本周工作总结"  field="workSum" hidden="true" queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="备注"  field="remark"  queryMode="group" hidden="true" width="120"></t:dgCol>
    <t:dgCol title="日志业务关联表id"  field="businessId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="周报类型"  field="reportType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
    <%--<t:dgDelOpt title="删除" url="tBWorkreportdayWeekController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
    <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayWeekController.do?goAdd" funname="add"></t:dgToolBar>--%>
    <t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayWeekController.do?goUpdate&toolFlag=0" funname="update" operationCode="update"></t:dgToolBar>
    <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayWeekController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
    <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayWeekController.do?goUpdate&toolFlag=0" funname="detail"></t:dgToolBar>
    <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
    <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
    <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   </t:datagrid>
  </c:if>
  </div>
 </div>
 <script src = "webpage/com/sxctc/workreport/tBWorkreportdayWeekList.js"></script>		
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