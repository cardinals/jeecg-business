<%@ taglib prefix="c" uri="/jodd" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Jeecg 微云快速开发平台</title>

    <link rel="shortcut icon" href="images/favicon.ico">
    <link href="plug-in/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="plug-in/hplus/css/animate.css" rel="stylesheet">
    <link href="plug-in/hplus/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">
            <h1 class="text-warning" style="font-weight: bold;color:#4F5050">政务云营销大数据管理系统</h1>
            <h4 class="text-danger">欢迎光临</h4>
            <%--<iframe id="fancybox-frame" name="fancybox-frame1533801934382" frameborder="0" scrolling="no" hspace="0" height="25px" style="margin-bottom: -7px;" src="http://i.tianqi.com/index.php?c=code&a=getcode&id=34&h=25&w=280&py=taiyuan"></iframe>--%>
        </blockquote>
        <hr>
    </div>
    <c:if test="${optFlag == 1}">
    <div class="col-sm-12">

        <div class="col-sm-4" id="pieChart2">

        </div>
        <div class="col-sm-4" id="pieChart3">

        </div>

        <div class="col-sm-4" id="pieChart4">

        </div>
        <div class="col-sm-4" id="pieChart5">

        </div>
        <hr>
    </div>
    <div class="col-sm-12">


    </div>
    </c:if>
</div>

<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="plug-in/hplus/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>

<!-- echart 初始化 -->
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<!-- 引入自定义echarts_home.js -->
<script type="text/javascript" src="webpage/echarts/echarts_home.js"></script>
</body>

</html>
