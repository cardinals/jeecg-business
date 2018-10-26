<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBFinalformExportList" checkbox="false" pagination="false" sortName="unitCode" fitColumns="false" title="财务报表导出" actionUrl="tBFinalformExportController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="报表年份"  field="businessDate" hidden="true"  queryMode="group" query="true"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name" query="true"  width="200" align="center"></t:dgCol>
   <t:dgCol title="系统名称"  field="systemName"  queryMode="single"  width="200" query="true" align="center"></t:dgCol>
   <t:dgCol title="上云收入(万元)"  field="cloudCount"  queryMode="single"  width="150" align="center"></t:dgCol>
   <t:dgCol title="项目收入(万元)"  field="projectCount"  queryMode="single"  width="150" align="center"></t:dgCol>
   <t:dgCol title="合计收入(万元)"  field="totalCount"  queryMode="single"  width="150" align="center"></t:dgCol>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/finalform/tBFinalformExportList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
     //给时间控件加上样式
     $("#tBFinalformExportListtb").find("input[name='businessDate_begin']").attr("class","Wdate").attr("style","height:30px;width:100px;").click(function(){WdatePicker({dateFmt:'yyyy'})});
     $("#tBFinalformExportListtb").find("input[name='businessDate_end']").attr("class","Wdate").attr("style","height:30px;width:100px;").click(function(){WdatePicker({dateFmt:'yyyy'});});
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