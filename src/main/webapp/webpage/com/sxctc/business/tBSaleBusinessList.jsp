<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBSaleBusinessList" checkbox="true" pagination="true" pageSize="30" sortName="createName,unitCode" actionUrl="tBBusinessController.do?saledatagrid" idField="id" fit="true" queryMode="group" fitColumns="false" singleSelect="true" onLoadSuccess="mergeCells">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="200" align="center"></t:dgCol>
   <t:dgCol title="系统名称"  field="projectName"  queryMode="single"  width="200" align="center"></t:dgCol>
   <t:dgCol title="系统状态"  field="projectStatus"  queryMode="single"  dictionary="proj_type"  width="70" align="center"></t:dgCol>
   <t:dgCol title="上云工作状态"  field="joinStatus"  queryMode="single"  dictionary="joinStatus"  width="160" extendParams="styler:fmtype" align="center"></t:dgCol>
   <t:dgCol title="业务创建时间"  field="busCreateTime"  formatter="yyyy-MM-dd"  queryMode="single"  width="120" align="center"></t:dgCol>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 $(document).ready(function(){
 });

function fmtype(value,row,index) {
    if (value == 0) {
        return 'background-color:#FF4040;color:#fff;';
    }
    if (value == 7) {
        return 'background-color:#7CCD7C;color:#fff;';
    }
    return 'background-color:FFB90F;color:#fff;';
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
 </script>