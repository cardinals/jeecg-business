<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style>
 .datagrid-header-row td{background-color:#C5d9f1;color:#000}
</style>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBChancePoolList" checkbox="false" pagination="true" fitColumns="false" title="项目机会池" actionUrl="tBChancePoolController.do?datagrid" idField="id" fit="true" queryMode="group" extendParams="" >
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="120"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目预算(万元)"  field="projectBudget"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="软件和服务(万元)"  field="projectServer"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="硬件(万元)"  field="projectHardware"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="主要合作公司"  field="businessParters"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="竞争对手"  field="businessCompetitor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="预计招标时间"  field="predictTenderTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="资金来源"  field="fundsProvided"  queryMode="single"  dictionary="provide"  width="120"></t:dgCol>
   <t:dgCol title="上层关系"  field="topRelation"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="中层关系"  field="midRelation"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="下层关系"  field="bottomRelation"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="当年把控度"  field="controlDegree"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="现在及下一步计划"  field="projectPlan"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否中标"  field="winningResult"  queryMode="single"  dictionary="dev_flag"  width="120"></t:dgCol>
   <t:dgCol title="业务主表id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <t:dgDelOpt title="删除" url="tBChancePoolController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBChancePoolController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBChancePoolController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBChancePoolController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tBChancePoolController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/projectrack/tBChancePoolList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBChancePoolController.do?upload', "tBChancePoolList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBChancePoolController.do?exportXls","tBChancePoolList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBChancePoolController.do?exportXlsByT","tBChancePoolList");
}

 </script>