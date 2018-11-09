var tBBusinessListdictsData={};
<!--首页banner系统数量-->
var echartsWarp= document.getElementById('echarts_percent');
var myChart = echarts.init(echartsWarp);
$(document).ready(function () {
    /** 加载系统总览数据 */
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
                        text: percent+"%",
                        x: 'center',
                        y: 'center',
                        textStyle: {
                            fontWeight: 'normal',
                            color: '#0580f2',
                            fontSize: '20'
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
                            value: 100-percent,
                            name: 'invisible'
                        }]
                    }
                    ]
                };
                myChart.setOption(option);
            }

        }
    });

    /** 加载代办事项和待跟进项目列表 */
    var promiseArr = [];
    promiseArr.push(new Promise(function(resolve, reject) {
        initDictByCode(tBBusinessListdictsData,"unit_name",resolve);
    }));

    //1.初始化Table
    var oTable = new TableInit();
    var oTodoTable = new TodoTableInit();
    var oStatusTable = new StatusTableInit();
    oTable.Init();
    oTodoTable.Init();
    oStatusTable.Init();

    // 隐藏列头
    $('#tBTodoListList tr').each(function (i,e) {
        if (i == 0) {
            $(this).hide();
        }
    });
    $('#tBStatusListList tr').each(function (i,e) {
        if (i == 0) {
            $(this).hide();
        }
    });
});

/**
 * 待跟进项目列表
 * @returns {Object}
 * @constructor
 */
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#jeecgDemoList').bootstrapTable({
            url: 'tbMainController.do?reportDatagrid&reportOpt=0',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortName: "reportDate",
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height : $('#followContent').height(),   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                   //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            showExport: false,                    //显示到处按钮
            columns: [{
                field: 'unitCode',
                title: '单位名称',
                align: 'center',
                valign: 'middle',
                sortable:true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.unit_name);
                }
            },{
                field: 'reportTitle',
                title: '系统名称',
                align: 'center',
                valign: 'middle',
                sortable:true
            }, {
                field: 'reportDate',
                title: '最近一次跟进时间',
                align: 'center',
                valign: 'middle',
                sortable:true,
                formatter: function (value, row, index) {
                    if(value.length>5){
                        return value.substring(0,10);
                    }else{
                        return value;
                    }
                }
            }, {
                field: 'unFollowDay',
                title: '未跟进时间',
                align: 'center',
                valign: 'middle',
                sortable:true
            }, {
                field: 'doneToday',
                title: '最近一次跟进内容',
                align: 'center',
                valign: 'middle',
                sortable:true
            }, {
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    // return '<button class="btn btn-success btn-xs" onclick="addMyTab({id:\'home1\',title:\'日报\',close: true,url: \'tBBusiWorkreportController.do?mainlist\'});"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span>录入今日日报</button>';
                    return '<a class="J_menuItem" href="tBBusiWorkreportController.do?mainlist" data-index="13"><i class="fa fa-tags"></i><span class="menu-text">录入今日日报</span></a>';

                }
            } ],
            onLoadSuccess: function(){  //加载成功时执行
                console.info("加载成功");
                var data = $('#jeecgDemoList').bootstrapTable('getData', true);
                //合并单元格
                mergeCells(data, "unitCode", 1, $('#jeecgDemoList'));
            },
            onLoadError: function(){  //加载失败时执行
                console.info("加载数据失败");
            }
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, // 每页要显示的数据条数
            offset: params.offset,  //页码
            sort: params.sort, // 排序规则
            order: params.order,
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            pageIndex:params.pageNumber,//请求第几页
            field:'id,unitCode,reportTitle,reportDate,doneToday,unFollowDay'
        };
        return temp;
    };
    return oTableInit;
};

function jeecgDemoSearch(){
    reloadTable();
}

function reloadTable(){
    $('#tBTodoListList').bootstrapTable('refresh');
}

/**
 * 代办事项列表
 * @returns {Object}
 * @constructor
 */
