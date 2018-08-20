<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBBusinessList" checkbox="true" pagination="true" title="上云业务列表" actionUrl="tBBusinessController.do?datagrid" idField="id" fit="true" queryMode="group" fitColumns="false" singleSelect="true">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"   queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="厅局名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="200"></t:dgCol>
   <t:dgCol title="厅局名称"  field="unitName"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="迁移系统编号"  field="projectCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="迁移系统名称"  field="projectName"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="系统类型"  field="projectStatus"  queryMode="single"  dictionary="proj_type"  width="80"></t:dgCol>
   <t:dgCol title="是否上云"  field="cloudStatus"  queryMode="single"  dictionary="dev_flag"  width="80"></t:dgCol>
   <t:dgCol title="是否有机会"  field="chanceStatus"  queryMode="single"  dictionary="dev_flag"  width="80"></t:dgCol>
   <t:dgCol title="对接状态"  field="joinStatus"  queryMode="single"  dictionary="joinStatus"  width="80" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="业务创建时间"  field="busCreateTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="业务对接时间"  field="busJoinTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="硬件服务目录"  field="hardServeCatalog"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="基础层服务目录"  field="baseServeCatalog"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否收回协议"  field="protocolStatus"  queryMode="single"  dictionary="dev_flag"  width="100"></t:dgCol>
   <t:dgCol title="收回协议时间"  field="protocolTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="150"></t:dgCol>
   <t:dgCol title="是否在审计范围"  field="auditStatus"  queryMode="single"  hidden="true"  dictionary="dev_flag"  width="120"></t:dgCol>
   <t:dgCol title="备用字段1"  field="backupField1"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段2"  field="backupField2"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段3"  field="backupField3"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段4"  field="backupField4"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段5"  field="backupField5"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备用字段6"  field="backupField6"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="200"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBBusinessController.do?doDel&id={id}" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o" operationCode="delete"/>
   <t:dgFunOpt title="服务目录" urlclass="ace_button" urlfont="fa fa-user" funname="checkCatalog(id)" operationCode="catalog" exp="joinStatus#eq#1"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="tBBusinessController.do?goAdd" funname="add" operationCode="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBBusinessController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBBusinessController.do?doBatchDel" funname="deleteALLSelect" operationCode="batchDelete"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="tBBusinessController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBBusinessController.do?upload', "tBBusinessList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBBusinessController.do?exportXls","tBBusinessList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBBusinessController.do?exportXlsByT","tBBusinessList");
}

function fmtype(value,row,index) {
    if (value == 0) {
        return 'background-color:#FF4040;color:#fff;';
    }
    return 'background-color:#7CCD7C;color:#fff;';
}

function checkCatalog(id) {
    var url = "tBBusiCatalogdataController.do?tablist&businessId="+id;
    $.dialog({
        content: "url:"+url,
        lock : true,
        title:'服务目录',
        opacity : 0.3,
        width:900,
        height:500,
        cache:false
    });
}

 //回调函数存储选中的值
 function callbackDelegateDepartSelect() {
     var iframe = this.iframe.contentWindow;
     //var id = iframe.getCheckboxVal(id);
     var id=iframe.gettBCatalogdataListSelections('id').toString();
     var num=iframe.gettBCatalogdataListSelections('num');
     var busiId = $("#tBBusinessList").datagrid("getSelected");
     if( Number(num) == 0){

     }
     $.ajax({
         url:"tBBusiCatalogController.do?doAdd",
         type:"post",
         data:{
             catalogId:id,
             businessId:busiId.id,
             checkNum: Number(num)
         },
         dataType:"json",
         success:function(data){
             tip(data.msg);
             if(data.success){
                 return;
             }
         }
     });
     //alert(departName);
     // $("#"+delegateCompanyIdEleId).val($("#"+delegateCompanyIdEleId).val()+id);
     // $("#"+delegateCompanyNameEleId).val($("#"+delegateCompanyNameEleId).val()+departName);
     // $("#"+delegateCompanyNameEleId).blur();
 }
 </script>