<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style>
 .datagrid-header-row td{background-color:#C5d9f1;color:#000}
</style>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBChancePoolList" checkbox="false" pagination="true" fitColumns="false" title="项目机会池" sortName="unitCode" actionUrl="tBChancePoolController.do?datagrid" idField="id" fit="true" queryMode="group" extendParams=""  onLoadSuccess="mergeCells" >
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy" hidden="true" queryMode="single"  width="110" align="center"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="200" align="center"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="项目预算(万元)"  field="projectBudget"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="软件和服务(万元)"  field="projectServer"  queryMode="single"  width="115" align="center"></t:dgCol>
   <t:dgCol title="硬件(万元)"  field="projectHardware"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="主要合作公司"  field="businessParters"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="竞争对手"  field="businessCompetitor"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="预计招标时间"  field="predictTenderTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="110" align="center"></t:dgCol>
   <t:dgCol title="资金来源"  field="fundsProvided"  queryMode="single"  dictionary="provide"  width="110" align="center"></t:dgCol>
   <t:dgCol title="上层关系"  field="topRelation"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="中层关系"  field="midRelation"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="下层关系"  field="bottomRelation"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="当年把控度"  field="controlDegree"  queryMode="single" dictionary="control"  width="100" align="center"></t:dgCol>
   <t:dgCol title="现状及下一步计划"  field="projectPlan"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="是否中标"  field="winningResult"  queryMode="single"  dictionary="dev_flag"  width="100" align="center"></t:dgCol>
   <t:dgCol title="业务主表id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tBChancePoolController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" operationCode="delete"/>
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

function mergeCells(data) {
    var mark=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
        if (data.rows[i]['unitCode'] == data.rows[i-1]['unitCode']) {   //后一行的值与前一行的值做比较，相同就需要合并
            mark += 1;
            $("#tBChancePoolList").datagrid('mergeCells',{
                index: i+1-mark,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'unitCode',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
        }else{
            mark=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
        }
    }
}
 </script>