var TodoTableInit = function () {
    var oTodoTableInit = new Object();
    //初始化Table
    oTodoTableInit.Init = function () {
        $('#tBTodoListList').bootstrapTable({
            url: 'tBTodoListController.do?datagrid&todoStatus=0',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortName: "createDate",
            sortOrder: "desc",                   //排序方式
            queryParams: oTodoTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height : $('#iboxContent').height(),   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                   //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            showExport: false,                    //显示到处按钮
            columns: [{
                field: 'createDate',
                title: '创建时间',
                align: 'center',
                valign: 'middle',
                width: 80,
                sortable:true,
                formatter: function (value, row, index) {
                    if(value.length>5){
                        return value.substring(0,10);
                    }else{
                        return value;
                    }
                }
            },{
                field: 'todoContent',
                title: '代办事项',
                align: 'center',
                valign: 'middle',
                sortable:true
            }, {
                title: "操作",
                align: 'center',
                valign: 'middle',
                width: 160, // 定义列的宽度，单位为像素px
                formatter: function (value, row, index) {
                    // return '<button class="btn btn-success btn-xs" onclick="update(\'tBTodoListController.do?doUpate&todoStatus=1&id='+row.id+'\',\'tBTodoListList\')"><span class="glyphicon glyphicon-save" aria-hidden="true"></span>完成</button>&nbsp;&nbsp;<button class="btn btn-danger btn-xs" onclick="delObj(\'jeecgListDemoController.do?doDel&id='+row.id+'\',\'jeecgDemoList\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';
                    return '<button class="btn btn-success btn-xs" onclick="doTodoUpdate(\'tBTodoListController.do?doUpdate&todoStatus=1&id='+row.id+'\',\'tBTodoListList\')"><span class="glyphicon glyphicon-save" aria-hidden="true"></span>完成</button>&nbsp;&nbsp;<button class="btn btn-danger btn-xs" onclick="delObj(\'tBTodoListController.do?doDel&id='+row.id+'\',\'tBTodoListList\')"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除</button>';

                }
            } ],
            onLoadSuccess: function(){  //加载成功时执行
                console.info("加载成功");
            },
            onLoadError: function(){  //加载失败时执行
                console.info("加载数据失败");
            }
        });
    };

    //得到查询的参数
    oTodoTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, // 每页要显示的数据条数
            offset: params.offset,  //页码
            sort: params.sort, // 排序规则
            order: params.order,
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            pageIndex:params.pageNumber,//请求第几页
            field:'id,createDate,todoContent'
        };
        return temp;
    };
    return oTodoTableInit;
};

function jeecgDemoTodoSearch(){
    reloadTodoTable();
}

function reloadTodoTable(){
    $('#tBTodoListList').bootstrapTable('refresh');
}

/**
 * 系统状态列表
 * @returns {Object}
 * @constructor
 */
