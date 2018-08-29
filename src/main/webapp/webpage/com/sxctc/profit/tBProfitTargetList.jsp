<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBProfitTargetList" checkbox="false" pagination="true" fitColumns="false" title="毛利润指标" actionUrl="tBProfitTargetController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="180"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  queryMode="single"  width="180"></t:dgCol>
   <t:dgCol title="项目令号"  field="projectOrder"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目经理"  field="projectManage"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同签订时间"  field="signTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同额"  field="contractValue"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="毛利率"  field="profitTargetRatio"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="毛利润"  field="profitTarget"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="确认收入额"  field="confirmIncome"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="确认收入比率"  field="confirmIncomeRatio"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回款总额"  field="receivedPay"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="回款比例"  field="receivedPayRatio"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="项目实施状态"  field="projectStatus"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <%--<t:dgDelOpt title="删除" url="tBProfitTargetController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBProfitTargetController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBProfitTargetController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBProfitTargetController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tBProfitTargetController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/profit/tBProfitTargetList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBProfitTargetController.do?upload', "tBProfitTargetList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBProfitTargetController.do?exportXls","tBProfitTargetList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBProfitTargetController.do?exportXlsByT","tBProfitTargetList");
}

 </script>