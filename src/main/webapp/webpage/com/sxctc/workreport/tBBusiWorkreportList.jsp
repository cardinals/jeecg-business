<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="tBBusiWorkreportList" checkbox="true" pagination="true" fitColumns="true" title="今日日报列表" actionUrl="tBBusiWorkreportController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="厅局名称"  field="unitCode"  queryMode="single" dictionary="unit_name" width="120"></t:dgCol>
   <t:dgCol title="迁移系统名称"  field="reportTitle"  queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="最近日报（绿色今日已写）"  field="reportDate"  queryMode="single"  width="120" formatter="yyyy-MM-dd" extendParams="styler:fmtype"></t:dgCol>
   <t:dgCol title="今日完成的工作"  field="doneToday"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="未完成的工作"  field="unDoneToday"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="需要协调的工作"  field="coordinateWork"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日报类型"  field="reportType" width="120" hidden="true"></t:dgCol>
   <t:dgCol title="业务id"  field="businessId"  width="120" hidden="true"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="200"></t:dgCol>
   <t:dgFunOpt title="本周日报" urlclass="ace_button"  funname="checkCatalog(id)"></t:dgFunOpt>
   <t:dgToolBar title="录入今日日报" icon="icon-add" url="tBWorkreportdayController.do?goUpdate" funname="update" operationCode="update"></t:dgToolBar>
   <t:dgToolBar title="查看最近日报" icon="icon-search" url="tBBusiWorkreportController.do?goUpdate" funname="detail"></t:dgToolBar>
   <%--<t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/sxctc/workreport/tBBusiWorkreportList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'tBBusiWorkreportController.do?upload', "tBBusiWorkreportList");
}

//导出
function ExportXls() {
	JeecgExcelExport("tBBusiWorkreportController.do?exportXls","tBBusiWorkreportList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("tBBusiWorkreportController.do?exportXlsByT","tBBusiWorkreportList");
}

function checkCatalog(id) {
    var url = "tBWorkreportdayController.do?list&busiReportId="+id;
    $.dialog({
        content: "url:"+url,
        lock : true,
        title:'本周日报',
        opacity : 0.3,
        width:900,
        height:500,
        cache:false
    });
}

function fmtype(value,row,index) {
    var time = new Date().Format("yyyy-MM-dd");
    value = value.substring(0,10);
    if (value == time) {
        return 'background-color:#7CCD7C;color:#fff;';
    }
    return null;
}

Date.prototype.Format = function (fmt) { // author: meizz
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
 </script>