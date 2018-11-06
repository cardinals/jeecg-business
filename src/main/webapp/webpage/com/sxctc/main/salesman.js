<!--首页banner系统数量-->
var echartsWarp= document.getElementById('echarts_percent');
var myChart = echarts.init(echartsWarp);
$(document).ready(function () {
    $.ajax({
        url: "tbMainController.do?getMainSystemNum",
        type: "post",
        data: {},
        dataType: "json",
        success: function (data) {

            var projectTotalNum = data.attributes.projectTotalNum;
            var notDockSystemNum = data.attributes.notDockSystemNum;
            var cloudDockSystemNum = data.attributes.cloudDockSystemNum;
            var researchFormSystemNum = data.attributes.researchFormSystemNum;
            var signPlanSystemNum = data.attributes.signPlanSystemNum;
            var allocatingResourcesSystemNum = data.attributes.allocatingResourcesSystemNum;
            var cloudTestSystemNum = data.attributes.cloudTestSystemNum;
            var recoveryAgreementSystemNum = data.attributes.recoveryAgreementSystemNum;
            var cloudCompleteNum = data.attributes.cloudCompleteNum;
            $("#projectTotalNum").html(projectTotalNum);
            $("#notDockSystemNum").html(notDockSystemNum);
            $("#cloudDockSystemNum").html(cloudDockSystemNum);
            $("#researchFormSystemNum").html(researchFormSystemNum);
            $("#signPlanSystemNum").html(signPlanSystemNum);
            $("#allocatingResourcesSystemNum").html(allocatingResourcesSystemNum);
            $("#cloudTestSystemNum").html(cloudTestSystemNum);
            $("#recoveryAgreementSystemNum").html(recoveryAgreementSystemNum);
            $("#cloudCompleteNum").html(cloudCompleteNum);

            if (data.success) {
                if (cloudCompleteNum > projectTotalNum){
                    cloudCompleteNum = projectTotalNum;
                }

                var percent = 0;
                if (cloudCompleteNum == 0) {
                    percent = 0;
                } else {
                    percent = Math.round(cloudCompleteNum/projectTotalNum*100);
                }
                option = {
                    title: {
                        text: "上云比例"+"\n"+percent+"%",
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            fontWeight: 'normal',
                            color: '#0580f2',
                            fontSize: '12'
                        }
                    },
                    color: ['rgba(176, 212, 251, 1)'],
                    tooltip: {
                        show: false,
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },
                    legend: {
                        show: false,
                        itemGap: 12,
                        data: ['01', '02']
                    },
                    toolbox: {
                        show: false,
                        feature: {
                            mark: {
                                show: true
                            },
                            dataView: {
                                show: true,
                                readOnly: false
                            },
                            restore: {
                                show: true
                            }
                        }
                    },
                    series: [{
                        name: 'Line 1',
                        type: 'pie',
                        clockWise: true,
                        radius: ['70%', '100%'],
                        itemStyle: {
                            normal: {
                                label: {
                                    show: false
                                },
                                labelLine: {
                                    show: false
                                }
                            }
                        },
                        hoverAnimation: false,

                        data: [{
                            value: percent,
                            name: '01',
                            itemStyle: {
                                normal: {
                                    color: {  // 完成的圆环的颜色
                                        colorStops: [{
                                            offset: 0, color: '#00cefc' // 0% 处的颜色
                                        }, {
                                            offset: 1, color: '#367bec' // 100% 处的颜色
                                        }]
                                    },
                                    label: {
                                        show: false
                                    },
                                    labelLine: {
                                        show: false
                                    }
                                },
                                emphasis: {
                                    color: '#00cefc' // 鼠标悬浮上去完成的圆环的颜色
                                }
                            }
                        }, {
                            value: 20,
                            name: 'invisible'
                        }]
                    }
                    ]
                };
                myChart.setOption(option);
            }

        }
    });
});


// var echartsWarp= document.getElementById('echarts_percent');
// // var resizeWorldMapContainer = function () {//用于使chart自适应高度和宽度,通过窗体高宽计算容器高宽
// //     // echartsWarp.style.width = window.innerWidth/8+'px';
// //     // echartsWarp.style.height = window.innerHeight/8+'px';
// //     echartsWarp.style.width = '150px';
// //     echartsWarp.style.height = '150px';
// // };
// // resizeWorldMapContainer ();//设置容器高宽
// var myChart = echarts.init(echartsWarp);
// $.ajax({
//     url: "tbMainController.do?getMainSystemNum",
//     type: "post",
//     data: {},
//     dataType: "json",
//     success: function (data) {
//
//         if (data.success) {
//
//
//             var cloudCompleteNum = data.attributes.cloudCompleteNum;
//             var projectTotalNum = data.attributes.projectTotalNum;
//             if (cloudCompleteNum > projectTotalNum){
//                 cloudCompleteNum = projectTotalNum;
//             }
//
//             var percent = 0;
//             if (cloudCompleteNum == 0) {
//                 percent = 0;
//             } else {
//                 percent = Math.round(cloudCompleteNum/projectTotalNum*100);
//             }
//             option = {
//                 title: {
//                     text: "上云比例"+"\n"+percent+"%",
//                     x: 'center',
//                     y: 'center',
//                     textStyle: {
//                         fontWeight: 'normal',
//                         color: '#0580f2',
//                         fontSize: '12'
//                     }
//                 },
//                 color: ['rgba(176, 212, 251, 1)'],
//                 tooltip: {
//                     show: false,
//                     formatter: '{a} <br/>{b} : {c} ({d}%)'
//                 },
//                 legend: {
//                     show: false,
//                     itemGap: 12,
//                     data: ['01', '02']
//                 },
//                 toolbox: {
//                     show: false,
//                     feature: {
//                         mark: {
//                             show: true
//                         },
//                         dataView: {
//                             show: true,
//                             readOnly: false
//                         },
//                         restore: {
//                             show: true
//                         }
//                     }
//                 },
//                 series: [{
//                     name: 'Line 1',
//                     type: 'pie',
//                     clockWise: true,
//                     radius: ['70%', '100%'],
//                     itemStyle: {
//                         normal: {
//                             label: {
//                                 show: false
//                             },
//                             labelLine: {
//                                 show: false
//                             }
//                         }
//                     },
//                     hoverAnimation: false,
//
//                     data: [{
//                         value: percent,
//                         name: '01',
//                         itemStyle: {
//                             normal: {
//                                 color: {  // 完成的圆环的颜色
//                                     colorStops: [{
//                                         offset: 0, color: '#00cefc' // 0% 处的颜色
//                                     }, {
//                                         offset: 1, color: '#367bec' // 100% 处的颜色
//                                     }]
//                                 },
//                                 label: {
//                                     show: false
//                                 },
//                                 labelLine: {
//                                     show: false
//                                 }
//                             },
//                             emphasis: {
//                                 color: '#00cefc' // 鼠标悬浮上去完成的圆环的颜色
//                             }
//                         }
//                     }, {
//                         value: 20,
//                         name: 'invisible'
//                     }]
//                 }
//                 ]
//             };
//             myChart.setOption(option);
//         }
//     }
// });



