<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>营销数据业务主表</title>
<t:base type="jquery,easyui,tools,DatePicker,autocomplete"></t:base>
<link rel="stylesheet" href="${webRoot}/plug-in/themes/naturebt/css/search-form.css">
</head>
<body>
<div class="easyui-layout" fit="true">
	<div region="center" style="padding:0px;border:0px">
		<table id="tBBusinessList"></table>
	</div>
	<div id = "tBBusinessListToolbar">
		<div class="easyui-panel toolbar-search" style="display:none" data-options="doSize:false">
			<form id="tBBusinessForm" onkeydown="if(event.keyCode==13){doSearch();return false;}">
				<div class="seerch-div">
					<label>创建人名称:</label>
					<div class="search-control">
						<input class="dts search-inp" type="text" name="createName" placeholder="请输入创建人名称"/>
					</div>
				</div>
				<div class="seerch-div">
					<label style="visibility:hidden">查询</label>
					<div>
					<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="doSearch()">
						<i class="fa fa-search"></i>
						<span>查询</span>
					</button>
					
					<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="resetSearch()">
						<i class="fa fa-refresh"></i>
						<span>重置</span>
					</button>
					</div>
				</div>
			</form>
		</div>
		<div class="toolbar-btn">
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="add('录入','tBBusinessController.do?goAdd','tBBusinessList',768,500)">
				<i class="fa fa-plus"></i>
				<span>录入</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="update('编辑','tBBusinessController.do?goUpdate','tBBusinessList',768,500)">
				<i class="fa fa-edit"></i>
				<span>编辑</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="deleteALLSelect('批量删除','tBBusinessController.do?doBatchDel','tBBusinessList',null,null)">
				<i class="fa fa-trash"></i>
				<span>批量删除</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="openuploadwin('Excel导入', 'tBBusinessController.do?upload', 'tBBusinessList')">
				<i class="fa fa-download"></i>
				<span>导入</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tBBusinessController.do?exportXls','tBBusinessList')">
				<i class="fa fa-upload"></i>
				<span>导出</span>
			</button>
			
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="JeecgExcelExport('tBBusinessController.do?exportXlsByT','tBBusinessList')">
				<i class="fa fa-upload"></i>
				<span>模版下载</span>
			</button>
		
			<button type="button" class="tool-btn tool-btn-default tool-btn-xs" onclick="$('.toolbar-search').slideToggle(function(){$('#tBBusinessList').datagrid('resize');});">
				<i class="fa fa-arrow-circle-left"></i>
				<span>检索</span>
			</button>
		</div>
	</div>
</div>

<script>
var tBBusinessListdictsData = {};
$(function(){
	var promiseArr = [];

	promiseArr.push(new Promise(function(resolve, reject) {
		initDictByCode(tBBusinessListdictsData,"unit_name",resolve);
		initDictByCode(tBBusinessListdictsData,"proj_type",resolve);
		initDictByCode(tBBusinessListdictsData,"joinStatus",resolve);
		initDictByCode(tBBusinessListdictsData,"dev_flag",resolve);
	}));

    Promise.all(promiseArr).then(function(results) {
    	initDatagrid();
		$('#tBBusinessList').datagrid('getPager').pagination({
	        beforePageText: '',
	        afterPageText: '/{pages}',
	        displayMsg: '{from}-{to}共 {total}条',
	        showPageList: true,
	        showRefresh: true
	    });
	    $('#tBBusinessList').datagrid('getPager').pagination({
	        onBeforeRefresh: function(pageNumber, pageSize) {
	            $(this).pagination('loading');
	            $(this).pagination('loaded');
	        }
	    });
	    
	}).catch(function(err) {
	 	console.log('Catch: ', err);
	});
	
});

