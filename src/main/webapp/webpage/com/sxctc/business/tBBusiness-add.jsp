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
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusinessController.do?doAdd" >
	<input id="id" name="id" type="hidden" value="${tBBusinessPage.id }"/>
	<input id="unitName" name="unitName" type="hidden" value="${tBBusinessPage.unitName }"/>
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">
					厅局名称:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="unitCode" type="list"  datatype="*" typeGroupCode="unit_name"  defaultVal="${tBBusinessPage.unitCode}" hasLabel="false"  title="厅局编号" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">厅局名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					迁移系统名称:
				</label>
			</td>
			<td class="value">
				<input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">迁移系统名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					系统类型:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="projectStatus" type="radio"  datatype="*" typeGroupCode="proj_type"  defaultVal="${tBBusinessPage.projectStatus}" hasLabel="false"  title="系统类型" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">系统类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					是否上云:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="cloudStatus" type="radio"  datatype="*" typeGroupCode="dev_flag"  defaultVal="1" hasLabel="false"  title="是否上云" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否上云</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					是否有机会:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="chanceStatus" type="radio"  datatype="*" typeGroupCode="dev_flag"  defaultVal="${tBBusinessPage.chanceStatus}" hasLabel="false"  title="是否有机会" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否有机会</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					对接状态:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="joinStatus" type="radio"  datatype="*" typeGroupCode="joinStatus"  defaultVal="${tBBusinessPage.joinStatus}" hasLabel="false"  title="对接状态" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">对接状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					业务创建时间:
				</label>
			</td>
			<td class="value">
				<input id="busCreateTime" name="busCreateTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()"  datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">业务创建时间</label>
			</td>
		</tr>
		<tr class="hid">
			<td align="right">
				<label class="Validform_label">
					业务对接时间:
				</label>
			</td>
			<td class="value">
				<input id="busJoinTime" name="busJoinTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" datatype="*" ignore="ignore" />
				<span class="Validform_checktip hid"></span>
				<label class="Validform_label" style="display: none;">业务对接时间</label>
			</td>
		</tr>
		<tr class="hid">
			<td align="right">
				<label class="Validform_label">
					是否收回协议:
				</label>
			</td>
			<td class="value">
				<t:dictSelect id="protocolStatus" field="protocolStatus" type="radio"  typeGroupCode="dev_flag"  defaultVal="${tBBusinessPage.protocolStatus}" hasLabel="false"  title="是否收回协议" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否收回协议</label>
			</td>
		</tr>
		<tr class="hid" id="protocolTimeTr">
			<td align="right">
				<label class="Validform_label">
					收回协议时间:
				</label>
			</td>
			<td class="value">
				<input id="protocolTime" name="protocolTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker()" datatype="*" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收回协议时间</label>
			</td>
		</tr>


	</table>
</t:formvalid>
</body>
<script src = "webpage/com/sxctc/business/tBBusiness.js"></script>
<script>
    $('input:radio[name="projectStatus"]').click(function(){
        if($(this).val()==1){
            $("input:radio[name='chanceStatus'][value=1]").attr("checked",true);
        }else {
            $("input:radio[name='chanceStatus'][value=0]").attr("checked",true);
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

    $('input:radio[name="protocolStatus"]').click(function(){
        if($(this).val()==0){
            $("#protocolTimeTr").hide();
            $("#protocolTime").attr("ignore","ignore");
        }else {
            $("#protocolTimeTr").show();
            $("#protocolTime").attr("ignore","checked");
        }
    });

    $('#unitCode').change(function(){
        $("#unitName").val($('#unitCode option:selected').text());
    });

</script>
