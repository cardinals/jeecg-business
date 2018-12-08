<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jeecg 微云快速开发平台</title>
    <link href="plug-in/hplus/css/style.css?v=4.1.0" rel="stylesheet">
    <link href="plug-in/hplus/css/plugins/jQueryUI/jquery-ui-1.10.4.custom.min.css" rel="stylesheet">
    <!-- Jquery组件引用 -->
    <script src="plug-in/jquery/jquery-1.9.1.js"></script>
    <script src="plug-in/lhgDialog/lhgdialog.min.js?skin=metrole"></script>
    <!-- bootstrap组件引用 -->
    <link href="plug-in/bootstrap3.3.5/css/bootstrap.min.css" rel="stylesheet">
    <script src="plug-in/bootstrap3.3.5/js/bootstrap.min.js"></script>

    <!-- bootstrap table组件以及中文包的引用 -->
    <link href="plug-in/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <script src="plug-in/bootstrap-table/bootstrap-table.js"></script>
    <script src="plug-in/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <!-- Layer组件引用 -->
    <script src="plug-in/layer/layer.js"></script>
    <script src="plug-in/laydate/laydate.js"></script>

    <!-- 通用组件引用 -->
    <link href="plug-in/bootstrap3.3.5/css/default.css" rel="stylesheet" />
    <script src="plug-in/themes/bootstrap-ext/js/bootstrap-curdtools.js"></script>
    <script src="plug-in/hplus/contabs.js"></script>
    <script src="plug-in/hplus/jquery-smartMenu.js"></script>
    <script src="plug-in/hplus/hplus-tab.js"></script>

</head>

<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">
            <c:if test="${reportOpt != 1}">
            <h5 class="text-danger">您好，${realName}，您今天还没有填写今日日报，<a href="javascript:goAddTabs({id:'report1',title:'日报',close: false,url: 'tBBusiWorkreportController.do?mainlist'});">点击填写今日日报</a></h5>
            </c:if>
            <c:if test="${reportWeekOpt != 2 && reportOpt == 1}">
            <h5 class="text-danger">您好，${realName}，您还没有填写周报，<a href="javascript:goAddTabs({id:'report2',title:'周报',close: false,url: 'tBWorkreportdayWeekController.do?mainlist'});">点击填写周报</a></h5>
            </c:if>
            <c:if test="${reportMonthOpt != 3 && reportWeekOpt == 2 && reportOpt == 1}">
            <h5 class="text-danger">您好，${realName}，您还没有填写月报，<a href="javascript:goAddTabs({id:'report3',title:'月报',close: false,url: 'tBWorkreportdayMonthController.do?mainlist'});">点击填写月报</a></h5>
            </c:if>
        </blockquote>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">

        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-6">

        </div>
        <div class="col-sm-6">

        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">

    </div>
</div>

</body>

</html>
