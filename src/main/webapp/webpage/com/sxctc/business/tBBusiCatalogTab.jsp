<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<div>
	<t:tabs id="tabsOne" iframe="true" heigth="470px" tabPosition="top" fit="false" width="870px">
		<t:tab href="tBBusiCatalogdataController.do?list&type=01&businessId=${businessId}" icon="icon-search" title="IAAS层" id="tabiaas"></t:tab>
		<t:tab href="tBBusiCatalogdataController.do?list&type=02&businessId=${businessId}" icon="icon-search" title="PAAS层" id="tabpaas"></t:tab>
		<t:tab href="tBBusiCatalogdataController.do?list&type=03&businessId=${businessId}" icon="icon-search" title="SAAS层" id="tabsaas"></t:tab>
		<t:tab href="tBBusiCatalogdataController.do?list&type=04&businessId=${businessId}" icon="icon-search" title="DAAS层" id="tabdaas"></t:tab>
	</t:tabs>
</div>