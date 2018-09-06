<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<t:tabs id="tabsOne" iframe="true" tabPosition="top" fit="true">
	<t:tab href="tBReportSearchController.do?list&toolFlag=1" icon="icon-search" title="日报搜索" id="tab1"></t:tab>
	<t:tab href="tBReportSearchController.do?list&toolFlag=2" icon="icon-search" title="周报搜索" id="tab2"></t:tab>
	<t:tab href="tBReportSearchController.do?list&toolFlag=3" icon="icon-search" title="月报搜索" id="tab3"></t:tab>
	<%--<t:tab href="tBCustomerMapController.do?list" icon="icon-search" title="客户地图" id="tab4"></t:tab>--%>
</t:tabs>
<script type="text/javascript">
	$(function () {
		$("#tabsOne").attr("height", document.documentElement.scrollHeight);
    })
</script>