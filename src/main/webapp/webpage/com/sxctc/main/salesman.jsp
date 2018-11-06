<%@ taglib prefix="c" uri="/jodd" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    <style type="text/css">
        ul{ padding:0px; margin:0px;}
        ol{ list-style:none; padding:0px; margin:0px; width:100%;
            height:20px; line-height:20px; border:1px solid #99CC00;
            border-top:0px; font-size:12px;}
        ol li{ display:block; width:33%; float:left;text-indent:2em}
        .th{ background:#F1FADE; font-weight:bold; border-top:1px }
        .left{
            float:left;
            width:10%;
            text-align: center;
        }
        .number_style{
            font-size: 40px;color: black;
        }

    </style>
</head>

<body class="gray-bg">
<div class="row  border-bottom white-bg dashboard-header">
    <div class="col-sm-12">
        <blockquote class="text-warning" style="font-size:14px">
            <%--<h1 class="text-warning" style="font-weight: bold;color:#4F5050">政务云营销大数据管理系统</h1>--%>
            <%--<h4 class="text-danger">欢迎光临</h4>--%>
            <%--<iframe id="fancybox-frame" name="fancybox-frame1533801934382" frameborder="0" scrolling="no" hspace="0" height="25px" style="margin-bottom: -7px;" src="http://i.tianqi.com/index.php?c=code&a=getcode&id=34&h=25&w=280&py=taiyuan"></iframe>--%>
        </blockquote>
        <%--<hr>--%>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <%--<div class="ibox-title">--%>
                    <%--<h5>最新公告</h5>--%>
                <%--</div>--%>
                <div class="ibox-content" style="height: 100px">
                    <div class="left">图图</div>
                    <div class="left"><div>系统总数</div><div class="number_style" id="projectTotalNum">49</div></div>
                    <div class="left"><div>未对接</div><div class="number_style" id="notDockSystemNum">11</div></div>
                    <div class="left"><div>上云对接</div><div class="number_style" id="cloudDockSystemNum">10</div></div>
                    <div class="left"><div>取得需求表</div><div class="number_style" id="researchFormSystemNum">10</div></div>
                    <div class="left"><div>签订方案</div><div class="number_style" id="signPlanSystemNum">10</div></div>
                    <div class="left"><div>分配资源</div><div class="number_style" id="allocatingResourcesSystemNum">10</div></div>
                    <div class="left"><div>上云测试</div><div class="number_style" id="cloudTestSystemNum">10</div></div>
                    <div class="left"><div>回收协议</div><div class="number_style" id="recoveryAgreementSystemNum">10</div></div>
                    <div class="left"><div>上云完成</div><div class="number_style" id="cloudCompleteNum">10</div></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>代办事项</h5>
                </div>
                <div class="ibox-content">
                    <ul style="height: 100px;overflow: auto;">
                    <ol>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                    </ol>
                    <ol>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                    </ol>
                    <ol>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                    </ol>
                    <ol>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                    </ol>
                    <ol>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                    </ol>
                    <ol>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                        <li>专业H5活动开发</li>
                    </ol>
                    </ul>
                </div>
            </div>
        </div>
        <div class="col-sm-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>系统状态</h5>
                </div>
                <div class="ibox-content">
                    <ul style="height: 100px;overflow: auto;">
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                    </ul>
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
                <div class="ibox-content">
                    <ul style="height: 100px;overflow: auto;">
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                        <ol>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                            <li>专业H5活动开发</li>
                        </ol>
                    </ul>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="plug-in/hplus/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>

<!-- echart 初始化 -->
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<!-- echart 初始化 -->
<script type="text/javascript" src="webpage/com/sxctc/main/salesman.js"></script>
</body>

</html>
