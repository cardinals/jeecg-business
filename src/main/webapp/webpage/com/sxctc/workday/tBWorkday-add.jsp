<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>日报信息管理</title>
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
 <form id="formobj" action="tBWorkdayController.do?doAdd" class="form-horizontal validform" role="form"  method="post">
	<input type="hidden" id="btn_sub" class="btn_sub"/>
	<input type="hidden" id="id" name="id"/>
	<div class="form-group">
		<label for="createName" class="col-sm-3 control-label">创建人名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="createName" name="createName" type="text" maxlength="50" class="form-control input-sm" placeholder="请输入创建人名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="createDate" class="col-sm-3 control-label">创建日期：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
      		   <input id="createDate" name="createDate" type="text" class="form-control input-sm" placeholder="请输入创建日期"  ignore="ignore" />
                   <span class="input-group-addon" >
                       <span class="glyphicon glyphicon-calendar"></span>
                   </span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="xiangmudanwei" class="col-sm-3 control-label">项目单位名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<t:dictSelect field="xiangmudanwei" type="list" extendJson="{class:'form-control input-sm'}"   typeGroupCode=""  hasLabel="false"  title="项目单位名称"></t:dictSelect>     
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="xiangmu" class="col-sm-3 control-label">项目名称：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<input id="xiangmu" name="xiangmu" type="text" maxlength="128" class="form-control input-sm" placeholder="请输入项目名称"  ignore="ignore" />
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="jinri" class="col-sm-3 control-label">今日工作内容：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<textarea id="jinri" name="jinri" class="form-control" placeholder="请输入今日工作内容" rows="4"></textarea>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="jinrizongjie" class="col-sm-3 control-label">今日工作总结：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<textarea id="jinrizongjie" name="jinrizongjie" class="form-control" placeholder="请输入今日工作总结" rows="4"></textarea>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="tojihua" class="col-sm-3 control-label">明天工作计划：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<textarea id="tojihua" name="tojihua" class="form-control" placeholder="请输入明天工作计划" rows="4"></textarea>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="xvyao" class="col-sm-3 control-label">需要帮助和支持：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<textarea id="xvyao" name="xvyao" class="form-control" placeholder="请输入需要帮助和支持" rows="4"></textarea>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="beizhu" class="col-sm-3 control-label">备注：</label>
		<div class="col-sm-7">
			<div class="input-group" style="width:100%">
				<textarea id="beizhu" name="beizhu" class="form-control" placeholder="请输入备注" rows="4"></textarea>
			</div>
		</div>
	</div>
</form>
<script type="text/javascript">
	var subDlgIndex = '';
	$(document).ready(function() {
				//创建日期 日期控件初始化
			    laydate.render({
				   elem: '#createDate'
				  ,type: 'date'
				  ,trigger: 'click' //采用click弹出
				  ,ready: function(date){
				  	 $("#createDate").val(DateJsonFormat(date,this.format));
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