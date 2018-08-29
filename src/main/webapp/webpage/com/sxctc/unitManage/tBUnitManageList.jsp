<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBUnitManageList" checkbox="false" pagination="true" fitColumns="true" title="厅局管理" actionUrl="tBUnitManageController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用户"  field="userCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位编号"  field="unitCode"  hidden="true"  queryMode="single"  dictionary="unit_name"  width="120"></t:dgCol>
   <t:dgCol title="业务员工"  field="userName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="负责单位"  field="unitName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBUnitManageController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="tBUnitManageController.do?goAdd" funname="add"></t:dgToolBar>
	<%--<t:dgToolBar title="编辑" icon="icon-edit" url="tBUnitManageController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tBUnitManageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="tBUnitManageController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/unitManage/tBUnitManageList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBUnitManageController.do?upload', "tBUnitManageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBUnitManageController.do?exportXls","tBUnitManageList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBUnitManageController.do?exportXlsByT","tBUnitManageList");
}

function mergeCells(data) {
    var mark=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
        if (data.rows[i]['userName'] == data.rows[i-1]['userName']) {   //后一行的值与前一行的值做比较，相同就需要合并
            mark += 1;
            $("#tBUnitManageList").datagrid('mergeCells',{
                index: i+1-mark,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'userName',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
        }else{
            mark=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
        }
    }
}
 </script>