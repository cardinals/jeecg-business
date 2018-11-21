<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBBusinessList" checkbox="true" pagination="true" pageSize="30" sortName="createName,unitCode" title="上云业务列表" actionUrl="tBBusinessController.do?datagrid" idField="id" fit="true" queryMode="group" fitColumns="false" singleSelect="false" onLoadSuccess="mergeCells" extendParams="onSelect:function(index,row){datagridSelect(index,row);}">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName" align="center"  queryMode="single"  width="85"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="80"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="200" align="center"></t:dgCol>
   <t:dgCol title="厅局名称"  field="unitName"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="迁移系统编号"  field="projectCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="系统名称"  field="projectName"  queryMode="single"  width="200" align="center"></t:dgCol>
   <t:dgCol title="资金来源"  field="fundsProvided" queryMode="single"  dictionary="provide"  width="100" align="center"></t:dgCol>
   <t:dgCol title="是否审计系统"  field="auditStatus"  queryMode="single"  dictionary="dev_flag"  width="95" align="center"></t:dgCol>
   <t:dgCol title="系统状态"  field="projectStatus"  queryMode="single"  dictionary="proj_type"  width="70" align="center"></t:dgCol>
   <t:dgCol title="是否上云"  field="cloudStatus" hidden="true" queryMode="single"  dictionary="dev_flag"  width="80"></t:dgCol>
   <t:dgCol title="是否跟踪"  field="chanceStatus"  queryMode="single"  dictionary="dev_flag"  width="70" align="center"></t:dgCol>
   <t:dgCol title="上云工作状态"  field="joinStatus"  queryMode="single"  dictionary="joinStatus"  width="160" extendParams="styler:fmtype" align="center"></t:dgCol>
   <t:dgCol title="业务创建时间"  field="busCreateTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="首次对接时间"  field="busJoinTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="硬件服务目录"  field="hardServeCatalog"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="基础层服务目录"  field="baseServeCatalog"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否收回协议"  field="protocolStatus" hidden="true" queryMode="single"  dictionary="dev_flag"  width="120"></t:dgCol>
   <t:dgCol title="取得需求表时间"  field="demandTime" queryMode="single" formatter="yyyy-MM-dd" width="120" align="center"></t:dgCol>
   <t:dgCol title="签订方案时间"  field="planTime" queryMode="single" formatter="yyyy-MM-dd" width="120" align="center"></t:dgCol>
   <t:dgCol title="分配资源时间"  field="resourceTime" queryMode="single" formatter="yyyy-MM-dd" width="120" align="center"></t:dgCol>
   <t:dgCol title="上云测试时间"  field="testTime" queryMode="single" formatter="yyyy-MM-dd" width="120" align="center"></t:dgCol>
   <t:dgCol title="收回协议时间"  field="protocolTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="上云完成时间"  field="finishTime" queryMode="single" formatter="yyyy-MM-dd" width="120" align="center"></t:dgCol>
   <t:dgCol title="时间跨越"  field="dayRange"  queryMode="single"  width="70" align="center"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150" align="center"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBBusinessController.do?doDel&id={id}" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o" operationCode="delete"/>
   <t:dgFunOpt title="服务目录" urlclass="ace_button" urlfont="fa fa-user" funname="checkCatalog(id)" operationCode="catalog" exp="joinStatus#ne#0"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="tBBusinessController.do?goAdd" funname="add" operationCode="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBBusinessController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBBusinessController.do?doBatchDel" funname="deleteALLSelect" operationCode="batchDelete"></t:dgToolBar>--%>
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
    if (value == 7) {
        return 'background-color:#7CCD7C;color:#fff;';
    }
    return 'background-color:FFB90F;color:#fff;';
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

 function mergeCells(data) {
     var mark=1;
     for (var i=1; i <data.rows.length; i++) {
         if (data.rows[i]['unitCode'] == data.rows[i-1]['unitCode']) {
             mark += 1;
             $("#tBBusinessList").datagrid('mergeCells',{
                 index: i+1-mark,
                 field: 'unitCode',
                 rowspan:mark
             });
         }else{
             mark=1;
         }
     }
     var mark=1;
     for (var i=1; i <data.rows.length; i++) {
         if (data.rows[i]['createName'] == data.rows[i-1]['createName']) {
             mark += 1;
             $("#tBBusinessList").datagrid('mergeCells',{
                 index: i+1-mark,
                 field: 'createName',
                 rowspan:mark
             });
         }else{
             mark=1;
         }
     }
 }

 window.top["reload_businessTab"] = function (a) {
     $("#tBBusinessList").datagrid({
         queryParams: {
             createBy: a
         }
     });
 };

 /**
  * 选中事件加载子表数据
  */
 function datagridSelect(index,row){
     var optFlag = "${optFlag}";
     if (optFlag=="1"){
         $('#tBBusinessList').datagrid('unselectAll');
         var url = "userProgramController.do?programSequence&businessId="+row.id;
         $.dialog({
             content: "url:"+url,
             lock : true,
             title:'上云时序图',
             opacity : 0.3,
             width:900,
             height:500,
             cache:false
         });
     }
 }
 </script>