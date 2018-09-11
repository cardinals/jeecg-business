<!-- 饼状图2 -->
var echartsWarp2= document.getElementById('pieChart2');
var resizeWorldMapContainer2 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    echartsWarp2.style.width = window.innerWidth/2.2+'px';
    echartsWarp2.style.height = window.innerHeight/2+'px';
};
resizeWorldMapContainer2 ();//设置容器高宽
var myChart2 = echarts.init(echartsWarp2);

$.ajax({
    url: "echartsController.do?getPieChartData2",
    type: "post",
    data: {},
    dataType: "json",
    success: function (data) {
        console.log(data);
        /**
         * 图标所需数据
         */
        if (data.success) {
            var cloudConfirmCount = data.attributes.cloudConfirmCount;
            var trackConfirmCount = data.attributes.trackConfirmCount;
            var targetRevenueCount = data.attributes.targetRevenueCount;
            var percent = 0;
            if (cloudConfirmCount == 0 && trackConfirmCount == 0){
                percent = 0;
            } else {
                percent = Math.round((cloudConfirmCount+trackConfirmCount)/targetRevenueCount*100);
            }
            var data1 = {
                id: 'echartPie',
                value: [cloudConfirmCount, trackConfirmCount,targetRevenueCount-(cloudConfirmCount+trackConfirmCount)],
                legend: ['上云完成金额', '项目完成金额', '未完成金额'],
                color: ['#3FA7DC', '#5170A2', '#E1CA74'],
                // tooltipShow:false,    //设置悬浮提示显示              --默认显示true
                // hoverAnimation:false, //设置鼠标悬浮点击饼图动画效果  --默认开启动画true
                title: '目标完成比例\n'+percent+'%'
            };

            ////////////////////////////////////////

            /**
             * 数据处理
             */
            var seriesData = [];
            data1.value.forEach(function (item, index) {
                seriesData.push({
                    value: item,
                    name: data1.legend[index]
                })
            });
            ////////////////////////////////////////

            var option2 = {
                backgroundColor: '#fff',
                title: {
                    x: 'center',
                    y: 'center',
                    textStyle: {
                        fontWeight: 400,
                        fontSize: 16,
                        color: '#687284'
                    },
                    text: data1.title || ''
                },
                tooltip: {
                    trigger: 'item',
                    show: data1.tooltipShow === false ? false : true
                    //   formatter: "{b}: {c} ({d}%)"
                },
                legend: {
                    orient: 'horizontal',
                    top: 16,
                    icon: 'circle',
                    selectedMode: false,
                    itemWidth: 6,
                    itemHeight: 6,
                    itemGap: 6,
                    borderRadius: 6,
                    data: data1.legend
                },
                series: [{
                    type: 'pie',
                    // clickable:false,
                    // selectedMode: 'single',//单点击设置
                    hoverAnimation: data1.hoverAnimation === false ? false : true,
                    radius: ['40%', '67%'],
                    color: data1.color,
                    label: {
                        normal: {
                            position: 'inner',
                            // formatter: '{d}%',
                            formatter: function (param) {
                                if (!param.percent) return ''
                                var f = Math.round(param.percent * 10) / 10;
                                var s = f.toString();
                                var rs = s.indexOf('.');
                                if (rs < 0) {
                                    rs = s.length;
                                    s += '.';
                                }
                                while (s.length <= rs + 1) {
                                    s += '0';
                                }
                                return s + '%';
                            },
                            textStyle: {
                                color: '#fff',
                                fontSize: 12
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data: seriesData
                }]
            };

            myChart2.setOption(option2);
        }
    }
});

<!--饼状图3-->
var echartsWarp3= document.getElementById('pieChart3');
var resizeWorldMapContainer3 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    echartsWarp3.style.width = window.innerWidth/2.2+'px';
    echartsWarp3.style.height = window.innerHeight/2+'px';
};
resizeWorldMapContainer3 ();//设置容器高宽
var myChart3 = echarts.init(echartsWarp3);

$.ajax({
    url: "echartsController.do?getPieChartData3",
    type: "post",
    data: {},
    dataType: "json",
    success: function (data) {
        if (data.success) {

            var winTheBidProjectNum = data.attributes.winTheBidProjectNum;
            var targetConstructProjectNum = data.attributes.targetConstructProjectNum;
            if (winTheBidProjectNum > targetConstructProjectNum){
                winTheBidProjectNum = targetConstructProjectNum;
            }

            var percent = 0;
            if (winTheBidProjectNum == 0) {
                percent = 0;
            } else {
                percent = Math.round(winTheBidProjectNum/targetConstructProjectNum*100);
            }
            var data1 = {
                id: 'echartPie',
                value: [winTheBidProjectNum, targetConstructProjectNum-winTheBidProjectNum],
                legend: ['已中标项目', '尚未中标项目'],
                color: ['#6AB0B8', '#E98F6F', '#CD2626'],
                // tooltipShow:false,    //设置悬浮提示显示              --默认显示true
                // hoverAnimation:false, //设置鼠标悬浮点击饼图动画效果  --默认开启动画true
                title: '目标完成比例\n'+percent+'%',
            };

            ////////////////////////////////////////

            /**
             * 数据处理
             */
            var seriesData = [];
            data1.value.forEach(function(item, index) {
                seriesData.push({
                    value: item,
                    name: data1.legend[index]
                })
            });
            ////////////////////////////////////////

            var option3 = {
                backgroundColor: '#fff',
                title: {
                    x: 'center',
                    y: 'center',

                    textStyle: {
                        fontWeight: 400,
                        fontSize: 16,
                        color: '#687284'
                    },
                    text: data1.title || ''
                },
                tooltip: {
                    trigger: 'item',
                    show: data1.tooltipShow === false ? false : true
                    //   formatter: "{b}: {c} ({d}%)"
                },
                legend: {
                    orient: 'horizontal',
                    top: 16,
                    icon: 'circle',
                    selectedMode: false,
                    itemWidth: 6,
                    itemHeight: 6,
                    itemGap: 6,
                    borderRadius: 6,
                    data: data1.legend
                },
                series: [{
                    type: 'pie',
                    // clickable:false,
                    // selectedMode: 'single',//单点击设置
                    hoverAnimation: data1.hoverAnimation === false ? false : true,
                    radius: ['40%', '67%'],
                    color: data1.color,
                    label: {
                        normal: {
                            position: 'inner',
                            // formatter: '{d}%',
                            formatter: function(param) {
                                if (!param.percent) return ''
                                var f = Math.round(param.percent * 10) / 10;
                                var s = f.toString();
                                var rs = s.indexOf('.');
                                if (rs < 0) {
                                    rs = s.length;
                                    s += '.';
                                }
                                while (s.length <= rs + 1) {
                                    s += '0';
                                }
                                return s + '%';
                            },
                            textStyle: {
                                color: '#fff',
                                fontSize: 12
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            show: false
                        }
                    },
                    data: seriesData
                }]
            };

            myChart3.setOption(option3);
        }
    }
});

<!--饼图4-->
var echartsWarp4= document.getElementById('pieChart4');
var resizeWorldMapContainer4 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    echartsWarp4.style.width = window.innerWidth/2.2+'px';
    echartsWarp4.style.height = window.innerHeight/2+'px';
};
resizeWorldMapContainer4();//设置容器高宽
var myChart4 = echarts.init(echartsWarp4);
$.ajax({
    url: "echartsController.do?getPieChartData4",
    type: "post",
    data: {},
    dataType: "json",
    success: function (data) {

        if (data.success) {
            var notDockSystemNum = data.attributes.notDockSystemNum;
            var cloudDockSystemNum = data.attributes.cloudDockSystemNum;
            var researchFormSystemNum = data.attributes.researchFormSystemNum;
            var signPlanSystemNum = data.attributes.signPlanSystemNum;
            var allocatingResourcesSystemNum = data.attributes.allocatingResourcesSystemNum;
            var cloudTestSystemNum = data.attributes.cloudTestSystemNum;
            var recoveryAgreementSystemNum = data.attributes.recoveryAgreementSystemNum;
            var cloudCompleteNum = data.attributes.cloudCompleteNum;



            option4 = {
                title : {
                    text: '已验收系统总数',
                    subtext: '',
                    x:'center',
                    textStyle: {
                        fontSize: 20,
                    },
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['未对接','上云对接','取得调研表/资源需求表','签订方案','分配资源','上云测试','回收协议','上云完成']
                },
                series : [
                    {
                        name: '上云阶段:',
                        type: 'pie',
                        radius : '67%',
                        center: ['50%', '60%'],
                        data:[
                            {value:notDockSystemNum, name:'未对接'},
                            {value:cloudDockSystemNum, name:'上云对接'},
                            {value:researchFormSystemNum, name:'取得调研表/资源需求表'},
                            {value:signPlanSystemNum, name:'签订方案'},
                            {value:allocatingResourcesSystemNum, name:'分配资源'},
                            {value:cloudTestSystemNum, name:'上云测试'},
                            {value:recoveryAgreementSystemNum, name:'回收协议'},
                            {value:cloudCompleteNum, name:'上云完成'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            myChart4.setOption(option4);
        }
    }
});
<!--饼图5-->
var echartsWarp5= document.getElementById('pieChart5');
var resizeWorldMapContainer5 = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
    echartsWarp5.style.width = window.innerWidth/2.2+'px';
    echartsWarp5.style.height = window.innerHeight/2+'px';
};
resizeWorldMapContainer5 ();//设置容器高宽
var myChart5 = echarts.init(echartsWarp5);
$.ajax({
    url: "echartsController.do?getPieChartData5",
    type: "post",
    data: {},
    dataType: "json",
    success: function (data) {
        if (data.success) {
            var cloudCompleteNum = data.attributes.cloudCompleteNum;
            var targetCloudSystemNum = data.attributes.targetCloudSystemNum;
            

            option5 = {
                title : {
                    text: '2018上云系统数量（目标数量：'+targetCloudSystemNum+'）',
                    //subtext: '目标数量：'+targetCloudSystemNum+'个',
                    x:'center',
                    textStyle: {
                        fontSize: 20,
                    },
                    subtextStyle: {
                        fontSize: 16,
                    },
                },
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['上云完成','其他']
                },
                series : [
                    {
                        name: '系统数量:',
                        type: 'pie',
                        radius : '67%',
                        center: ['50%', '60%'],
                        data:[
                            {value:cloudCompleteNum, name:'上云完成'},
                            {value:targetCloudSystemNum-cloudCompleteNum, name:'其他'}
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            myChart5.setOption(option5);
        }
    }
});
