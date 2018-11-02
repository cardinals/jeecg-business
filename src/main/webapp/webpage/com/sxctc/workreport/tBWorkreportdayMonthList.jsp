<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <c:if test="${toolFlag == '1'}">
  <t:datagrid name="tBWorkreportdayMonthList1" checkbox="false" pagination="true" sortName="reportDate" sortOrder="desc" fitColumns="false" title="月报" actionUrl="tBWorkreportdayMonthController.do?datagrid&reportOpt=0" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells" singleSelect="true">
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
   <t:dgCol title="月份"  field="reportDate"  formatter="yyyy-MM"  queryMode="single"  width="80" align="center"></t:dgCol>
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
   <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayMonthController.do?goUpdate&toolFlag=1&isCheck=1" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls1" operationCode="export"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </c:if>

  <c:if test="${toolFlag == '0'}">
  <t:datagrid name="tBWorkreportdayMonthList2" checkbox="false" pagination="true" sortName="reportDate" sortOrder="desc" fitColumns="false" title="月报" actionUrl="tBWorkreportdayMonthController.do?datagrid&reportOpt=1" idField="id" fit="true" queryMode="group" singleSelect="true" onLoadSuccess="mergeCells2">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"   queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="厅局编号"  field="unitCode" hidden="true" queryMode="single"  dictionary="unit_name"  width="120"></t:dgCol>
   <t:dgCol title="日报类型"  field="reportTitle"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="月份"  field="reportDate"  formatter="yyyy-MM"  queryMode="single"  width="80" align="center"></t:dgCol>
   <t:dgCol title="本月工作内容"  field="doneToday"  queryMode="single"  width="500" align="center"></t:dgCol>
   <t:dgCol title="下月工作计划"  field="nextDone" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="协调工作"  field="coordinateWork" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="本月工作总结"  field="workSum" hidden="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日志类型"  field="reportType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <%--<t:dgDelOpt title="删除" url="tBWorkreportdayMonthController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>--%>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBWorkreportdayMonthController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tBWorkreportdayMonthController.do?goUpdate&toolFlag=0" funname="update" operationCode="update"></t:dgToolBar>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBWorkreportdayMonthController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="tBWorkreportdayMonthController.do?goUpdate&toolFlag=0&isCheck=1" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls2" operationCode="export"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </c:if>
  </div>
 </div>
 <script src = "webpage/com/sxctc/workreport/tBWorkreportdayMonthList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBWorkreportdayMonthController.do?upload', "tBWorkreportdayMonthList");
}

//导出
function ExportXls1() {
	JeecgExcelExport("tBWorkreportdayMonthController.do?exportXls","tBWorkreportdayMonthList1");
}
//导出
function ExportXls2() {
    JeecgExcelExport("tBWorkreportdayMonthController.do?exportXls","tBWorkreportdayMonthList2");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBWorkreportdayMonthController.do?exportXlsByT","tBWorkreportdayMonthList");
}

function mergeCells(data) {
    var mark=1;
    for (var i=1; i <data.rows.length; i++) {
        if (data.rows[i]['unitCode'] == data.rows[i-1]['unitCode']) {
            mark += 1;
            $("#tBWorkreportdayMonthList1").datagrid('mergeCells',{
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
            $("#tBWorkreportdayMonthList1").datagrid('mergeCells',{
                index: i+1-mark,
                field: 'createName',
                rowspan:mark
            });
        }else{
            mark=1;
        }
    }
}

function mergeCells2(data) {
    var mark=1;
    for (var i=1; i <data.rows.length; i++) {
        if (data.rows[i]['createName'] == data.rows[i-1]['createName']) {
            mark += 1;
            $("#tBWorkreportdayMonthList2").datagrid('mergeCells',{
                index: i+1-mark,
                field: 'createName',
                rowspan:mark
            });
        }else{
            mark=1;
        }
    }
}
 </script>