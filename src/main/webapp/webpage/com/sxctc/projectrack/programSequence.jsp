<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>

<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>

<div class="easyui-layout" fit="true">
    <div style="width:800px;margin:40px" id="programSequenceDiagram"></div>
</div>
<script type="text/javascript">
    var programSequenceDiagramWarp= document.getElementById('programSequenceDiagram');
    programSequenceDiagramWarp.style.height = '400px';
    programSequenceDiagramWarp.style.width = '800px';
    var programSequenceDiagramChart = echarts.init(programSequenceDiagramWarp);
    var resultArray = new Array(${allCount});
    programSequenceDiagramOption = {
        title : {
            text: '项目时序变化'
        },
        color:['#2ec7c9','#b6a2de','#5ab1ef'],

        tooltip : {
            trigger: 'axis'
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
                type:'line',
                data:resultArray
            }
        ]
    };
    programSequenceDiagramChart.setOption(programSequenceDiagramOption);

    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if(r != null){
            return decodeURIComponent(r[2]);
        }
        return null;//返回参数值
    }
</script>
