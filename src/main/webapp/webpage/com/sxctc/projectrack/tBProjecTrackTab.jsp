<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
	<t:tabs id="tabsOne" iframe="true" heigth="870px" tabPosition="top" fit="false">
		<t:tab href="tBChancePoolController.do?list" icon="icon-search" title="项目机会池" id="tab1"></t:tab>
		<t:tab href="tBBusinessOpptyController.do?mainlist" icon="icon-search" title="商机评估表" id="tab2"></t:tab>
		<t:tab href="tBProfitTargetController.do?list" icon="icon-search" title="已签订项目" id="tab3"></t:tab>
		<t:tab href="tBCustomerMapController.do?list" icon="icon-search" title="客户地图" id="tab4"></t:tab>
	</t:tabs>
</div>