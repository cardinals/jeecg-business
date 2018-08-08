<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
	<t:tabs id="tabsOne" iframe="true" heigth="800px" tabPosition="top" fit="false">
		<t:tab href="tBCatalogdataController.do?list&type=01" icon="icon-search" title="IAAS层" id="tab1"></t:tab>
		<t:tab href="tBCatalogdataController.do?list&type=02" icon="icon-search" title="PAAS层" id="tab1"></t:tab>
		<t:tab href="tBCatalogdataController.do?list&type=03" icon="icon-search" title="SAAS层" id="tab1"></t:tab>
		<t:tab href="tBCatalogdataController.do?list&type=04" icon="icon-search" title="DAAS层" id="tab1"></t:tab>
	</t:tabs>
</div>