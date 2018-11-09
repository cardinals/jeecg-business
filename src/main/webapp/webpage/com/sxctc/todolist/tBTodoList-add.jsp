<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>代办事项</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBTodoListController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${tBTodoListPage.id }"/>
					<input id="todoStatus" name="todoStatus" type="hidden" value="0"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" style="width: 20%">
						<label class="Validform_label">
							代办内容:
						</label>
					</td>
					<td class="value">
							<textarea id="todoContent" style="width:90%;height: 100px;" class="inputxt" rows="6" name="todoContent"  ignore="checked" ></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代办内容</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/todolist/tBTodoList.js"></script>		
