<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->


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
            <h1 class="text-warning" style="font-weight: bold">政务云营销大数据管理系统</h1>
            <h4 class="text-danger">欢迎光临</h4>
            <iframe id="fancybox-frame" name="fancybox-frame1533801934382" frameborder="0" scrolling="no" hspace="0" height="25px" style="margin-bottom: -7px;" src="http://i.tianqi.com/index.php?c=code&a=getcode&id=34&h=25&w=280&py=taiyuan"></iframe>
        </blockquote>
        <hr>
    </div>
    <div class="col-sm-12">
        <div class="col-sm-4" id="pieChart1">
            <%--<h2>Hello,Guest</h2>
            <small>移动设备访问请扫描以下二维码：</small>
            <br>
            <br>
            <img src="plug-in/login/images/jeecg.jpg" width="100%" style="max-width:264px;">
            <br>--%>
        </div>
        <div class="col-sm-4" id="barGraph1">
            <%--<h2>
                Jeecg 微云快速开发平台
            </h2>
            <p>JEECG是一款基于代码生成器的J2EE快速开发平台，开源界“小普元”超越传统商业企业级开发平台。引领新的开发模式(Online Coding模式(自定义表单)->代码生成器模式->手工MERGE智能开发)， 可以帮助解决Java项目60%的重复工作，让开发更多关注业务逻辑。既能快速提高开发效率，帮助公司节省人力成本，同时又不失灵活性。她可以用于所有的Web应用程序，如:<b>MIS</b>，<b>CRM</b>，<b>OA</b>，<b>ERP</b>，<b>CMS</b>，<b>网站后台</b>，<b>微信管家</b>，等等，当然，您也可以对她进行深度定制，以做出更强系统。</p>
            <p>
                <b>当前版本：</b>v_3.7.6
            </p>
            <p>
                <span class="label label-warning">开源     &nbsp; | &nbsp; 免费  | &nbsp; 更多插件</span>
            </p>
            <br>
            <p>
                <a class="btn btn-success btn-outline" href="http://yun.jeecg.org" target="_blank">
                    <i class="fa fa-cloud"></i> 云应用中心
                </a>
                <a class="btn btn-white btn-bitbucket" href="http://www.jeecg.org/" target="_blank">
                    <i class="fa fa-qq"> </i> 联系我们
                </a>
                <a class="btn btn-white btn-bitbucket" href="http://blog.csdn.net/zhangdaiscott" target="_blank">
                    <i class="fa fa-home"></i> 官方博客
                </a>
            </p>--%>
        </div>
        <div class="col-sm-4" id="barGraph2">
            <%--<h4>Jeecg具有以下特点：</h4>
            <ol>
                <li>采用主流J2EE框架，容易上手;</li>
                <li>强大的代码生成器，一键生成</li>
                <li>提供5套不同风格首页</li>
                <li>开发效率很高，节省80%重复工作</li>
                <li>使用最流行的的扁平化设计</li>
                <li>在线开发能力，通过在线配置实现功能，零代码</li>
                <li>在线报表配置能力，一次配置七种报表风格，支持移动报表</li>
                <li>移动平台支持，采用Bootstrap技术，移动OA，移动报表</li>
                <li>强大数据权限，访问级，按钮级、数据行级，列级，字段级</li>
                <li>国际化能力，支持多语言</li>
                <li>多数据源，跨数据源操作，便捷集成第三方系统</li>
                <li>简易Excel、Word 导入导出,满足企业需求</li>
                <li>插件开发，可插拔开发模式，集成第三方组件</li>
                <li>流程定义，在线画流程，流程挂表单，符合国情流程</li>
                <li>自定义表单，可视化拖拽布局，自定义表单风格</li>
                <li>更多……</li>
            </ol>--%>
        </div>
        <hr>
    </div>
    <div class="col-sm-12">
        <div class="col-sm-4" id="pieChart2"></div>
        <div class="col-sm-4" id="barGraph3"></div>
        <div class="col-sm-4" id="barGraph4"></div>
    </div>
