<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBProfitTargetList" checkbox="false" pagination="true" pageSize="30" sortName="createName,unitCode" fitColumns="false" title="毛利润指标" actionUrl="tBProfitTargetController.do?datagrid&userType=${userType}" idField="id" fit="true" queryMode="group"  onLoadSuccess="mergeCells" >
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="85" align="center"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="180" align="center"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  queryMode="single"  width="200" align="center"></t:dgCol>
   <t:dgCol title="项目令号"  field="projectOrder"  queryMode="single"  width="80" align="center"></t:dgCol>
   <t:dgCol title="项目经理"  field="projectManage"  queryMode="single"  width="80" align="center"></t:dgCol>
   <t:dgCol title="合同签订时间"  field="signTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="合同额(万元)"  field="contractValue"  queryMode="single"  width="90" align="center"></t:dgCol>
   <t:dgCol title="毛利率"  field="profitTargetRatio"  queryMode="single"  width="80" align="center"></t:dgCol>
   <t:dgCol title="毛利润(万元)"  field="profitTarget"  queryMode="single"  width="90" align="center"></t:dgCol>
   <t:dgCol title="确认收入额(万元)"  field="confirmIncome"  queryMode="single"  width="120" align="center"></t:dgCol>
   <t:dgCol title="确认收入比率"  field="confirmIncomeRatio"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="回款总额(万元)"  field="receivedPay"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="回款比例"  field="receivedPayRatio"  queryMode="single"  width="100" align="center"></t:dgCol>
   <t:dgCol title="项目实施状态"  field="projectStatus"  queryMode="single" dictionary="proj_stat"  width="120" align="center"></t:dgCol>
   <t:dgCol title="业务id"  field="businessId"  hidden="true"  queryMode="single"  width="120" align="center"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="60" align="center"></t:dgCol>--%>
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

function mergeCells(data) {
    var mark=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
        if (data.rows[i]['unitCode'] == data.rows[i-1]['unitCode']) {   //后一行的值与前一行的值做比较，相同就需要合并
            mark += 1;
            $("#tBProfitTargetList").datagrid('mergeCells',{
                index: i+1-mark,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'unitCode',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
        }else{
            mark=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
        }
    }
    var mark=1;
    for (var i=1; i <data.rows.length; i++) {
        if (data.rows[i]['createName'] == data.rows[i-1]['createName']) {
            mark += 1;
            $("#tBChancePoolList").datagrid('mergeCells',{
                index: i+1-mark,
                field: 'createName',
                rowspan:mark
            });
        }else{
            mark=1;
        }
    }
}

window.top["reload_profitTab"] = function (a) {
    $("#tBProfitTargetList").datagrid({
        queryParams: {
            createBy: a
        }
    });
};
 </script>