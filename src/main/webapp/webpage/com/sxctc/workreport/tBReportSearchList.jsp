<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
   <c:if test="${toolFlag ==  1}">
   <t:datagrid name="tBWorkreportdayList" checkbox="true" pagination="true" sortName="reportDate" sortOrder="desc" fitColumns="false" title="日报列表" actionUrl="tBWorkreportdayController.do?datagrid" idField="id" fit="true" queryMode="group" singleSelect="true">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName" queryMode="single" width="120" align="center"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日报时间"  field="reportDate"  formatter="yyyy-MM-dd" query="true" queryMode="group"  width="120" align="center"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="厅局单位"  field="unitCode" queryMode="single" dictionary="unit_name"  width="150" align="center"></t:dgCol>
   <t:dgCol title="迁移系统名称"  field="projectName" queryMode="single" width="150"></t:dgCol>
   <t:dgCol title="今日完成的工作"  field="doneDay"  queryMode="single"  width="350" align="center"></t:dgCol>
   <t:dgCol title="未完成的工作"  field="unDoneDay"  queryMode="single"  width="350" align="center"></t:dgCol>
   <t:dgCol title="需要协调的工作"  field="coordinateWork"  queryMode="single"  width="350" align="center"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="350" align="center"></t:dgCol>
   <t:dgCol title="日志业务关联表id"  field="busiReportId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
  <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
  <%--<t:dgDelOpt title="删除" url="tBWorkreportdayController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
  <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayController.do?goAdd" funname="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayController.do?goUpdate&toolFlag=0" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls1" operationCode="export"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>&ndash;%&gt;--%>
  </t:datagrid>
  </c:if>

  <c:if test="${toolFlag == 2}">
   <t:datagrid name="tBWorkreportdayWeekList" checkbox="true" pagination="true" sortName="reportStartDate" sortOrder="desc" fitColumns="false" title="周报" actionUrl="tBWorkreportdayWeekController.do?datagrid&reportType=9" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells" singleSelect="true">
    <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  queryMode="group"  width="120" align="center"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="厅局单位"  field="unitCode"  queryMode="group"  width="150" dictionary="unit_name" align="center"></t:dgCol>
    <t:dgCol title="系统名称"  field="projectName"  queryMode="group"  width="150" align="center"></t:dgCol>
    <t:dgCol title="周报日期开始"  field="reportStartDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="140" align="center"></t:dgCol>
    <t:dgCol title="周报日期结束"  field="reportEndDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="140" align="center"></t:dgCol>
    <t:dgCol title="本周工作内容"  field="doneDay"  queryMode="group"  width="140" align="center"></t:dgCol>
    <t:dgCol title="下周工作计划"  field="nextDone"  queryMode="group"  width="150" align="center"></t:dgCol>
    <t:dgCol title="需要协调的工作"  field="coordinateWork"  queryMode="group"  width="150" align="center"></t:dgCol>
    <t:dgCol title="本周工作总结"  field="workSum"  queryMode="single"  width="140" align="center"></t:dgCol>
    <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120" align="center"></t:dgCol>
    <t:dgCol title="日志业务关联表id"  field="businessId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
    <t:dgCol title="周报类型"  field="reportType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="搜索日期范围"  field="searchDate" formatter="yyyy-MM-dd" hidden="true" query="true" queryMode="group"  width="120"></t:dgCol>
    <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
    <%--<t:dgDelOpt title="删除" url="tBWorkreportdayWeekController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
    <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayWeekController.do?goAdd" funname="add"></t:dgToolBar>--%>
    <t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayWeekController.do?goUpdate&toolFlag=1" funname="update" operationCode="update"></t:dgToolBar>
    <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayWeekController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
    <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayWeekController.do?goUpdate&toolFlag=1" funname="detail"></t:dgToolBar>
    <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls2" operationCode="export"></t:dgToolBar>
    <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   </t:datagrid>
  </c:if>

  <c:if test="${toolFlag == 3}">
   <t:datagrid name="tBWorkreportdayMonthList" checkbox="false" pagination="true" sortName="reportDate" sortOrder="desc" fitColumns="false" title="月报" actionUrl="tBWorkreportdayMonthController.do?datagrid&reportType=9" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells" singleSelect="true">
    <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120" align="center"></t:dgCol>
    <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="150" align="center"></t:dgCol>
    <t:dgCol title="系统名称"  field="reportTitle"  queryMode="single"  width="150" align="center"></t:dgCol>
    <t:dgCol title="月份"  field="reportDate"  formatter="yyyy-MM" query="true" queryMode="group"  width="120" align="center"></t:dgCol>
    <t:dgCol title="本月工作工作"  field="doneToday"  queryMode="single"  width="140" align="center"></t:dgCol>
    <t:dgCol title="下月工作计划"  field="nextDone"  queryMode="single"  width="140" align="center"></t:dgCol>
    <t:dgCol title="协调工作"  field="coordinateWork"  queryMode="single"  width="120" align="center"></t:dgCol>
    <t:dgCol title="本月工作总结"  field="workSum"  queryMode="single"  width="140" align="center"></t:dgCol>
    <t:dgCol title="日志类型"  field="reportType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <t:dgCol title="业务id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
    <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
    <%--<t:dgDelOpt title="删除" url="tBWorkreportdayMonthController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
    <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayMonthController.do?goAdd" funname="add"></t:dgToolBar>--%>
    <t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayMonthController.do?goUpdate&toolFlag=1" funname="update" operationCode="update"></t:dgToolBar>
    <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayMonthController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
    <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayMonthController.do?goUpdate&toolFlag=1" funname="detail"></t:dgToolBar>
    <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
    <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls3" operationCode="export"></t:dgToolBar>
    <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   </t:datagrid>
  </c:if>

   <c:if test="${toolFlag ==  0}">
    <t:datagrid name="tBWorkreportdayList" checkbox="true" pagination="true" fitColumns="false" title="日报列表" actionUrl="tBWorkreportdayController.do?datagrid&busiReportId=${busiReportId}" idField="id" fit="true" queryMode="group" singleSelect="true">
     <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="创建人名称"  field="createName" queryMode="single" width="120"></t:dgCol>
     <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="日报时间"  field="reportDate"  formatter="yyyy-MM-dd" queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="创建日期"  field="createDate"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
     <t:dgCol title="日志内容"  field="doneDay"  queryMode="single"  width="350"></t:dgCol>
     <t:dgCol title="日志业务关联表id"  field="busiReportId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
     <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
     <%--<t:dgDelOpt title="删除" url="tBWorkreportdayController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
     <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayController.do?goAdd" funname="add"></t:dgToolBar>
       <t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayController.do?goUpdate" funname="update"></t:dgToolBar>--%>
     <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
     <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayController.do?goUpdate&toolFlag=0" funname="detail"></t:dgToolBar>
     <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
     <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls" operationCode="export"></t:dgToolBar>
     <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
    </t:datagrid>
   </c:if>

   <c:if test="${empty toolFlag}">

   </c:if>
  </div>
 </div>
 <script src = "webpage/com/sxctc/workdays/tBWorkreportdayList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
     //给时间控件加上样式
     $("#tBWorkreportdayMonthListtb").find("input[name='reportDate_begin']").attr("class","Wdate").attr("style","height:30px;width:100px;").click(function(){WdatePicker({dateFmt:'yyyy-MM'});});
     $("#tBWorkreportdayMonthListtb").find("input[name='reportDate_end']").attr("class","Wdate").attr("style","height:30px;width:100px;").click(function(){WdatePicker({dateFmt:'yyyy-MM'});});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBWorkreportdayController.do?upload', "tBWorkreportdayList");
}

//导出
function ExportXls1() {
	JeecgExcelExport("tBWorkreportdayController.do?exportXls","tBWorkreportdayList");
}
 //导出
 function ExportXls2() {
     JeecgExcelExport("tBWorkreportdayWeekController.do?exportXls","tBWorkreportdayWeekList");
 }
 //导出
 function ExportXls3() {
     JeecgExcelExport("tBWorkreportdayMonthController.do?exportXls","tBWorkreportdayMonthList");
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