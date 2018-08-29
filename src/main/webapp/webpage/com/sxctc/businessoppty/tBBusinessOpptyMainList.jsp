<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
   <div id="divMain" region="center" style="padding:0px;border:0px;overflow-x:hidden;">
       <div id="accDiv1" class="easyui-accordion" style="float: left;">
            <iframe id="mainList" src="${webRoot}/tBBusinessOpptyController.do?chancelist" frameborder="0" height="30%"></iframe>
           <%--<iframe id="businessOpptyList" height="400" src="${webRoot}/tBBusinessOpptyController.do?list" frameborder="0" width="50%" style="float: left"></iframe>--%>
           <%--<div style="height: 65%; width: 20%"><img src="webpage/com/sxctc/businessoppty/img/oppty.png" /></div>--%>
           <br>
           <img id="opptyId" src="webpage/com/sxctc/businessoppty/img/oppty.png"/>
       </div>
       <div id="accDiv2" class="easyui-accordion" style="float: left;">
           <iframe id="businessOpptyList" height="100%" src="${webRoot}/tBBusinessOpptyController.do?list" frameborder="0" ></iframe>
       </div>
  </div>
</div>
<script type="text/javascript">
	$(function () {
        var divMain = $('#divMain').width();
        $('#mainList').attr("width", divMain*0.4);
        $('#opptyId').attr("width", divMain*0.4);
        $('#businessOpptyList').attr("width", divMain*0.58);
    })
</script>