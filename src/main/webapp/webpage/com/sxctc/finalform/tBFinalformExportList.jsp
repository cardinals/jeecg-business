<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBFinalformExportList" checkbox="false" pagination="true" sortName="unitCode" fitColumns="false" title="财务报表导出" actionUrl="tBFinalformExportController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="bpmStatus"  hidden="true"  queryMode="single"  dictionary="bpm_status"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="200" align="center"></t:dgCol>
   <t:dgCol title="系统名称"  field="systemName"  queryMode="single"  width="200" align="center"></t:dgCol>
   <t:dgCol title="上云收入(万元)"  field="cloudCount"  queryMode="single"  width="150" align="center"></t:dgCol>
   <t:dgCol title="项目收入(万元)"  field="projectCount"  queryMode="single"  width="150" align="center"></t:dgCol>
   <t:dgCol title="合计收入(万元)"  field="totalCount"  queryMode="single"  width="150" align="center"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="80" align="center"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBFinalformExportController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBFinalformExportController.do?goAdd" funname="add"></t:dgToolBar>--%>
	<%--<t:dgToolBar title="编辑" icon="icon-edit" url="tBFinalformExportController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBFinalformExportController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="tBFinalformExportController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/finalform/tBFinalformExportList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBFinalformExportController.do?upload', "tBFinalformExportList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBFinalformExportController.do?exportXls","tBFinalformExportList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBFinalformExportController.do?exportXlsByT","tBFinalformExportList");
}

function mergeCells(data) {
    var mark=1;
    for (var i=1; i <data.rows.length; i++) {
        if (data.rows[i]['unitCode'] == data.rows[i-1]['unitCode']) {
            mark += 1;
            $("#tBFinalformExportList").datagrid('mergeCells',{
                index: i+1-mark,
                field: 'unitCode',
                rowspan:mark
            });
        }else{
            mark=1;
        }
    }
}
 </script>