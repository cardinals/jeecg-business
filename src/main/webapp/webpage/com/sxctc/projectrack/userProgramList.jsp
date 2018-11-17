<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui"></t:base>

<link rel="stylesheet" type="text/css" href="plug-in/ztree/css/zTreeStyle.css">
<script type="text/javascript" src="plug-in/echart/echarts.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script type="text/javascript" src="plug-in/ztree/js/jquery.ztree.excheck-3.5.min.js"></script>
<div class="easyui-layout" fit="true">
    <div data-options="region:'west',title:'业务人员',split:true" style="width:100px;">
        <ul id="managerList" class="ztree" ></ul>
    </div>
    <div data-options="region:'east',title:'分析',split:true"  style="width:500px;">
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
            <t:tab href="tBBusinessController.do?list&optFlag=1" icon="icon-search" title="上云项目" id="tBBusinessListIframe"></t:tab>
            <t:tab href="tBChancePoolController.do?list" icon="icon-search" title="机会池" id="tBChancePoolListIframe"></t:tab>
            <t:tab href="tBProfitTargetController.do?list" icon="icon-search" title="已签订项目" id="tBProfitTargetListIframe"></t:tab>
        </t:tabs>
    </div>
</div>
<div style="display:none">
    <!-- 激活选项卡再刷新页面需要该隐藏域 -->
    <input type="hidden" id="mainPageHiddenId">
    <select id="mainPageFrameActived" style="display:none">
        <option value="tBBusinessList" selected="selected"></option>
        <option value="tBChancePoolList"></option>
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
        /*$.ajax({
            url:"userProgramController.do?getProgramList",
            type:"post",
            data:{userCode:treeNode.code},
            dataType:"json",
            success:function(data){
                if(data.success){
                    //$('#programList').datagrid('loadData', data.obj);
                    $('#tBBusinessList').datagrid({
                        queryParams: {
                            createBy: treeNode.code
                        }
                    });
                }
            }
        });
        $.ajax({
            url:"userProgramController.do?getChanceProgramList",
            type:"post",
            data:{userCode:treeNode.code},
            dataType:"json",
            success:function(data){
                if(data.success){
                    $('#chanceProgramList').datagrid('loadData', data.obj);
                }
            }
        });*/
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
        var promiseArr = [];
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(chanceProgramListdictsData,"unit_name",resolve);
        }));
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(chanceProgramListdictsData,"control",resolve);
        }));
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(chanceProgramListdictsData,"provide",resolve);
        }));
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(chanceProgramListdictsData,"dev_flag",resolve);
        }));

        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(programListdictsData,"joinStatus",resolve);
        }));
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(programListdictsData,"provide",resolve);
        }));
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(programListdictsData,"dev_flag",resolve);
        }));
        promiseArr.push(new Promise(function(resolve, reject) {
            initDictByCode(programListdictsData,"proj_type",resolve);
        }));


        $.ajax({
            url:"userProgramController.do?getManagerList",
            type:"post",
            data:{},
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
        $('#programList').datagrid({
            url:'userProgramController.do?getProgramList',
            columns:[[
                {field:'unitCode',title:'单位名称',width:200, hidden:true, align:'center'},
                {field:'unitName',title:'厅局名称',width:200, align:'center'},
                {field:'projectName',title:'系统名称',width:200,align:'center'},
                {field:'joinStatus',title:'上云状态',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,programListdictsData.joinStatus); }},
                {field:'fundsProvided',title:'资金来源',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,programListdictsData.provide); }},
                {field:'auditStatus',title:'是否审计系统',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,programListdictsData.dev_flag); }},
                {field:'projectStatus',title:'系统状态',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,programListdictsData.proj_type); }},
                {field:'chanceStatus',title:'是否跟踪',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,programListdictsData.dev_flag); }},
                {field:'busCreateTime',title:'业务创建时间',width:100,align:'center'},
                {field:'busJoinTime',title:'首次对接时间',width:100,align:'center'},
                {field:'finishTime',title:'上云完成时间',width:100,align:'center'}
                // {field:'dayRange',title:'时间跨越',width:100,align:'center'}
            ]],
            onClickRow: function(index,rowData){
                var url = "userProgramController.do?programSequence&businessId="+rowData.id;
                $.dialog({
                    content: "url:"+url,
                    lock : true,
                    title:'上云时序图',
                    opacity : 0.3,
                    width:900,
                    height:500,
                    cache:false
                });
            }
        });
        $('#chanceProgramList').datagrid({
            url:'userProgramController.do?getChanceProgramList',
            columns:[[
                {field:'unitCode',title:'单位名称',width:200,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,chanceProgramListdictsData.unit_name); }},
                {field:'projectName',title:'系统名称',width:200,align:'center'},
                {field:'projectBudget',title:'项目预算(万元)',width:100,align:'center'},
                {field:'projectServer',title:'软件和服务(万元)',width:100,align:'center'},
                {field:'projectHardware',title:'硬件(万元)',width:100,align:'center'},
                {field:'businessParters',title:'主要合作公司',width:200,align:'center'},
                {field:'predictTenderTime',title:'预计招标时间',width:100,align:'center'},
                {field:'fundsProvided',title:'资金来源',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,chanceProgramListdictsData.provide); }},
                {field:'topRelation',title:'上层关系',width:100,align:'center'},
                {field:'midRelation',title:'中层关系',width:100,align:'center'},
                {field:'bottomRelation',title:'下层关系',width:100,align:'center'},
                {field:'controlDegree',title:'当年把控度',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,chanceProgramListdictsData.control); }},
                {field:'projectPlan',title:'计划',width:180,align:'center'},
                {field:'winningResult',title:'是否中标',width:100,align:'center',formatter : function(value, rec, index) { return listDictFormat(value,chanceProgramListdictsData.dev_flag); }},
                {field:'remark',title:'备注',width:100,align:'center'}
            ]]
        });
    });


    //加载字典数据
    function initDictByCode(dictObj,code,callback){
        if(!dictObj[code]){
            jQuery.ajax({
                url: "systemController.do?typeListJson&typeGroupName="+code,
                type:"GET",
                dataType:"JSON",
                success: function (back) {
                    if(back.success){
                        dictObj[code]= back.obj;

                    }
                    callback();
                }
            });
        }
    }

    //列表数据字典项格式化
    function listDictFormat(value,dicts){
        if (value == null) return '';
        var valArray = value.toString().split(',');
        var showVal;
        if (valArray.length > 1) {
            for (var k = 0; k < valArray.length; k++) {
                if(dicts && dicts.length>0){
                    for(var a = 0;a < dicts.length;a++){
                        if(dicts[a].typecode ==valArray[k]){
                            showVal = showVal + dicts[a].typename + ',';
                            break;
                        }
                    }
                }
            }
            showVal=showVal.substring(0, showVal.length - 1);
        }else{
            if(dicts && dicts.length>0){
                for(var a = 0;a < dicts.length;a++){
                    if(dicts[a].typecode == value){
                        showVal =  dicts[a].typename;
                        break;
                    }
                }
            }
        }
        return showVal;
    }

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
        if (index == 0) {
            $("#mainPageFrameActived").find("option[value='tBBusinessList']").attr("selected",true);
        }
        if (index == 1) {
            $("#mainPageFrameActived").find("option[value='tBChancePoolList']").attr("selected",true);
        }
        if (index == 2) {
            $("#mainPageFrameActived").find("option[value='tBProfitTargetList']").attr("selected",true);
        }
    });


</script>
