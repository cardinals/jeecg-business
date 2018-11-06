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
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBTodoListController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBTodoListPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								代办内容:
							</label>
						</td>
						<td class="value">
						    <input id="todoContent" name="todoContent" type="text" maxlength="0" style="width: 150px" class="inputxt"  validType="t_b_todo_list,todo_content,id" datatype="*" ignore="ignore"  value='${tBTodoListPage.todoContent}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代办内容</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								代办状态:
							</label>
						</td>
						<td class="value">
						    <input id="todoStatus" name="todoStatus" type="text" maxlength="4" style="width: 150px" class="inputxt"  validType="t_b_todo_list,todo_status,id" datatype="*" ignore="ignore"  value='${tBTodoListPage.todoStatus}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">代办状态</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sxctc/todolist/tBTodoList.js"></script>		
