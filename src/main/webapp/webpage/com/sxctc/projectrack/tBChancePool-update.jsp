<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>项目机会池</title>
	<t:base type="jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript">
        //编写自定义JS代码
	</script>
</head>
<body>
<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBChancePoolController.do?doUpdate" callback="updateCallback">
	<input id="id" name="id" type="hidden" value="${tBChancePoolPage.id }"/>
	<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right" style="width: 30%">
				<label class="Validform_label">
					单位名称:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="unitCode" type="list"  datatype="n"  typeGroupCode="unit_name"   defaultVal="${tBChancePoolPage.unitCode}" hasLabel="false"  title="单位名称" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单位名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					项目名称:
				</label>
			</td>
			<td class="value">
				<input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.projectName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					项目预算(万元):
				</label>
			</td>
			<td class="value">
				<input id="projectBudget" name="projectBudget" type="text" maxlength="32" style="width: 150px" class="inputxt" datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore"  value='${tBChancePoolPage.projectBudget}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">项目预算(万元)</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					软件和服务(万元):
				</label>
			</td>
			<td class="value">
				<input id="projectServer" name="projectServer" type="text" maxlength="32" style="width: 150px" class="inputxt" datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore"  value='${tBChancePoolPage.projectServer}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">软件和服务(万元)</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					硬件(万元):
				</label>
			</td>
			<td class="value">
				<input id="projectHardware" name="projectHardware" type="text" maxlength="32" style="width: 150px" class="inputxt" datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore"  value='${tBChancePoolPage.projectHardware}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">硬件(万元)</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					主要合作公司:
				</label>
			</td>
			<td class="value">
				<input id="businessParters" name="businessParters" type="text" maxlength="32" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.businessParters}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">主要合作公司</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					竞争对手:
				</label>
			</td>
			<td class="value">
				<input id="businessCompetitor" name="businessCompetitor" type="text" maxlength="200" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.businessCompetitor}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">竞争对手</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					预计招标时间:
				</label>
			</td>
			<td class="value">
				<input id="predictTenderTime" name="predictTenderTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" datatype="*" ignore="ignore" value='<fmt:formatDate value='${tBChancePoolPage.predictTenderTime}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">预计招标时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					资金来源:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="fundsProvided" type="radio"  datatype="*"  typeGroupCode="provide"   defaultVal="${tBChancePoolPage.fundsProvided}" hasLabel="false"  title="资金来源" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">资金来源</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					上层关系:
				</label>
			</td>
			<td class="value">
				<input id="topRelation" name="topRelation" type="text" maxlength="500" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.topRelation}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">上层关系</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					中层关系:
				</label>
			</td>
			<td class="value">
				<input id="midRelation" name="midRelation" type="text" maxlength="500" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.midRelation}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">中层关系</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					下层关系:
				</label>
			</td>
			<td class="value">
				<input id="bottomRelation" name="bottomRelation" type="text" maxlength="500" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.bottomRelation}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">下层关系</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					当年把控度:
				</label>
			</td>
			<td class="value">
					<%--<input id="controlDegree" name="controlDegree" type="text" maxlength="32" style="width: 150px" class="inputxt" datatype="*" ignore="ignore"  value='${tBChancePoolPage.controlDegree}'/>--%>
				<t:dictSelect id="controlDegree" field="controlDegree" type="list"  datatype="n"  typeGroupCode="control"   defaultVal="${tBChancePoolPage.controlDegree}" hasLabel="false"  title="当年把控度" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">当年把控度</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					现状及下一步计划:
				</label>
			</td>
			<td class="value">
				<textarea id="projectPlan" style="width:50%;height: 100px;" class="inputxt" rows="6" name="projectPlan"  ignore="ignore" >${tBChancePoolPage.projectPlan}</textarea>
				<button id="projectPlanBtn" class="btn btn-success" type="button" onclick="checkHistory('${tBChancePoolPage.id}')" style="border-radius: 5px"><span><i class="fa fa-search"></i>查询历史</span></button>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">现状及下一步计划</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					备注:
				</label>
			</td>
			<td class="value">
				<input id="remark" name="remark" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBChancePoolPage.remark}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">
					是否中标:
				</label>
			</td>
			<td class="value">
				<t:dictSelect field="winningResult" type="radio"  datatype="*"  typeGroupCode="dev_flag"   defaultVal="${tBChancePoolPage.winningResult}" hasLabel="false"  title="是否中标" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否中标</label>
			</td>
		</tr>

	</table>
</t:formvalid>
</body>
<script src = "webpage/com/sxctc/projectrack/tBChancePool.js"></script>
<script type="text/javascript">
    $(function () {
        $("#projectPlanBtn").removeAttr("disabled");
    })
    function checkHistory(id) {
        var url = "tBChancePoolController.do?goHistoryPlan&id="+id;
        $.dialog({
            content: "url:" + url,
            lock : true,
            title:'历史计划',
            zIndex: getzIndex(),
            opacity : 0.3,
            width:400,
            height:300,
            cache:false
        });
    }

    function updateCallback() {


    }
</script>