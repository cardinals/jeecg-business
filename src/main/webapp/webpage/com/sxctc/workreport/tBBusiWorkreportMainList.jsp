<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
   <div region="center" style="padding:0px;border:0px;overflow-x:hidden;">
   <iframe id="mainList" src="${webRoot}/tBBusiWorkreportController.do?list&toolFlag=1" frameborder="0" height="70%" width="100%"></iframe>
   <div id="accDiv" class="easyui-accordion" style="padding-right:15px;overflow-x:hidden;box-sizing: border-box;">
		<div title="个人日报" data-options="iconCls:'icon-ok'" style="overflow:auto;box-sizing: border-box;">
			<iframe id="customerList" height="250" src="${webRoot}/tBBusiWorkreportController.do?list&toolFlag=0" frameborder="0" width="100%" ></iframe>
		</div>
		<%--<div title="title" data-options="iconCls:'icon-ok'" style="overflow:auto;">
			放置子表的框框
		</div>--%>
  </div>
  </div>
</div>
<script type="text/javascript">
	function getCustomerList(id){
		$("#customerList")[0].contentWindow.getCustomerList(id);
	}

	$(function(){
		var abc = parseInt(document.body.clientWidth)-17;
		$("#accDiv").css("width", abc);
	});

</script>