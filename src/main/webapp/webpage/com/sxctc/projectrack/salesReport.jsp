<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <link href="plug-in/hplus/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="plug-in/hplus/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <!-- 全局js -->
    <script src="plug-in/hplus/js/jquery.min.js?v=2.1.4"></script>
    <script src="plug-in/hplus/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="plug-in/hplus/js/plugins/layer/layer.min.js"></script>
    <script type="text/javascript" src="plug-in/echart/echarts.js"></script>
</head>
<body class="gray-bg">
<div class="container-fluid" style="margin:30px;">
    <div class="row  border-bottom white-bg dashboard-header">
            <div class="col-sm-5 col-md-5" id="rankOfSale"></div>
            <div class="col-sm-5 col-md-5 col-md-offset-1 col-md-offset-1" id="rankOfUnit"></div>
    </div>
    <div class="row  border-bottom white-bg dashboard-header">
            <div class="col-sm-11 col-md-11" id="sequenceStatistics"></div>
    </div>
    <div class="row  border-bottom white-bg dashboard-header">
            <div class="col-sm-6 col-md-6" id="gradeTotal"></div>
            <div class="col-sm-4 col-md-4 col-md-offset-1 col-md-offset-1" id="gradeDetail"></div>
    </div>
</div>
    <script type="text/javascript">
        //销售业绩排名
        var rankOfSaleWarp= document.getElementById('rankOfSale');
        rankOfSaleWarp.style.height = '350px';
        var rankOfSaleChart = echarts.init(rankOfSaleWarp);
        rankOfSaleoption = {
            title: {
                text: '销售业绩排名：'
            },
            // color:'#24c5ee',
            color:'#0074cc',
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'line'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['销售总额'],
                x:'right'
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis:  {
                type: 'value'
            },
            yAxis: {
                type: 'category',
                data: ['王奇侠','李涛','张博','张榕','顾楠']
            },
            series: [
                {
                    name: '销售总额',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: [3400, 3200, 1900, 1900, 1600]
                }
            ]
        };
        rankOfSaleChart.setOption(rankOfSaleoption);
        // $.ajax({
        //     url:"echartsController.do?getRankOfSale",
        //     type:"post",
        //     data:{},
        //     dataType:"json",
        //     success:function(data){
        //         if(data.success){
        //             var XData = [];
        //             var yData=[];
        //             var resultArray = data.obj;
        //             for (var i = 0; i < resultArray.length; i++) {
        //                 XData.push(resultArray[i].nameList);
        //                 yData.push(resultArray[i].valueList);
        //             }
        //             rankOfSaleChart.setOption({
        //                 yAxis: {
        //                     data: XData
        //                 },
        //                 series: [{
        //                         data: yData
        //                     }
        //                 ]});
        //         }
        //     }
        // });

        //厅局建设费用排名
        var rankOfUnitWarp= document.getElementById('rankOfUnit');
        rankOfUnitWarp.style.height = '350px';
        var rankOfUnitChart = echarts.init(rankOfUnit);
        rankOfUnitoption = {
            title: {
                text: '厅局建设费用排名：'
            },
            // color: ['#37A2DA', '#32C5E9', '#67E0E3', '#9FE6B8'],
            color:  '#6A5ACD',
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            legend: {
                data: ['服务费用'],
                x:'right'
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis:  {
                type: 'value'
            },
            yAxis: {
                type: 'category',
                data: ['山西省统计局','山西省中小企业局','山西省公路局','山西省运输厅','山西省国防科办']
            },
            series: [
                {
                    name: '服务费用',
                    type: 'bar',
                    stack: '总量',
                    label: {
                        normal: {
                            show: true,
                            position: 'insideRight'
                        }
                    },
                    data: [77, 66, 87, 30,20]
                }
            ]
        };
        rankOfUnitChart.setOption(rankOfUnitoption);
        // $.ajax({
        //     url:"echartsController.do?getRankOfUnit",
        //     type:"post",
        //     data:{},
        //     dataType:"json",
        //     success:function(data){
        //         if(data.success){
        //             var xData = [];
        //             var yData=[];
        //             var resultArray = data.obj;
        //             for (var i = 0; i < resultArray.length; i++) {
        //                 yData.push(resultArray[i].nameList);
        //                 xData.push(resultArray[i].valueList);
        //             }
        //             rankOfUnitChart.setOption({
        //                 xAxis:  {
        //                     type: 'value'
        //                 },
        //                 yAxis: {
        //                     type: 'category',
        //                     data: yData
        //                 },
        //                 series: [
        //                     {
        //                         name: '服务费用',
        //                         type: 'bar',
        //                         stack: '总量',
        //                         label: {
        //                             normal: {
        //                                 show: true,
        //                                 position: 'insideRight'
        //                             }
        //                         },
        //                         data: xData
        //                     }
        //                 ]
        //             });
        //         }
        //     }
        // });

        //响应时间统计
        //创建到对接、对接到调研、调研到签订方案、签订方案到分配资源、分配资源到上云测试、上云测试到收回协议、收回协议到上云完成
        var sequenceStatisticsWarp= document.getElementById('sequenceStatistics');
        sequenceStatisticsWarp.style.height = '350px';
        var sequenceStatisticsChart = echarts.init(sequenceStatisticsWarp);
        sequenceStatisticsoption = {
            title : {
                text: '响应时间统计'
            },
            color:['#2ec7c9','#b6a2de','#5ab1ef'],

            tooltip : {
                trigger: 'axis'
            },
            legend: {
                data:['最小值','平均值','最大值'],
                x:'right'
            },
            calculable : true,
            xAxis : [
                {
                    type : 'category',
                    data : ['创建到对接','对接到调研','调研到签订方案','签订方案到分配资源','分配资源到上云测试','上云测试到收回协议','收回协议到上云完成']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'最小值',
                    type:'bar',
                    data:[3, 7,4, 5, 16, 15, 13]
                },
                {
                    name:'平均值',
                    type:'bar',
                    data:[33, 55, 44, 55, 37,66, 29]
                },
                {
                    name:'最大值',
                    type:'bar',
                    data:[66, 66, 66, 66, 88,88, 88]
                }
            ]
        };
        sequenceStatisticsChart.setOption(sequenceStatisticsoption);
        $.ajax({
            url:"echartsController.do?getSequenceStatistics",
            type:"post",
            data:{},
            dataType:"json",
            success:function(data){
                if(data.success){
                    var resultArray = data.obj;
                    sequenceStatisticsChart.setOption({
                        series : [
                            {
                                name:'最小值',
                                type:'bar',
                                data:[
                                    resultArray[0],
                                    resultArray[1],
                                    resultArray[2],
                                    resultArray[3],
                                    resultArray[4],
                                    resultArray[5],
                                    resultArray[6]
                                ]
                            },
                            {
                                name:'平均值',
                                type:'bar',
                                data:[resultArray[7],
                                    resultArray[8],
                                    resultArray[9],
                                    resultArray[10],
                                    resultArray[11],
                                    resultArray[12],
                                    resultArray[13]]
                            },
                            {
                                name:'最大值',
                                type:'bar',
                                data:[resultArray[14],
                                    resultArray[15],
                                    resultArray[16],
                                    resultArray[17],
                                    resultArray[18],
                                    resultArray[19],
                                    resultArray[20]]
                            }
                        ]
                    });
                }
            }
        });

        //平台建设费用统计
        var gradeTotalWarp= document.getElementById('gradeTotal');
            gradeTotalWarp.style.height = '350px';
        var gradeTotalChart = echarts.init(gradeTotalWarp);
        gradeTotalOption = {
            title: {
                text: '平台建设费用'
            },
            color:'#1bb2d8',
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                },
                formatter: function (params) {
                    var tar = params[0];
                    return tar.name + '<br/>' + tar.seriesName + ' : ' + tar.value;
                }
            },

            xAxis : [
                {
                    type : 'category',
                    splitLine: {show:false},
                    data: ['ALL','IAAS','PAAS','SAAS','DAAS']
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'辅助',
                    type:'bar',
                    stack: '总量',
                    itemStyle:{
                        normal:{
                            barBorderColor:'rgba(0,0,0,0)',
                            color:'rgba(0,0,0,0)'
                        },
                        emphasis:{
                            barBorderColor:'rgba(0,0,0,0)',
                            color:'rgba(0,0,0,0)'
                        }
                    },
                    data:[0, 4700, 2100, 100, 0]
                },
                {
                    name:'生活费',
                    type:'bar',
                    stack: '总量',
                    itemStyle : { normal: {label : {show: true, position: 'inside'}}},
                    data:[8700, 4000, 2600, 2000, 100]
                }
            ]
        };
        gradeTotalChart.setOption(gradeTotalOption);
        $.ajax({
            url:"echartsController.do?getGradeTotal",
            type:"post",
            data:{},
            dataType:"json",
            success:function(data){
                var resultArray = data.obj;
                var iaasNum = Number(resultArray[0].valueList);
                var paasNum = Number(resultArray[1].valueList);
                var saasNum = Number(resultArray[2].valueList);
                var daasNum = Number(resultArray[3].valueList);

                    if(resultArray.length >=4 ) {
                        gradeTotalChart.setOption({
                                series : [
                                    {
                                        name:'辅助',
                                        type:'bar',
                                        stack: '总量',
                                        itemStyle:{
                                            normal:{
                                                barBorderColor:'rgba(0,0,0,0)',
                                                color:'rgba(0,0,0,0)'
                                            },
                                            emphasis:{
                                                barBorderColor:'rgba(0,0,0,0)',
                                                color:'rgba(0,0,0,0)'
                                            }
                                        },
                                        data:[0,
                                            paasNum +saasNum +daasNum,
                                            daasNum +saasNum,
                                            daasNum,
                                            0]
                                    },
                                    {
                                        name:'生活费',
                                        type:'bar',
                                        stack: '总量',
                                        itemStyle : { normal: {label : {show: true, position: 'inside'}}},
                                        data:[iaasNum +paasNum +saasNum +daasNum ,
                                            iaasNum ,
                                            paasNum ,
                                            saasNum ,
                                            daasNum]
                                    }
                                ]
                            });
                        }
                    }
                });


        //服务费用统计
        var gradeDetailWarp= document.getElementById('gradeDetail');
        gradeDetailWarp.style.height = '350px';
        var gradeDetailChart = echarts.init(gradeDetailWarp);
        gradeDetailOption = {
            title:{
                text:'服务费用统计'
            },
            visualMap: {
                show: false,
                min: 80,
                max: 600,
                inRange: {
                    colorLightness: [0, 1]
                }
            },
            tooltip : {
                trigger: 'item',
                formatter: "{b} : {c} ({d}%)"
            },
            series : [
                {
                    type: 'pie',
                    radius: '65%',
                    data:[
                        {value:235, name:'服务1'},
                        {value:274, name:'服务2'},
                        {value:310, name:'服务2'},
                        {value:335, name:'服务4'},
                        {value:400, name:'服务5'}
                    ],
                    roseType: 'angle',
                    itemStyle: {
                        normal: {
                            color: '#37A2DA'
                        }
                    }
                }
            ]
        };
        gradeDetailChart.setOption(gradeDetailOption);

    </script>
</body>
</html>