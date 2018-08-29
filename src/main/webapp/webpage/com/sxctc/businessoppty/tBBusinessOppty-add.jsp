<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>商机评估</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBBusinessOpptyController.do?doAdd" beforeSubmit="beforeTijiao" refresh="true">
					<input id="id" name="id" type="hidden" value="${tBBusinessOpptyPage.id }"/>
					<input id="evaluateWin" name="evaluateWin" type="hidden"/>
					<input id="evaluateFirst" name="evaluateFirst" type="hidden"/>
					<input id="evaluateConfirm" name="evaluateConfirm" type="hidden"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							评估值-1win:
						</label>
					</td>
					<td class="value">
						<t:dictSelect id="1win" field="1win" type="checkbox" typeGroupCode="1win" hasLabel="false" title="1Win"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评估值-1win</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评估值-3first:
						</label>
					</td>
					<td class="value">
						<t:dictSelect id="3first" field="3first" type="checkbox" typeGroupCode="3first" hasLabel="false" title="1Win"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评估值-3first</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							评估值-9confirm:
						</label>
					</td>
					<td class="value">
						<t:dictSelect id="9confirm" field="9confirm" type="checkbox" typeGroupCode="9confirm" hasLabel="false" title="1Win"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">评估值-9confirm</label>
						</td>
				</tr>
				<%--<tr>
					<td align="right">
						<label class="Validform_label">
							项目名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="projectName" name="projectName" type="text" maxlength="50" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
				</tr>--%>

			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/businessoppty/tBBusinessOppty.js"></script>
 <script type="text/javascript">
	 function beforeTijiao() {
		 var sumWin = $("input[name='1win']:checked").length;
		 var sumFirst = $("input[name='3first']:checked").length;
		 var sumConfirm = $("input[name='9confirm']:checked").length;

		 $("#evaluateWin").val(sumWin);
		 $("#evaluateFirst").val(sumFirst);
		 $("#evaluateConfirm").val(sumConfirm);

     }
 </script>
