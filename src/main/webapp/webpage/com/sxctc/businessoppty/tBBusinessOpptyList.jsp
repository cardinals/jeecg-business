<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBBusinessOpptyList" checkbox="false" sortName="opptyRange,sortNum" pagination="true" fitColumns="false" title="商机评估结果（赢单区、输单区和抖动区）" actionUrl="tBBusinessOpptyController.do?datagrid" idField="id" fit="true" queryMode="group" onLoadSuccess="mergeCells" pageSize="30"  >
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>

   <%--<t:dgCol title="列表标签" colspan="9" newColumn="true"></t:dgCol>--%>
   <t:dgCol title="" colspan="1"></t:dgCol>
   <t:dgCol title="评估值" colspan="3"></t:dgCol>
   <t:dgCol title="" colspan="5"></t:dgCol>
   <%--<t:dgCol title="" rowspan="1"  width="120"></t:dgCol>--%>
   <%--<t:dgCol title="入职状态"  field="status" rowspan="2"></t:dgCol>--%>
   <%--<t:dgCol title="创建日期"  field="createDate" rowspan="2" formatter="yyyy-MM-dd"  queryMode="group" editor="datebox" width="120"></t:dgCol>--%>
   <t:dgCol title="操作" field="opt" width="150"  newColumn="true" rowspan="2"></t:dgCol>

   <t:dgCol title=""  field="opptyRange"  queryMode="single"  dictionary="oppty"  width="120"></t:dgCol>
   <t:dgCol title=""  field="evaluateWin" queryMode="single"  width="120" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title=""  field="evaluateFirst"  queryMode="single"  width="120" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title=""  field="evaluateConfirm"  queryMode="single"  width="120" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="赢单率"  field="opptyRatio"  queryMode="single"  width="80" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title=""  field="opptyPoint"  queryMode="single"  width="120" dictionary="opptypoint" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="项目名称"  field="projectName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位编号"  field="unitCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务id"  field="businessId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务id"  field="sortNum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>

   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>--%>
   <t:dgDelOpt title="删除" url="tBBusinessOpptyController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o" exp="businessId#ne#"/>
   <%--<t:dgToolBar title="录入" icon="icon-add" url="tBBusinessOpptyController.do?goAdd" funname="add"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="编辑" icon="icon-edit" url="tBBusinessOpptyController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="批量删除"  icon="icon-remove" url="tBBusinessOpptyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="查看" icon="icon-search" url="tBBusinessOpptyController.do?goUpdate" funname="detail"></t:dgToolBar>--%>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>--%>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <%--<t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/businessoppty/tBBusinessOpptyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBBusinessOpptyController.do?upload', "tBBusinessOpptyList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBBusinessOpptyController.do?exportXls","tBBusinessOpptyList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBBusinessOpptyController.do?exportXlsByT","tBBusinessOpptyList");
}

function mergeCells(data) {
    var mark=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
        if (data.rows[i]['opptyRange'] == data.rows[i-1]['opptyRange']) {   //后一行的值与前一行的值做比较，相同就需要合并
            mark += 1;
            $("#tBBusinessOpptyList").datagrid('mergeCells',{
                index: i+1-mark,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'opptyRange',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
        }else{
            mark=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
        }
    }

    // var mark2=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    // for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
    //     if (data.rows[i]['createName'] == data.rows[i-1]['createName']) {   //后一行的值与前一行的值做比较，相同就需要合并
    //         mark2 += 1;
    //         $("#tBBusinessOpptyList").datagrid('mergeCells',{
    //             index: i+1-mark2,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
    //             field: 'createName',                 //合并单元格的区域，就是clomun中的filed对应的列
    //             rowspan:mark2                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
    //         });
    //     }else{
    //         mark2=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
    //     }
    // }

    var mark3=1;                                                 //这里涉及到简单的运算，mark是计算每次需要合并的格子数
    for (var i=1; i <data.rows.length; i++) {     //这里循环表格当前的数据
        if (data.rows[i]['evaluateConfirm'] == data.rows[i-1]['evaluateConfirm'] && data.rows[i]['evaluateWin'] == data.rows[i-1]['evaluateWin'] && data.rows[i]['evaluateFirst'] == data.rows[i-1]['evaluateFirst']) {   //后一行的值与前一行的值做比较，相同就需要合并
            mark3 += 1;
            $("#tBBusinessOpptyList").datagrid('mergeCells',{
                index: i+1-mark3,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'evaluateConfirm',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark3                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
            $("#tBBusinessOpptyList").datagrid('mergeCells',{
                index: i+1-mark3,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'evaluateWin',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark3                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
            $("#tBBusinessOpptyList").datagrid('mergeCells',{
                index: i+1-mark3,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'evaluateFirst',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark3                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
            $("#tBBusinessOpptyList").datagrid('mergeCells',{
                index: i+1-mark3,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'opptyPoint',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark3                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
            $("#tBBusinessOpptyList").datagrid('mergeCells',{
                index: i+1-mark3,                 //datagrid的index，表示从第几行开始合并；紫色的内容需是最精髓的，就是记住最开始需要合并的位置
                field: 'opptyRatio',                 //合并单元格的区域，就是clomun中的filed对应的列
                rowspan:mark3                   //纵向合并的格数，如果想要横向合并，就使用colspan：mark
            });
        }else{
            mark3=1;                                         //一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
        }
    }

    //window.parent.document.getElementById("mainList").contentWindow.location.reload(true);
}

function fmtype(value,row,index) {
    var opptyPoint = row.opptyPoint;
    if (opptyPoint == 1 || opptyPoint == 2) {
        return 'background-color:#FFB802;';
    }
}
 </script>