var StatusTableInit = function () {
    var oStatusTableInit = new Object();
    //初始化Table
    oStatusTableInit.Init = function () {
        $('#tBStatusListList').bootstrapTable({
            url: 'tBBusinessController.do?datagrid',         //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "desc",                   //排序方式
            queryParams: oStatusTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            strictSearch: true,
            showColumns: false,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height : $('#statusContent').height(),   //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "id",                   //每一行的唯一标识，一般为主键列
            showToggle:false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            showExport: false,                    //显示到处按钮
            fitColumns: true,
            columns: [{
                field: 'unitCode',
                title: '单位名称',
                align: 'center',
                valign: 'middle',
                sortable:true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.unit_name);
                }
            },{
                field: 'projectName',
                title: '系统名称',
                align: 'center',
                valign: 'middle',
                sortable:true
            }, {
                field: 'joinStatus',
                title: '上云状态',
                align: 'center',
                valign: 'middle',
                width:700,
                sortable:true,
                formatter : function(value, rec, index) {
                    if (value == 0) {
                        return "<div class='status status-content-0'>未对接</div>";
                    }
                    if (value == 1) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>";
                    }
                    if (value == 2) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>" +
                            "<div class='status status-content-2'>取得调研表</div>";
                    }
                    if (value == 3) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>" +
                            "<div class='status status-content-2'>取得调研表</div>" +
                            "<div class='status status-content-3'>签订方案</div>";
                    }
                    if (value == 4) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>" +
                            "<div class='status status-content-2'>取得调研表</div>" +
                            "<div class='status status-content-3'>签订方案</div>" +
                            "<div class='status status-content-4'>分配资源</div>";
                    }
                    if (value == 5) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>" +
                            "<div class='status status-content-2'>取得调研表</div>" +
                            "<div class='status status-content-3'>签订方案</div>" +
                            "<div class='status status-content-4'>分配资源</div>" +
                            "<div class='status status-content-5'>上云测试</div>";
                    }
                    if (value == 6) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>" +
                            "<div class='status status-content-2'>取得调研表</div>" +
                            "<div class='status status-content-3'>签订方案</div>" +
                            "<div class='status status-content-4'>分配资源</div>" +
                            "<div class='status status-content-5'>上云测试</div>" +
                            "<div class='status status-content-6'>回收协议</div>";
                    }
                    if (value == 7) {
                        return "<div class='status status-content-0'>未对接</div>" +
                            "<div class='status status-content-1'>上云对接</div>" +
                            "<div class='status status-content-2'>取得调研表</div>" +
                            "<div class='status status-content-3'>签订方案</div>" +
                            "<div class='status status-content-4'>分配资源</div>" +
                            "<div class='status status-content-5'>上云测试</div>" +
                            "<div class='status status-content-6'>回收协议</div>" +
                            "<div class='status status-content-7'>上云完成</div>";
                    }
                }
            } ],
            onLoadSuccess: function(){  //加载成功时执行
                console.info("加载成功");
                //合并单元格
                var data = $('#tBStatusListList').bootstrapTable('getData', true);
                mergeCells(data, "unitCode", 1, $('#tBStatusListList'));
            },
            onLoadError: function(){  //加载失败时执行
                console.info("加载数据失败");
            }
        });
    };

    //得到查询的参数
    oStatusTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, // 每页要显示的数据条数
            offset: params.offset,  //页码
            sort: params.sort, // 排序规则
            order: params.order,
            rows: params.limit,                         //页面大小
            page: (params.offset / params.limit) + 1,   //页码
            pageIndex:params.pageNumber,//请求第几页
            field:'id,unitCode,projectName,joinStatus'
        };
        return temp;
    };
    return oStatusTableInit;
};


//列表数据字典项格式化
function listDictFormat(value,dicts){
    if (!value) return '';
    var valArray = value.split(',');
    var showVal = '';
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

function mergeCells(data,fieldName,colspan,target){
    //声明一个map计算相同属性值在data对象出现的次数和
    var sortMap = {};
    for(var i = 0 ; i < data.length ; i++){
        for(var prop in data[i]){
            if(prop == fieldName){
                var key = data[i][prop]
                if(sortMap.hasOwnProperty(key)){
                    sortMap[key] = sortMap[key] * 1 + 1;
                } else {
                    sortMap[key] = 1;
                }
                break;
            }
        }
    }
    var index = 0;
    for(var prop in sortMap){
        var count = sortMap[prop] * 1;
        $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});
        index += count;
    }
}

function doTodoUpdate(url,name) {
    layer.confirm('确认完成？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        $.ajax({
            url : url,
            type : 'GET',
            dataType: 'json',
            cache : false,
            success : function(data) {
                if (data.success) {
                    var msg = data.msg;
                    tip(msg);
                    reloadTodoTable();
                }
            }
        });

    }, function(){
    });
}


function addTodo(title, addurl, gname, width, height) {
    layer.open({
        type : 2,
        title : title,
        area : [ '50%', '50%' ],
        shade : 0.3,
        maxmin : true,
        content : addurl,
        btn : [ '确定', '关闭' ],
        yes : function(index, layero) {
            var body = layer.getChildFrame('body', index);
            body.find('#btn_sub').click();
            //layer.getFrameIndex(window.name).getdo
            layer.close(index);
        },
        btn2 : function(index, layero) {
            layer.closeAll();
        },
        zIndex : layer.zIndex,
        success : function(layero) {
            layer.setTop(layero);
            reloadTodoTable()
        }
    });
}