<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui"></t:base>

<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<div class="easyui-layout" fit="true">
    <div data-options="region:'west',title:'销售业务人员',split:true" style="width:115px;">
        <ul id="managerList" class="ztree" ></ul>
    </div>
    <div data-options="region:'east',title:'分析',split:true,collapsed:true"  style="width:500px;">
        <div style="width:450px;margin:40px" id="rankOfUnit"></div>
        <div style="width:450px;margin:40px" id="gradeTotal"></div>
        <div style="width:450px;margin:40px" id="sequenceStatistics"></div>
    </div>
    <div data-options="region:'center', split:true">
        <%--<div class="easyui-layout" data-options="fit:true">
            <div data-options="region:'north',title:'上云项目',split:true" style="height:350px">
                <table id="programList" style="height:500px;width:1300px;"></table>
            </div>
            <div data-options="region:'center',title:'机会池'">
                <table id="chanceProgramList" style="height:500px;width:2000px;"></table>
            </div>
        </div>--%>
        <t:tabs id="tabsOne" iframe="true" tabPosition="top" fit="true">
            <%--<t:tab href="tBBusinessController.do?list&optFlag=1" icon="icon-search" title="上云项目" id="tBBusinessListIframe"></t:tab>--%>
            <t:tab href="tBChancePoolController.do?list&userType=1" icon="icon-search" title="机会池" id="tBChancePoolListIframe"></t:tab>
            <t:tab href="tBProfitTargetController.do?list&userType=1" icon="icon-search" title="已签订项目" id="tBProfitTargetListIframe"></t:tab>
        </t:tabs>
    </div>
</div>
<div style="display:none">
    <!-- 激活选项卡再刷新页面需要该隐藏域 -->
    <input type="hidden" id="mainPageHiddenId">
    <select id="mainPageFrameActived" style="display:none">
        <option value="tBChancePoolList" selected="selected"></option>
        <option value="tBProfitTargetList"></option>
    </select>
</div>
<script type="text/javascript">
    var programListdictsData = {};
    var chanceProgramListdictsData = {};

    var setting = {
        check: {
            enable: false,
            chkboxType: { "Y": "", "N": "" }
        },
        data: {
            simpleData: {
                enable: true
            }
        },callback: {
            onClick:onClick
        }
    };

    function onClick(event, treeId, treeNode){
        initBusiList(treeNode.code);

        $.ajax({
            url:"userProgramController.do?getSequenceStatistics",
            type:"post",
            data:{userCode:treeNode.code},
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

        $.ajax({
            url:"userProgramController.do?getGradeTotal",
            type:"post",
            data:{userCode:treeNode.code},
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

        $.ajax({
            url:"userProgramController.do?getRankOfUnit",
            type:"post",
            data:{userCode:treeNode.code},
            dataType:"json",
            success:function(data){
                if(data.success){
                    var xData = [];
                    var yData=[];
                    var resultArray = data.obj;
                    for (var i = 0; i < resultArray.length; i++) {
                        yData.push(resultArray[i].nameList);
                        xData.push(resultArray[i].valueList);
                    }
                    rankOfUnitChart.setOption({
                        xAxis:  {
                            type: 'value'
                        },
                        yAxis: {
                            type: 'category',
                            data: yData
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
                                data: xData
                            }
                        ]
                    });
                }
            }
        });

    }
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
    function fmtype(value,row,index) {
        if (value == 0) {
            return 'background-color:#FF4040;color:#fff;';
        }
        if (value == 7) {
            return 'background-color:#7CCD7C;color:#fff;';
        }
        return 'background-color:FFB90F;color:#fff;';
    }

    //加载tree
    $(function(){
        $.ajax({
            url:"userProgramController.do?getManagerList",
            type:"post",
            data:{"optFlag":2},
            dataType:"json",
            success:function(d){
                if (d.success) {
                    var dbDate = new Array(d.obj.length);
                    for (var i = 0; i <  d.obj.length; i++) {
                        dbDate[i]={name:d.obj[i].nameList,
                        code:d.obj[i].valueList};
                    }
                    $.fn.zTree.init($("#managerList"), setting, dbDate);

                    // $("#sitePanel").panel({
                    //     title:dbDate[0].name,
                    //     content:'<iframe src="' + dbDate[0].site + '" frameborder=0 height=100% width=100% ></iframe>'
                    // });
                }
            }
        });

        $(".layout-button-right").click();
    });

    //初始化子表list/刷新子表数据
    function initBusiList(id){
        id = iframeMainBusiPageid(id);
        if(!id){
            console.log("树无选中");
        }else{
            var listname = $("#mainPageFrameActived").val();
            if ("tBBusinessList" == listname) {
                refreshTabData(listname,window.top.reload_businessTab(id));
            }
            if ("tBChancePoolList" == listname) {
                refreshTabData(listname,window.top.reload_chancePoolTab(id));
            }
            if ("tBProfitTargetList" == listname) {
                refreshTabData(listname,window.top.reload_profitTab(id));
            }

        }
    }
    //设置/获取隐藏域主表id
    function iframeMainBusiPageid(id){
        if(!id){
            return $("#mainPageHiddenId").val();
        }else{
            $("#mainPageHiddenId").val(id);
            return id;
        }
    }

    /**
     * 刷新指定的tab里面的数据
     * @param title 选项卡标题
     * @param refreshTabFunc  自定义的刷新方法(再各个页面具体实现)
     */
    function refreshTabData(title,refreshGridFunc) {
        if ($("#tabsOne").tabs('exists', title)) {
            // $('#tabsOne').tabs('select', title);
            typeof refreshGridFunc === 'function' && refreshGridFunc.call();
        }
    }

    $("#tabsOne").click(function(){
        var createBy = $("#mainPageHiddenId").val();
        var tab = $('#tabsOne').tabs('getSelected');
        var index = $('#tabsOne').tabs('getTabIndex',tab);
        /*if (index == 0) {
            $("#mainPageFrameActived").find("option[value='tBBusinessList']").attr("selected",true);
        }*/
        if (index == 0) {
            $("#mainPageFrameActived").find("option[value='tBChancePoolList']").attr("selected",true);
            if (createBy != null && createBy !== '') {
                sessionStorage.setItem("createBy", createBy);
            }
        }
        if (index == 1) {
            $("#mainPageFrameActived").find("option[value='tBProfitTargetList']").attr("selected",true);
        }
    });


</script>