</div>
<%--<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-4">

            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>最新公告</h5>
                </div>
                <div class="ibox-content">
                    <p><h3>政务云营销大数据管理系统内测版本</h3></p>
                    <p>发现以下bug请与开发人员反馈：</p>
                    <ol>
                        <li>系统奔溃</li>
                        <li>操作不合理</li>
                        <li>页面展示问题</li>
                        <li>优化建议</li>
                    </ol>
                </div>
            </div>
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>联系信息</h5>

                </div>
                <div class="ibox-content">
                    <p><i class="fa fa-send-o"></i> 官网：<a href="http://www.jeecg.org" target="_blank">https://www.sxctc.com</a>
                    </p>
                    <p><i class="fa fa-qq"></i> QQ群：<a href="javascript:;">16347823784</a>
                    </p>
                    <p><i class="fa fa-weixin"></i>微信公众号：<a href="javascript:;">sxctc</a>
                    </p>
                    <p><i class="fa fa-credit-card"></i> 邮箱：<a href="javascript:;" class="邮箱">sxctc</a>
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
                    &lt;%&ndash;<hr>
                    <div class="alert alert-warning">JEECG智能开发平台，可以应用在任何J2EE项目的开发中，尤其适合企业信息管理系统（MIS）、内部办公系统（OA）、企业资源计划系统（ERP） 、客户关系管理系统（CRM）等，其半智能手工Merge的开发方式，可以显著提高开发效率60%以上，极大降低开发成本。
                    </div>&ndash;%&gt;
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
                                        <a data-toggle="collapse" data-parent="#version" href="#v54">v1.0.1</a><code class="pull-right">2018.08.16</code>
                                    </h5>
                                </div>
                                <div id="v54" class="panel-collapse collapse in">
                                    <div class="panel-body">
                                        <div class="alert alert-warning">此版本为政务云营销大数据管理系统内测版本，新增首页界面优化和报表功能；</div>
                                        <ol>
                                            <li>【新增功能】首页报表统计，echarts风格;</li>
                                            <li>【功能升级】业务列表录入更新流程优化，校验升级;</li>
                                            <li>【功能升级】日报功能升级，增加历史日报，周报的统计，修改今日日报bug;</li>
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
                                        <div class="alert alert-warning">此版本为第一版提测版本，欢迎测试；</div>
                                        <ol>
                                            <li>【新增功能】业务主功能上线内测;</li>
                                            <li>【新增功能】日报功能上线内测;</li>
                                            <li>【新增功能】厅局单位维护;</li>
                                            <li>【新增功能】服务目录管理;</li>
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
</div>--%>

<!-- 全局js -->
<script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
<script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
<script src="plug-in/hplus/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="plug-in/hplus/js/content.js"></script>

