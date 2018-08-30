<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBCustomerMapList" checkbox="false" sortName="cooperateStatus,createName" pagination="true" fitColumns="false" title="客户地图" actionUrl="tBCustomerMapController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合作状态"  field="cooperateStatus"  queryMode="single"  dictionary="cooperate"  width="120" extendParams="styler:fmtype1" align="center"></t:dgCol>
   <t:dgCol title="价值-低（500万以下）"  field="worthLow"  queryMode="single"  width="200" extendParams="styler:fmtype2" align="center"></t:dgCol>
   <t:dgCol title="价值-中（500—1000万）"  field="worthMid"  queryMode="single"  width="200" extendParams="styler:fmtype3" align="center"></t:dgCol>
   <t:dgCol title="价值-高（1000万以上）"  field="worthHigh"  queryMode="single"  width="200" extendParams="styler:fmtype4" align="center"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位编号"  field="unitCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100" align="center"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBCustomerMapController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tBCustomerMapController.do?goAdd" funname="add" operationCode="add"></t:dgToolBar>
	<t:dgToolBar title="编辑" icon="icon-edit" url="tBCustomerMapController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBCustomerMapController.do?doBatchDel" funname="deleteALLSelect" operationCode="deleteAll"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tBCustomerMapController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/customermap/tBCustomerMapList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBCustomerMapController.do?upload', "tBCustomerMapList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBCustomerMapController.do?exportXls","tBCustomerMapList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBCustomerMapController.do?exportXlsByT","tBCustomerMapList");
}

function mergeCells(data) {
    var mark=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
        if (data.rows[i]['cooperateStatus'] == data.rows[i-1]['cooperateStatus']) {   //后一行的值与前一行的值做比较，相同就需要合并
            mark += 1;
            $("#tBCustomerMapList").datagrid('mergeCells',{
                index: i+1-mark,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'cooperateStatus',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
        }else{
            mark=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
        }
    }
}

function fmtype1(value,row,index) {
    return 'background-color:#87C947;';
}
function fmtype2(value,row,index) {
    var cooperateStatus = row.cooperateStatus;
    if (cooperateStatus == 1) {
        return 'background-color:#8AAAD1;';
    }
    if (cooperateStatus == 2) {
        return 'background-color:#AFC5E0;';
    }
    if (cooperateStatus == 3) {
        return 'background-color:#D7E2EF;';
    }
}
function fmtype3(value,row,index) {
    var cooperateStatus = row.cooperateStatus;
    if (cooperateStatus == 1) {
        return 'background-color:#BDD190;';
    }
    if (cooperateStatus == 2) {
        return 'background-color:#D3E0B4;';
    }
    if (cooperateStatus == 3) {
        return 'background-color:#E8EFD9;';
    }
}
function fmtype4(value,row,index) {
    var cooperateStatus = row.cooperateStatus;
    if (cooperateStatus == 1) {
        return 'background-color:#F9B784;';
    }
    if (cooperateStatus == 2) {
        return 'background-color:#FCCFAB;';
    }
    if (cooperateStatus == 3) {
        return 'background-color:#FDE6D4;';
    }
}
 </script>