//easyui-datagrid实例化
function initDatagrid(){
	var actionUrl = "tBBusinessController.do?datagrid&field=id,createName,createBy,createDate,updateName,updateBy,updateDate,sysOrgCode,sysCompanyCode,bpmStatus,unitCode,unitName,projectCode,projectName,projectStatus,cloudStatus,chanceStatus,joinStatus,busCreateTime,busJoinTime,hardServeCatalog,baseServeCatalog,protocolStatus,protocolTime,auditStatus,backupField1,backupField2,backupField3,backupField4,backupField5,backupField6,";
 	$('#tBBusinessList').datagrid({
		url:actionUrl,
		idField: 'id', 
		title: '营销数据业务主表',
		loadMsg: '数据加载中...',
		fit:true,
		fitColumns:false,
		striped:true,
		autoRowHeight: true,
		pageSize: 10,
		pagination:true,
		singleSelect:false,
		pageList:[10,30,50,100],
		rownumbers:true,
		showFooter:true,
		toolbar: '#tBBusinessListToolbar',
		frozenColumns:[[]],
		columns:[[
			{field:'ck',checkbox:true}
			,{
				field : "id",
				title : "主键",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "createName",
				title : "创建人名称",
				width : 120,
				sortable: true,
			}
			,{
				field : "createBy",
				title : "创建人登录名称",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "createDate",
				title : "创建日期",
				width : 120,
				sortable: true,
				hidden:true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "updateName",
				title : "更新人名称",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "updateBy",
				title : "更新人登录名称",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "updateDate",
				title : "更新日期",
				width : 120,
				sortable: true,
				hidden:true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "sysOrgCode",
				title : "所属部门",
				width : 120,
				sortable: true,
			}
			,{
				field : "sysCompanyCode",
				title : "所属公司",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "bpmStatus",
				title : "流程状态",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "unitName",
				title : "厅局名称",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "unitCode",
				title : "厅局名称",
				width : 120,
				sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.unit_name);
                }
			}
			,{
				field : "projectCode",
				title : "迁移系统编号",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "projectName",
				title : "迁移系统名称",
				width : 120,
				sortable: true,
			}
			,{
				field : "projectStatus",
				title : "系统类型",
				width : 120,
				sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.proj_type);
                }
			}
			,{
				field : "cloudStatus",
				title : "是否上云",
				width : 120,
				sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.dev_flag);
                }
			}
			,{
				field : "chanceStatus",
				title : "是否有机会",
				width : 120,
				background : "#3a87ad",
				sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.dev_flag);
                }
			}
            ,{
                field : "auditStatus",
                title : "是否在审计范围",
                width : 120,
                sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.dev_flag);
                }
            }
			,{
				field : "joinStatus",
				title : "对接状态",
				width : 120,
				sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.joinStatus);
                },
                styler : function(value, rec, index) {
				    if (rec.joinStatus == 0) {
                        return 'background-color:#FF4040;color:#fff;';
					}
                    return 'background-color:#ffee00;color:red;';
                }
			}
			,{
				field : "busCreateTime",
				title : "业务创建时间",
				width : 120,
				sortable: true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "busJoinTime",
				title : "业务对接时间",
				width : 120,
				sortable: true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "hardServeCatalog",
				title : "硬件服务目录",
				width : 120,
				sortable: true,
                hidden:true,
			}
			,{
				field : "baseServeCatalog",
				title : "基础层服务目录",
				width : 120,
				sortable: true,
                hidden:true,
			}
			,{
				field : "protocolStatus",
				title : "是否收回协议",
				width : 120,
				sortable: true,
                formatter : function(value, rec, index) {
                    return listDictFormat(value,tBBusinessListdictsData.dev_flag);
                }
			}
			,{
				field : "protocolTime",
				title : "收回协议时间",
				width : 120,
				sortable: true,
				formatter : function(value, rec, index) {
					return new Date().format('yyyy-MM-dd', value);
				}
			}
			,{
				field : "backupField1",
				title : "备用字段1",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "backupField2",
				title : "备用字段2",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "backupField3",
				title : "备用字段3",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "backupField4",
				title : "备用字段4",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "backupField5",
				title : "备用字段5",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
				field : "backupField6",
				title : "备用字段6",
				width : 120,
				sortable: true,
				hidden:true,
			}
			,{
	            field: 'opt',title: '操作',width: 350,
	            formatter: function(value, rec, index) {
	                if (!rec.id) {
	                    return '';
	                }
	                var href = '';
	                href += "<a href='#'   class='ace_button' style='background-color:#ec4758;' onclick=delObj('tBBusinessController.do?doDel&id=" + rec.id + "','tBBusinessList')>  <i class=' fa fa-trash-o'></i> ";
	                href += "删除</a>&nbsp;";

	                // 如果已对接显示服务目录
	                if (rec.joinStatus == 1) {
                        href += "<a href='#'   class='ace_button'  onclick=delObj('tBBusinessController.do?doDel&id=" + rec.id + "','tBBusinessList')>  <i class=' fa fa-trash-o'></i> ";
                        href += "硬件服务目录</a>&nbsp;";
                        href += "<a href='#'   class='ace_button'  onclick=delObj('tBBusinessController.do?doDel&id=" + rec.id + "','tBBusinessList')>  <i class=' fa fa-trash-o'></i> ";
                        href += "基础层服务目录</a>&nbsp;";
                    }
	                return href;
	            }
	        }
		]],
		onLoadSuccess: function(data) {
            $("#tBBusinessList").datagrid("clearSelections");
            if (!false) {
                if (data.total && data.rows.length == 0) {
                    var grid = $('#tBBusinessList');
                    var curr = grid.datagrid('getPager').data("pagination").options.pageNumber;
                    grid.datagrid({
                        pageNumber: (curr - 1)
                    });
                }
            }
        }
	});
}
//easyui-datagrid重新加载
function reloadTable() {
	 $('#tBBusinessList').datagrid('reload');
}
//easyui-datagrid搜索
function doSearch(){
	var queryParams = $('#tBBusinessList').datagrid('options').queryParams;
	var actionUrl = "tBBusinessController.do?datagrid&field=id,createName,createBy,createDate,updateName,updateBy,updateDate,sysOrgCode,sysCompanyCode,bpmStatus,unitCode,unitName,projectCode,projectName,projectStatus,cloudStatus,chanceStatus,joinStatus,busCreateTime,busJoinTime,hardServeCatalog,baseServeCatalog,protocolStatus,protocolTime,auditStatus,backupField1,backupField2,backupField3,backupField4,backupField5,backupField6,";
	$('#tBBusinessForm').find(':input').each(function() {
		var paramName = $(this).attr('name');
		if(!!paramName){
			if("checkbox"== $(this).attr("type")){
				queryParams[paramName] = getCheckboxVal(paramName);
			}else if("radio"== $(this).attr("type")){
				queryParams[paramName] = getRadioVal(paramName);
			}else{
				queryParams[paramName] = $(this).val();
			}
		}
    });
	
    $('#tBBusinessList').datagrid({
        url: actionUrl,
        pageNumber: 1
    });
}
//easyui-datagrid重置搜索
function resetSearch(){
    var queryParams = $('#tBBusinessList').datagrid('options').queryParams;
    $('#tBBusinessForm').find(':input').each(function() {
    	if("checkbox"== $(this).attr("type")){
    		$("input:checkbox[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else if("radio"== $(this).attr("type")){
			$("input:radio[name='" + $(this).attr('name') + "']").attr('checked',false);
		}else{
			$(this).val("");
		}
        queryParams[$(this).attr('name')] = "";
    });
    $('#tBBusinessForm').find("input[type='checkbox']").each(function() {
        $(this).attr('checked', false);
    });
    $('#tBBusinessForm').find("input[type='radio']").each(function() {
        $(this).attr('checked', false);
    });
    var actionUrl = "tBBusinessController.do?datagrid&field=id,createName,createBy,createDate,updateName,updateBy,updateDate,sysOrgCode,sysCompanyCode,bpmStatus,unitCode,unitName,projectCode,projectName,projectStatus,cloudStatus,chanceStatus,joinStatus,busCreateTime,busJoinTime,hardServeCatalog,baseServeCatalog,protocolStatus,protocolTime,auditStatus,backupField1,backupField2,backupField3,backupField4,backupField5,backupField6,";
    $('#tBBusinessList').datagrid({
        url: actionUrl,
        pageNumber: 1
    });
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
//加载form查询数据字典项
function loadSearchFormDicts(obj,arr,type,name){
	var html = "";
	for(var a = 0;a < arr.length;a++){
		if("select"== type){
			html+="<option value = '"+arr[a].typecode+"'>"+arr[a].typename+"</option>";
		}else{
			if(!arr[a].typecode){
			}else{
				html+="<input name = '"+name+"' type='"+type+"' value = '"+arr[a].typecode+"'>"+arr[a].typename +"&nbsp;&nbsp;";
			}
			
		}
    }
	obj.html(html);
}
//获取Checkbox的值
function getCheckboxVal(name){
    var result = new Array();
    $("input[name='" + name + "']:checkbox").each(function() {
        if ($(this).is(":checked")) {
            result.push($(this).attr("value"));
        }
    });
    return result.join(",");
}
//获取radio的值
function getRadioVal(name){
	var v = $('input:radio[name="'+name+'"]:checked').val();
	if(!v){
		v ="";
	}
	return v;
}
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

//列表文件图片 列格式化方法
function listFileImgFormat(value,type){
	var href='';
	if(value==null || value.length==0){
		return href;
	}
	var value1 = "systemController/showOrDownByurl.do?dbPath="+value;
	if("image"==type){
 		href+="<img src='"+value1+"' width=30 height=30  onmouseover='tipImg(this)' onmouseout='moveTipImg()' style='vertical-align:middle'/>";
	}else{
 		if(value.indexOf(".jpg")>-1 || value.indexOf(".gif")>-1 || value.indexOf(".png")>-1){
 			href+="<img src='"+value1+"' onmouseover='tipImg(this)' onmouseout='moveTipImg()' width=30 height=30 style='vertical-align:middle'/>";
 		}else{
 			var value2 = "systemController/showOrDownByurl.do?down=1&dbPath="+value;
 			href+="<a href='"+value2+"' class='ace_button' style='text-decoration:none;' target=_blank><u><i class='fa fa-download'></i>点击下载</u></a>";
 		}
	}
	return href;
}
</script>
</body>
</html>