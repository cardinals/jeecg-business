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
<c:if test="${optFlag == 0}">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-4">

            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>最新公告</h5>
                </div>
                <div class="ibox-content">
                    <p>我们提供基于Jeecg的二次开发服务，具体费用请联系官方。</p>
                    <p>同时，我们也提供以下服务：</p>
                    <ol>
                        <li>Jeecg工作流开发平台 (商业版)</li>
                        <li>Jeewx微信管家 (商业版)</li>
                        <li>OA办公系统 (商业版)</li>
                        <li>专业H5活动开发</li>
                    </ol>
                </div>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>联系信息</h5>

                </div>
                <div class="ibox-content">
                    <p><i class="fa fa-send-o"></i> 官网：<a href="http://www.jeecg.org" target="_blank">http://www.jeecg.org</a>
                    </p>
                    <p><i class="fa fa-qq"></i> QQ群：<a href="javascript:;">190866569</a>
                    </p>
                    <p><i class="fa fa-weixin"></i>微信公众号：<a href="javascript:;">jeecg</a>
                    </p>
                    <p><i class="fa fa-credit-card"></i> 邮箱：<a href="javascript:;" class="邮箱">jeecg@sina.com</a>
                    </p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>使用教程</h5>
                </div>
                <div class="ibox-content">
                    <video width="100%" height="100" controls>
                        <source src="video/study.mp4" type="video/mp4">
                        您的浏览器不支持 HTML5 video 标签。
                    </video>
                    <hr>
                    <div class="alert alert-warning">JEECG智能开发平台，可以应用在任何J2EE项目的开发中，尤其适合企业信息管理系统（MIS）、内部办公系统（OA）、企业资源计划系统（ERP） 、客户关系管理系统（CRM）等，其半智能手工Merge的开发方式，可以显著提高开发效率60%以上，极大降低开发成本。
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>版本升级日志</h5>
                </div>
                <div class="ibox-content no-padding">
                    <div class="panel-body">
                        <div class="panel-group" id="version">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h5 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#version" href="#v54">v1.0.1</a><code class="pull-right">2018.08.09</code>
                                    </h5>
                                </div>
                                <div id="v54" class="panel-collapse collapse in">
                                    <div class="panel-body">
                                        <div class="alert alert-warning">此版本提供新一代风格代码生成器模板，采用Vue技术，提供两套精美模板 ElementUI风格、Bootstrap风格，追逐潮流技术支持移动端；</div>
                                        <ol>
                                            <li>【功能升级】新一代 (单表/一对多) 代码生成器模板，Vue+ElementUI风格功能优化升级;</li>
                                            <li>【功能升级】新一代 (单表) 代码生成器模板，Bootstrap表单+EasyUI原生态列表风格功能优化升级;</li>
                                        </ol>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h5 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#version" href="#v53">v1.0.0</a><code class="pull-right">2018.07.25</code>
                                    </h5>
                                </div>
                                <div id="v53" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        <div class="alert alert-warning">此版本提供新一代风格代码生成器模板，采用Vue技术，提供两套精美模板 ElementUI风格、Bootstrap风格，追逐潮流技术支持移动端；</div>
                                        <ol>
                                            <li>【新增功能】新一代更灵活的代码生成器工厂，可灵活自定义生成的代码文件名称、路径等；根据模板结构生成代码文件;</li>
                                            <li>【新增功能】新一代 (单表/一对多) 代码生成器模板，Vue+ElementUI风格;</li>
                                            <li>【新增功能】新一代 (单表) 代码生成器模板，Bootstrap表单+EasyUI原生态列表风格;</li>
                                            <li>【新增功能】新一代 (一对多) 代码生成器模板，ElementUI表单+EasyUI原生态列表风格;</li>
                                            <li>【新增功能】新一代 (一对多) 代码生成器模板，EasyUI标签列表上下布局(列表数据编辑)+Table风格表单;</li>
                                            <li>【功能升级】牛牛叉功能  -> Datagrid标签升级,通过参数component可以快速实现BootstrapTable与easyUI列表风格切换;</li>
                                        </ol>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</c:if>

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
