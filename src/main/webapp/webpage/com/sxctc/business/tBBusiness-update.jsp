<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>营销数据业务主表</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Jquery组件引用 -->
<script src="${webRoot}/plug-in/jquery/jquery-1.9.1.js"></script>

<!-- bootstrap组件引用 -->
<link href="${webRoot}/plug-in/bootstrap3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="${webRoot}/plug-in/bootstrap3.3.5/js/bootstrap.min.js"></script>
<!-- icheck组件引用 -->
<link href="${webRoot}/plug-in/icheck-1.x/skins/square/_all.css" rel="stylesheet">
<script type="text/javascript" src="${webRoot}/plug-in/icheck-1.x/icheck.js"></script>

<!-- Validform组件引用 -->
<link href="${webRoot}/plug-in/themes/bootstrap-ext/css/validform-ext.css" rel="stylesheet" />
<script type="text/javascript" src="${webRoot}/plug-in/Validform/js/Validform_v5.3.1_min_zh-cn.js"></script>
<script type="text/javascript" src="${webRoot}/plug-in/Validform/js/Validform_Datatype_zh-cn.js"></script>
<script type="text/javascript" src="${webRoot}/plug-in/Validform/js/datatype_zh-cn.js"></script>
<script type="text/javascript" src="${webRoot}/plug-in/Validform/plugin/passwordStrength/passwordStrength-min.js"></script>
<!-- Layer组件引用 -->
<script src="${webRoot}/plug-in/layer/layer.js"></script>
<script src="${webRoot}/plug-in/laydate/laydate.js"></script>
<!-- 通用组件引用 -->
<link href="${webRoot}/plug-in/bootstrap3.3.5/css/default.css" rel="stylesheet" />
<script src="${webRoot}/plug-in/themes/bootstrap-ext/js/common.js"></script>
</head>
 <body style="overflow:hidden;overflow-y:auto;margin-top: 20px">
 <form id="formobj" action="tBBusinessController.do?doUpdate" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id" value="${tBBusinessPage.id}"/>
	<input type="hidden" id="unitName" name="${tBBusinessPage.unitName}"/>
	<div class="form-group">
		<label for="unitCode" class="col-sm-3 control-label">厅局名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect id="unitCode" field="unitCode" type="list" extendJson="{class:'form-control input-sm'}"  defaultVal="${tBBusinessPage.unitCode}"  typeGroupCode="unit_name"  hasLabel="false"  title="厅局名称"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="projectName" class="col-sm-3 control-label">迁移系统名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="projectName" name="projectName" value='${tBBusinessPage.projectName}' type="text" maxlength="32" class="form-control input-sm" placeholder="请输入迁移系统名称"  datatype="*" ignore="checked" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="projectStatus" class="col-sm-3 control-label">系统类型：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect id="projectStatus" field="projectStatus" type="radio" typeGroupCode="proj_type" defaultVal="${tBBusinessPage.projectStatus}"  hasLabel="false"  title="厅局名称"></t:dictSelect>
			</div>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="cloudStatus" class="col-sm-3 control-label">是否上云：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect id="cloudStatus" field="cloudStatus" type="radio"  typeGroupCode="dev_flag" defaultVal="${tBBusinessPage.cloudStatus}"  hasLabel="false"  title="是否上云"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="chanceStatus" class="col-sm-3 control-label">是否有机会：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect id="chanceStatus" field="chanceStatus" type="radio"  typeGroupCode="dev_flag" defaultVal="${tBBusinessPage.chanceStatus}" hasLabel="false"  title="是否上云"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="joinStatus" class="col-sm-3 control-label">对接状态：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect id="joinStatus" field="joinStatus" type="radio"  typeGroupCode="joinStatus" defaultVal="${tBBusinessPage.joinStatus}" hasLabel="false"  title="是否上云"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="busCreateTime" class="col-sm-3 control-label">业务创建时间：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="busCreateTime" name="busCreateTime" type="text" class="form-control input-sm" placeholder="请输入业务创建时间"  datatype="*" ignore="checked"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${tBBusinessPage.busCreateTime}'/>" />
                <span class="input-group-addon" >
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
			</div>
		</div>
	</div>
	<div id="checkContent">
	<div class="form-group">
		<label for="busJoinTime" class="col-sm-3 control-label">业务对接时间：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="busJoinTime" name="busJoinTime" type="text" class="form-control input-sm" placeholder="请输入业务对接时间"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${tBBusinessPage.busJoinTime}'/>" />
                <span class="input-group-addon" >
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
			</div>
		</div>
	</div>
	<%--<div class="form-group">
		<label for="hardServeCatalog" class="col-sm-3 control-label">硬件服务目录：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="hardServeCatalog" name="hardServeCatalog" value='${tBBusinessPage.hardServeCatalog}' type="text" maxlength="500" class="form-control input-sm" placeholder="请输入硬件服务目录"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="baseServeCatalog" class="col-sm-3 control-label">基础层服务目录：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="baseServeCatalog" name="baseServeCatalog" value='${tBBusinessPage.baseServeCatalog}' type="text" maxlength="500" class="form-control input-sm" placeholder="请输入基础层服务目录"  ignore="ignore" />
			</div>
		</div>
	</div>--%>
	<div class="form-group">
		<label for="protocolStatus" class="col-sm-3 control-label">是否收回协议：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect id="protocolStatus" field="protocolStatus" type="radio"  typeGroupCode="dev_flag" defaultVal="${tBBusinessPage.protocolStatus}" hasLabel="false"  title="是否上云"></t:dictSelect>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="protocolTime" class="col-sm-3 control-label">收回协议时间：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		    <input id="protocolTime" name="protocolTime" type="text" class="form-control input-sm" placeholder="请输入收回协议时间"  ignore="ignore"  value="<fmt:formatDate pattern='yyyy-MM-dd' type='date' value='${tBBusinessPage.protocolTime}'/>" />
                <span class="input-group-addon" >
                    <span class="glyphicon glyphicon-calendar"></span>
                </span>
			</div>
		</div>
	</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
				//业务创建时间 日期控件初始化
			    laydate.render({
				   elem: '#busCreateTime'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#busCreateTime").val(DateJsonFormat(date,this.format));
				  }
				});
				//业务对接时间 日期控件初始化
			    laydate.render({
				   elem: '#busJoinTime'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#busJoinTime").val(DateJsonFormat(date,this.format));
				  }
				});
				//收回协议时间 日期控件初始化
			    laydate.render({
				   elem: '#protocolTime'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#protocolTime").val(DateJsonFormat(date,this.format));
				  }
				});
		
		//单选框/多选框初始化
		$('.i-checks').iCheck({
			labelHover : false,
			cursor : true,
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%'
		});

		// 页面显示初始化:如果未对接，则隐藏下面内容
        var joinVal = $('input:radio[name="joinStatus"]').val();
		if(joinVal == 1){
			$("#checkContent").show();
		}else {
			$("#checkContent").hide();
		}

		//表单提交
		$("#formobj").Validform({
			tiptype:function(msg,o,cssctl){
				if(o.type==3){
					validationMessage(o.obj,msg);
				}else{
					removeMessage(o.obj);
				}
			},
			btnSubmit : "#btn_sub",
			btnReset : "#btn_reset",
			ajaxPost : true,
			beforeSubmit : function(curform) {
			},
			usePlugin : {
				passwordstrength : {
					minLen : 6,
					maxLen : 18,
					trigger : function(obj, error) {
						if (error) {
							obj.parent().next().find(".Validform_checktip").show();
							obj.find(".passwordStrength").hide();
						} else {
							$(".passwordStrength").show();
							obj.parent().next().find(".Validform_checktip").hide();
						}
					}
				}
			},
			callback : function(data) {
				var win = frameElement.api.opener;
				if (data.success == true) {
					frameElement.api.close();
				    win.reloadTable();
				    win.tip(data.msg);
				} else {
				    if (data.responseText == '' || data.responseText == undefined) {
				        $.messager.alert('错误', data.msg);
				        $.Hidemsg();
				    } else {
				        try {
				            var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
				            $.messager.alert('错误', emsg);
				            $.Hidemsg();
				        } catch (ex) {
				            $.messager.alert('错误', data.responseText + "");
				            $.Hidemsg();
				        }
				    }
				    return false;
				}
			}
		});
	});

    $('input:radio[name="projectStatus"]').click(function(){
        if($(this).val()==1){
            $("input:radio[name='chanceStatus'][value=1]").attr("checked",true);
        }else {
            $("input:radio[name='chanceStatus'][value=0]").attr("checked",true);
        }
    });

    $('input:radio[name="joinStatus"]').click(function(){
        if($(this).val()==0){
            $("#checkContent").hide();
        }else {
            $("#checkContent").show();
        }
    });

    $('#unitCode').change(function(){
        $("#unitName").val($('#unitCode option:selected').text());
    });
</script>
</body>
</html>