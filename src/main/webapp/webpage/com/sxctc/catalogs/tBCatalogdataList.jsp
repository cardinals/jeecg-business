<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBCatalogdataList" checkbox="true" pagination="true" treegrid="true" treeField="name" fitColumns="true" title="服务目录管理" actionUrl="tBCatalogdataController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="名称"  field="name"  queryMode="single"  width="260"></t:dgCol>
   <t:dgCol title="单位"  field="danwei"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="父节点ID"  field="fartherid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="num"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="beizhu"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBCatalogdataController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tBCatalogdataController.do?goAdd" funname="add" width="600" height="280"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBCatalogdataController.do?goUpdate" funname="updatetree" width="600" height="280"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBCatalogdataController.do?doBatchDel" funname="deleteALLSelecttree"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tBCatalogdataController.do?goUpdate" funname="detailtree" width="600" height="280"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/catalogt/tBCatalogdataList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
		$("#tBCatalogdataList").treegrid({
 				 onExpand : function(row){
 					var children = $("#tBCatalogdataList").treegrid('getChildren',row.id);
 					 if(children.length<=0){
 					 	row.leaf=true;
 					 	$("#tBCatalogdataList").treegrid('refresh', row.id);
 					 }
 				}
 		});
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBCatalogdataController.do?upload', "tBCatalogdataList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBCatalogdataController.do?exportXls","tBCatalogdataList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBCatalogdataController.do?exportXlsByT","tBCatalogdataList");
}

/**
 * 获取表格对象
 * @return 表格对象
 */
function getDataGrid(){
	var datagrid = $('#'+gridname);
	return datagrid;
}
 </script>