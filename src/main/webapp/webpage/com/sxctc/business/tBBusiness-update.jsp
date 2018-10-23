<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>营销数据业务列表</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript">
        //编写自定义JS代码
	</script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusinessController.do?doUpdate" >
	<input id="id" name="id" type="hidden" value="${tBBusinessPage.id }"/>
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">
					单位名称:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="unitCode" type="list"  datatype="*" typeGroupCode="unit_name"   defaultVal="${tBBusinessPage.unitCode}" hasLabel="false"  title="厅局编号" readonly="readonly"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">厅局名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					系统名称:
				</label>
			</td>
			<td class="value">
				<input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*" ignore="checked"  value='${tBBusinessPage.projectName}' readonly="readonly"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">迁移系统名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					资金来源:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="fundsProvided" type="radio"  datatype="*" typeGroupCode="provide"  defaultVal="${tBBusinessPage.fundsProvided}" hasLabel="false"  title="是否有机会"  readonly="readonly"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">资金来源</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					是否审计系统:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="auditStatus" type="radio"  datatype="*" typeGroupCode="dev_flag" defaultVal="${tBBusinessPage.auditStatus}" hasLabel="false"  title="是否有机会"  readonly="readonly"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否审计系统</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					系统状态:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="projectStatus" type="radio"  datatype="*" typeGroupCode="proj_type"   defaultVal="${tBBusinessPage.projectStatus}" hasLabel="false"  title="系统类型" readonly="readonly"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">系统类型</label>
			</td>
		</tr>
		<tr>
			<td align="right" style="background-color: yellow">
				<label class="Validform_label">
					是否跟踪:
				</label>
			</td>
			<td class="value" style="background-color: yellow">
				<t:dictSelect field="chanceStatus" type="radio"  datatype="*" typeGroupCode="dev_flag"   defaultVal="${tBBusinessPage.chanceStatus}" hasLabel="false"  title="是否有机会" readonly="readonly"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否跟踪</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					上云工作状态:
				</label>
			</td>
			<td class="value">
				<t:dictSelect id="joinStatus" field="joinStatus" type="list"  datatype="*" typeGroupCode="joinStatus"   defaultVal="${tBBusinessPage.joinStatus}" hasLabel="false"  title="对接状态" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">上云工作状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					业务创建时间:
				</label>
			</td>
			<td class="value">
				<input id="busCreateTime" name="busCreateTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  datatype="*" ignore="checked" value='<fmt:formatDate value='${tBBusinessPage.busCreateTime}' type="date" pattern="yyyy-MM-dd"/>' disabled="disabled"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">业务创建时间</label>
			</td>
		</tr>
		<tr class="hid1">
			<td align="right">
				<label class="Validform_label">
					首次对接时间:
				</label>
			</td>
			<td class="value">
				<input id="busJoinTime" name="busJoinTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_scdj()" datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.busJoinTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">首次对接时间</label>
			</td>
		</tr>
		<tr class="hid2">
			<td align="right">
				<label class="Validform_label">
					取得现状调研表/资源需求表时间:
				</label>
			</td>
			<td class="value">
				<input id="demandTime" name="demandTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_qdxz()" datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.demandTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">取得现状调研表/资源需求表时间</label>
			</td>
		</tr>
		<tr class="hid3">
			<td align="right">
				<label class="Validform_label">
					签订方案时间:
				</label>
			</td>
			<td class="value">
				<input id="planTime" name="planTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_qdfa()" datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.planTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签订方案时间</label>
			</td>
		</tr>
		<tr class="hid4">
			<td align="right">
				<label class="Validform_label">
					分配资源时间:
				</label>
			</td>
			<td class="value">
				<input id="resourceTime" name="resourceTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_fpzy()" datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.resourceTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">分配资源时间</label>
			</td>
		</tr>
		<tr class="hid5">
			<td align="right">
				<label class="Validform_label">
					上云测试时间:
				</label>
			</td>
			<td class="value">
				<input id="testTime" name="testTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_sycs()" datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.testTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">上云测试时间</label>
			</td>
		</tr>
		<tr class="hid6" id="protocolTimeTr">
			<td align="right">
				<label class="Validform_label">
					收回协议时间:
				</label>
			</td>
			<td class="value">
				<input id="protocolTime" name="protocolTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_shxy()" datatype="*" ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.protocolTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收回协议时间</label>
			</td>
		</tr>
		<tr class="hid7">
			<td align="right">
				<label class="Validform_label">
					上云完成时间:
				</label>
			</td>
			<td class="value">
				<input id="finishTime" name="finishTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" onchange="yanZheng_sywc()" datatype="*"  ignore="ignore" value='<fmt:formatDate value='${tBBusinessPage.finishTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">上云完成时间</label>
			</td>
		</tr>
	</table>
</t:formvalid>
</body>
<script src = "webpage/com/sxctc/business/tBBusiness.js"></script>
<script>
	var global;
	$(function () {
        //var joinStat = $('input:radio[name="joinStatus"]').val();
		var joinStat = ${tBBusinessPage.joinStatus};
        global = joinStat;
        //var protocolStatus = ${tBBusinessPage.protocolStatus};
        // 业务对接时间下面选项显隐
        if(joinStat==0){
            //$("#busJoinTime").attr("ignore","ignore");
            //$("#protocolStatus").removeAttr("datatype");
            $(".hid1").hide();
            $(".hid2").hide();
            $(".hid3").hide();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","ignore");
            $("#demandTime").attr("ignore","ignore");
            $("#planTime").attr("ignore","ignore");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==1) {
            $(".hid1").show();
            $(".hid2").hide();
            $(".hid3").hide();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","ignore");
            $("#planTime").attr("ignore","ignore");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==2) {
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").hide();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked").attr("disabled","disabled");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","ignore");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==3) {
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked").attr("disabled","disabled");
            $("#demandTime").attr("ignore","checked").attr("disabled","disabled");
            $("#planTime").attr("ignore","checked");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==4) {
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked").attr("disabled","disabled");
            $("#demandTime").attr("ignore","checked").attr("disabled","disabled");
            $("#planTime").attr("ignore","checked").attr("disabled","disabled");
            $("#resourceTime").attr("ignore","checked");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==5) {
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").show();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked").attr("disabled","disabled");
            $("#demandTime").attr("ignore","checked").attr("disabled","disabled");
            $("#planTime").attr("ignore","checked").attr("disabled","disabled");
            $("#resourceTime").attr("ignore","checked").attr("disabled","disabled");
            $("#testTime").attr("ignore","checked");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==6) {
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").show();
            $(".hid6").show();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked").attr("disabled","disabled");
            $("#demandTime").attr("ignore","checked").attr("disabled","disabled");
            $("#planTime").attr("ignore","checked").attr("disabled","disabled");
            $("#resourceTime").attr("ignore","checked").attr("disabled","disabled");
            $("#testTime").attr("ignore","checked").attr("disabled","disabled");
            $("#protocolTime").attr("ignore","checked");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStat==7) {
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").show();
            $(".hid6").show();
            $(".hid7").show();
            $("#busJoinTime").attr("ignore","checked").attr("disabled","disabled");
            $("#demandTime").attr("ignore","checked").attr("disabled","disabled");
            $("#planTime").attr("ignore","checked").attr("disabled","disabled");
            $("#resourceTime").attr("ignore","checked").attr("disabled","disabled");
            $("#testTime").attr("ignore","checked").attr("disabled","disabled");
            $("#protocolTime").attr("ignore","checked").attr("disabled","disabled");
            $("#finishTime").attr("ignore","checked");
        }

    });

    $('#joinStatus').change(function(){
        var joinStatusVal = $(this).val();
        if (global > joinStatusVal) {
            tip("该流程已完成");
            $('#joinStatus').val(global);
            return;
		}
        if(joinStatusVal==0){
            //$("#busJoinTime").attr("ignore","ignore");
            //$("#protocolStatus").removeAttr("datatype");
            $(".hid1").hide();
            $(".hid2").hide();
            $(".hid3").hide();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","ignore");
            $("#demandTime").attr("ignore","ignore");
            $("#planTime").attr("ignore","ignore");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==1) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").hide();
            $(".hid3").hide();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","ignore");
            $("#planTime").attr("ignore","ignore");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==2) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").hide();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","ignore");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==3) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").hide();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","checked");
            $("#resourceTime").attr("ignore","ignore");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==4) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").hide();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","checked");
            $("#resourceTime").attr("ignore","checked");
            $("#testTime").attr("ignore","ignore");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==5) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").show();
            $(".hid6").hide();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","checked");
            $("#resourceTime").attr("ignore","checked");
            $("#testTime").attr("ignore","checked");
            $("#protocolTime").attr("ignore","ignore");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==6) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").show();
            $(".hid6").show();
            $(".hid7").hide();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","checked");
            $("#resourceTime").attr("ignore","checked");
            $("#testTime").attr("ignore","checked");
            $("#protocolTime").attr("ignore","checked");
            $("#finishTime").attr("ignore","ignore");
        }else if (joinStatusVal==7) {
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
            $(".hid1").show();
            $(".hid2").show();
            $(".hid3").show();
            $(".hid4").show();
            $(".hid5").show();
            $(".hid6").show();
            $(".hid7").show();
            $("#busJoinTime").attr("ignore","checked");
            $("#demandTime").attr("ignore","checked");
            $("#planTime").attr("ignore","checked");
            $("#resourceTime").attr("ignore","checked");
            $("#testTime").attr("ignore","checked");
            $("#protocolTime").attr("ignore","checked");
            $("#finishTime").attr("ignore","checked");
        }
    });

    $('input:radio[name="joinStatus"]').click(function(){
        if($(this).val()==0){
            $(".hid").hide();
            $("#busJoinTime").attr("ignore","ignore");
        }else {
            $(".hid").show();
            $("#busJoinTime").attr("ignore","checked");
            $("#protocolStatus").attr("datatype","n");
        }
    });


    $('#unitCode').change(function(){
        $("#unitName").val($('#unitCode option:selected').text());
    });

    function yanZheng_scdj(){
        var busCreateTime = $("#busCreateTime").val();
        var busJoinTime = $("#busJoinTime").val();
        var date_busCreateTime = new Date(busCreateTime);
        var date_busJoinTime = new Date(busJoinTime);
        if (date_busCreateTime.getTime() > date_busJoinTime.getTime()){
            tip("首次对接时间小于业务创建时间！");
            $("#busJoinTime").val("");
        }
        if(busCreateTime == ""){
            tip("业务创建时间不能为空！");
            $("#busJoinTime").val("");
        }
    }
    function yanZheng_qdxz(){
        var busJoinTime = $("#busJoinTime").val();
        var demandTime = $("#demandTime").val();
        var date_busJoinTime = new Date(busJoinTime);
        var date_demandTime = new Date(demandTime);
        if (date_busJoinTime.getTime() > date_demandTime.getTime()){
            tip("取得现状调研表时间小于首次对接时间！");
            $("#demandTime").val("");
        }
        if(busJoinTime == ""){
            tip("首次对接时间不能为空！");
            $("#demandTime").val("");
        }
    }
    function yanZheng_qdfa(){
        var demandTime = $("#demandTime").val();
        var planTime = $("#planTime").val();
        var date_demandTime = new Date(demandTime);
        var date_planTime = new Date(planTime);
        if (date_demandTime.getTime() > date_planTime.getTime()){
            tip("签订方案时间小于取得现状调研表时间！");
            $("#planTime").val("");
        }
        if(demandTime == ""){
            tip("取得现状调研表时间不能为空!");
            $("#planTime").val("");
        }
    }
    function yanZheng_fpzy(){
        var planTime = $("#planTime").val();
        var resourceTime = $("#resourceTime").val();
        var date_planTime = new Date(planTime);
        var date_resourceTime = new Date(resourceTime);
        if (date_planTime.getTime() > date_resourceTime.getTime()){
            tip("分配资源时间小于签订方案时间！");
            $("#resourceTime").val("");
        }
        if(planTime == ""){
            tip("签订方案时间不能为空!");
            $("#resourceTime").val("");
        }
    }
    function yanZheng_sycs(){
        var resourceTime = $("#resourceTime").val();
        var testTime = $("#testTime").val();
        var date_resourceTime = new Date(resourceTime);
        var date_testTime = new Date(testTime);
        if (date_resourceTime.getTime() > date_testTime.getTime()){
            tip("上云测试时间小于分配资源时间！");
            $("#testTime").val("");
        }
        if(resourceTime == ""){
            tip("分配资源时间不能为空!");
            $("#testTime").val("");
        }
    }
    function yanZheng_shxy(){
        var testTime = $("#testTime").val();
        var protocolTime = $("#protocolTime").val();
        var date_testTime = new Date(testTime);
        var date_protocolTime = new Date(protocolTime);
        if (date_testTime.getTime() > date_protocolTime.getTime()){
            tip("收回协议时间小于上云测试时间！");
            $("#protocolTime").val("");
        }
        if(testTime == ""){
            tip("上云测试时间不能为空!");
            $("#protocolTime").val("");
        }
    }
    function yanZheng_sywc(){
        var protocolTime = $("#protocolTime").val();
        var finishTime = $("#finishTime").val();
        var date_protocolTime = new Date(protocolTime);
        var date_finishTime = new Date(finishTime);
        if (date_protocolTime.getTime() > date_finishTime.getTime()){
            tip("上云完成时间小于收回协议时间！");
            $("#finishTime").val("");
        }
        if(protocolTime == ""){
            tip("收回协议时间不能为空!");
            $("#finishTime").val("");
        }
    }

</script>