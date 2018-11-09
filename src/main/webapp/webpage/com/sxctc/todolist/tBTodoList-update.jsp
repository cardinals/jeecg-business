<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>待办事项</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBTodoListController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBTodoListPage.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right" style="width: 20%">
							<label class="Validform_label">
								待办内容:
							</label>
						</td>
						<td class="value">
							<textarea id="todoContent" style="width:90%;height: 100px;" class="inputxt" rows="6" name="todoContent"  ignore="checked" >${tBTodoListPage.todoContent}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">待办内容</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/todolist/tBTodoList.js"></script>		