<!-- echart 初始化 -->
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<script type="text/javascript">
    <!-- 饼状图 -->
    var echartsWarp1= document.getElementById('pieChart1');
    var resizeWorldMapContainer1 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        echartsWarp1.style.width = window.innerWidth/3.5+'px';
        echartsWarp1.style.height = window.innerHeight/3+'px';
    };
    resizeWorldMapContainer1 ();//设置容器高宽
    var myChart1 = echarts.init(echartsWarp1);

    // 数据请求区
    $.ajax({
        url:"echartsController.do?getPieChartData1",
        type:"post",
        data:{},
        dataType:"json",
        success:function(data){
            if(data.success){
                var allCount = data.attributes.allCount;
                var joinCount = data.attributes.joinCount;
                var unjoinCount = data.attributes.unjoinCount;

                var percent = 0;
                if (joinCount == 0) {
                    percent = 0;
                } else {
                    percent = Math.round(joinCount/allCount*100);
                }
                option1 = {
                    title: {
                        text: percent + '%',
                        subtext: '对接比率',
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            fontWeight: 'normal',
                            color: '#0580f2',
                            fontSize: '30'
                        },
                        subtextStyle: {
                            fontWeight: 'normal',
                            color: '#0580f2',
                            fontSize: '15'
                        }
                    },
                    color: ['rgba(176, 212, 251, 1)'],
                    legend: {
                        show: true,
                        itemGap: 12,
                        data: ['已对接', '未对接']
                    },

                    series: [{
                        name: 'Line 1',
                        type: 'pie',
                        clockWise: true,
                        radius: ['50%', '66%'],
                        itemStyle: {
                            normal: {
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            },
                        },
                        hoverAnimation: true,
                        data: [{
                            value: joinCount,
                            name: '已对接',
                            itemStyle: {
                                normal: {
                                    color: { // 完成的圆环的颜色
                                        colorStops: [{
                                            offset: 0,
                                            color: '#00cefc' // 0% 处的颜色
                                        }, {
                                            offset: 1,
                                            color: '#367bec' // 100% 处的颜色
                                        }]
                                    },
                                    label: {
                                        show: false
                                    },
                                    labelLine: {
                                        show: false
                                    }
                                }
                            }
                        }, {
                            name: '未对接',
                            value: unjoinCount
                        }]
                    }]
                }

                myChart1.setOption(option1);

            }
        }
    });


    <!-- 柱状图 -->
    var echartsWarp2= document.getElementById('barGraph1');
    var resizeWorldMapContainer2 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        //echartsWarp.style.width = window.innerWidth-20+'px';
        echartsWarp2.style.width = window.innerWidth/3+'px';
        echartsWarp2.style.height = window.innerHeight/3+'px';
    };
    resizeWorldMapContainer2 ();//设置容器高宽
    var myChart2 = echarts.init(echartsWarp2);

    // 数据请求区
    $.ajax({
        url:"echartsController.do?getBarGraphData1",
        type:"post",
        data:{},
        dataType:"json",
        success:function(data){
            if(data.success){
                var resultData = [];
                for (var i = 1; i <= 12; i++) {
                    resultData.push(data.attributes[i]);
                }
                option2 = {
                    title : {
                        text: '对接系统数量'
                        //subtext: '纯属虚构'
                    },
                    tooltip : {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['新对接数']
                        //data:['蒸发量','降水量']
                    },
                    toolbox: {
                        show : true,
                        feature : {
                            dataView : {show: false, readOnly: false},
                            magicType : {show: true, type: ['line', 'bar']},
                            restore : {show: true},
                            saveAsImage : {show: false}
                        }
                    },
                    calculable : true,
                    xAxis : [
                        {
                            type : 'category',
                            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'新对接数',
                            type:'bar',
                            data:resultData,
                            markPoint : {
                                data : [
                                    {type : 'max', name: '最大值'},
                                    {type : 'min', name: '最小值'}
                                ]
                            },
                            markLine : {
                                data : [
                                    {type : 'average', name: '平均值'}
                                ]
                            }
                        },
                        // {
                        //     name:'降水量',
                        //     type:'bar',
                        //     data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3],
                        //     markPoint : {
                        //         data : [
                        //             {name : '年最高', value : 182.2, xAxis: 7, yAxis: 183},
                        //             {name : '年最低', value : 2.3, xAxis: 11, yAxis: 3}
                        //         ]
                        //     },
                        //     markLine : {
                        //         data : [
                        //             {type : 'average', name : '平均值'}
                        //         ]
                        //     }
                        // }
                    ]
                };

                myChart2.setOption(option2);

            }
        }
    });


    <!-- 折线图 -->
    var echartsWarp3= document.getElementById('barGraph2');
    var resizeWorldMapContainer3 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
        echartsWarp3.style.width = window.innerWidth/3+'px';
        echartsWarp3.style.height = window.innerHeight/3+'px';
    };
    resizeWorldMapContainer3 ();//设置容器高宽
    var myChart3 = echarts.init(echartsWarp3);

    // 数据请求区
    $.ajax({
        url:"echartsController.do?getBarGraphData2",
        type:"post",
        data:{},
        dataType:"json",
        success:function(data){
            if(data.success){
                var XData = [];
                var yData=[];
                var resultArray = data.obj;
                for (var i = 0; i < resultArray.length; i++) {
                    XData.push(resultArray[i].createName);
                    yData.push(resultArray[i].projectCount);
                }
                //var dataMin=parseInt(Math.min.apply(null, yData)/2);
                var dataMin=0;

                option3 = {
                    title : {
                        text: '用户负责系统数'
                        //subtext: '纯属虚构'
                    },
                    backgroundColor:"#fff",
                    xAxis: {
                        axisTick: {
                            show: false
                        },
                        splitLine: {
                            show: false
                        },
                        splitArea: {
                            show: false
                        },
                        data: XData,
                        axisLabel: {
                            formatter: function(value) {
                                var ret = ""; //拼接加\n返回的类目项
                                var maxLength = 1; //每项显示文字个数
                                var valLength = value.length; //X轴类目项的文字个数
                                var rowN = Math.ceil(valLength / maxLength); //类目项需要换行的行数
                                if (rowN > 1) //如果类目项的文字大于3,
                                {
                                    for (var i = 0; i < rowN; i++) {
                                        var temp = ""; //每次截取的字符串
                                        var start = i * maxLength; //开始截取的位置
                                        var end = start + maxLength; //结束截取的位置
                                        //这里也可以加一个是否是最后一行的判断，但是不加也没有影响，那就不加吧
                                        temp = value.substring(start, end) + "\n";
                                        ret += temp; //凭借最终的字符串
                                    }
                                    return ret;
                                } else {
                                    return value;
                                }
                            },
                            interval: 0,
                            fontSize: 16,
                            fontWeight: 100,
                            textStyle: {
                                color: '#000',

                            }
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#000'
                            }
                        }
                    },
                    yAxis: {
                        axisTick: {
                            show: false
                        },
                        splitLine: {
                            show: false
                        },
                        splitArea: {
                            show: false
                        },
                        min: dataMin,
                        axisLabel: {
                            textStyle: {
                                color: '#000',
                                fontSize: 16,
                            }
                        },
                        axisLine: {
                            lineStyle: {
                                color: '#000'
                            }
                        }
                    },
                    "tooltip": {
                        "trigger": "item",
                        "textStyle": {
                            "fontSize": 12
                        },
                        "formatter": "{b0}:{c0}"
                    },
                    series: {
                        type:"bar",
                        itemStyle: {
                            normal: {
                                color: {
                                    type: 'linear',
                                    x: 0,
                                    y: 0,
                                    x2: 0,
                                    y2: 1,
                                    colorStops: [{
                                        offset: 0,
                                        color: '#00d386' // 0% 处的颜色
                                    }, {
                                        offset: 1,
                                        color: '#0076fc' // 100% 处的颜色
                                    }],
                                    globalCoord: false // 缺省为 false
                                },
                                barBorderRadius: 5,
                            }
                        },
                        // barWidth: 7,
                        data: yData
                    }
                };

                myChart3.setOption(option3);

            }
        }
    });

</script>
</body>

</html>
