<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>服务目录管理</title>
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
 <form id="formobj" action="tBCatalogdataController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="name" class="col-sm-3 control-label">名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="name" name="name" type="text" maxlength="100" class="form-control input-sm" placeholder="请输入名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="danwei" class="col-sm-3 control-label">单位：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="danwei" name="danwei" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入单位"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="fartherid" class="col-sm-3 control-label">父节点ID：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="fartherid" name="fartherid" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入父节点ID"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="num" class="col-sm-3 control-label">数量：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="num" name="num" type="text" maxlength="32" class="form-control input-sm" placeholder="请输入数量"  datatype="n"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="beizhu" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="beizhu" name="beizhu" type="text" maxlength="80" class="form-control input-sm" placeholder="请输入备注"  ignore="ignore" />
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
		
		//单选框/多选框初始化
		$('.i-checks').iCheck({
			labelHover : false,
			cursor : true,
			checkboxClass : 'icheckbox_square-blue',
			radioClass : 'iradio_square-blue',
			increaseArea : '20%'
		});
		
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
	
</script>
</body>
</html>