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
    <style type="text/css">
        .left{
            float:left;
            width:10%;
            height:100%;
            text-align: center;
        }
        .number_style{
            font-size: 44px;color: black;
        }
        .status {
            float: left;
            width: 80px;
            height: 30px;
            line-height: 30px;
            color: #fff;
            font-size: 12px;
            margin-right: 5px;
        }
        .status-content-0 {
            background-color: #E44743;
            border: 1px solid #E44743;
        }
        .status-content-1 {
            background-color: #4370E0;
            border: 1px solid #4370E0;
        }
        .status-content-2 {
            background-color: #CF5998;
            border: 1px solid #CF5998;
        }
        .status-content-3 {
            background-color: #4FBBE2;
            border: 1px solid #4FBBE2;
        }
        .status-content-4 {
            background-color: #ECAD40;
            border: 1px solid #ECAD40;
        }
        .status-content-5 {
            background-color: #9358B2;
            border: 1px solid #9358B2;
        }
        .status-content-6 {
            background-color: #B48058;
            border: 1px solid #B48058;
        }
        .status-content-7 {
            background-color: #76B46C;
            border: 1px solid #76B46C;
        }
    </style>
</head>

<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">
            <c:if test="${reportOpt != 1}">
            <h5 class="text-danger">您好，${realName}，您今天还没有填写今日日报，<a href="tBBusiWorkreportController.do?mainlist">点击填写今日日报</a></h5>
            </c:if>
            <c:if test="${reportWeekOpt != 2 && reportOpt == 1}">
            <h5 class="text-danger">您好，${realName}，您还没有填写周报，<a href="tBWorkreportdayWeekController.do?mainlist">点击填写周报</a></h5>
            </c:if>
            <c:if test="${reportMonthOpt != 3 && reportWeekOpt == 2 && reportOpt == 1}">
            <h5 class="text-danger">您好，${realName}，您还没有填写月报，<a href="tBWorkreportdayMonthController.do?mainlist">点击填写月报</a></h5>
            </c:if>
        </blockquote>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <%--<div class="ibox float-e-margins">--%>
                <%--<div class="ibox-title">--%>
                    <%--<h5>最新公告</h5>--%>
                <%--</div>--%>
                <div class="ibox-content" style="height: 125px;padding: 15px">
                    <div class="left"><div id="echarts_percent" style="width: 100%;height: 100%;"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">系统总数</div><div class="number_style" id="projectTotalNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">未对接</div><div class="number_style" id="notDockSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">上云对接</div><div class="number_style" id="cloudDockSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">取得需求表</div><div class="number_style" id="researchFormSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">签订方案</div><div class="number_style" id="signPlanSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">分配资源</div><div class="number_style" id="allocatingResourcesSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">上云测试</div><div class="number_style" id="cloudTestSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">回收协议</div><div class="number_style" id="recoveryAgreementSystemNum"></div></div>
                    <div class="left"><div style="font-size: 14px;margin-bottom: 10px;">上云完成</div><div class="number_style" id="cloudCompleteNum"></div></div>
                </div>
            </div>
        <%--</div>--%>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>待办事项</h5>
                    <button id="btn_add" type="button" class="btn btn-primary btn-sm" onclick="addTodo('新增','tBTodoListController.do?goAdd','tBTodoListList',600,400)">
                    <%--<button id="btn_add" type="button" class="btn btn-primary btn-sm" onclick="addTodo()">--%>
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
                    </button>
                </div>
                <div id="iboxContent" class="ibox-content" style="height: 28rem">
                    <table id="tBTodoListList"></table>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>系统状态</h5>
                </div>
                <div id="statusContent" class="ibox-content" style="height: 28rem">
                    <table id="tBStatusListList" style="min-width:1000px;"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>待跟进项目</h5>
                </div>
                <div id="followContent" class="ibox-content" style="overflow: auto; height: 43rem">
                    <table id="jeecgDemoList"></table>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- echart 初始化 -->
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<!-- 引入自定义js -->
<!-- 页面js -->
<script type="text/javascript" src="webpage/com/sxctc/main/salesman.js"></script>

</body>

</html>
