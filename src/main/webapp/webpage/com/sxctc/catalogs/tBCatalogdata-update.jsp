<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>服务目录管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <style type="text/css">
  	.combo_self{height: 22px !important;width: 150px !important;}
  	.layout-header .btn {
	    margin:0;
	   float: none !important;
	}
	.btn-default {
	    height: 35px;
	    line-height: 35px;
	    font-size:14px;
	}
  </style>
  
  <script type="text/javascript">
	$(function(){
		$(".combo").removeClass("combo").addClass("combo combo_self");
		$(".combo").each(function(){
			$(this).parent().css("line-height","0px");
		});   
	});
  		
  		 /**树形列表数据转换**/
  function convertTreeData(rows, textField) {
      for(var i = 0; i < rows.length; i++) {
          var row = rows[i];
          row.text = row[textField];
          if(row.children) {
          	row.state = "open";
              convertTreeData(row.children, textField);
          }
      }
  }
  /**树形列表加入子元素**/
  function joinTreeChildren(arr1, arr2) {
      for(var i = 0; i < arr1.length; i++) {
          var row1 = arr1[i];
          for(var j = 0; j < arr2.length; j++) {
              if(row1.id == arr2[j].id) {
                  var children = arr2[j].children;
                  if(children) {
                      row1.children = children;
                  }
                  
              }
          }
      }
  }
  </script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBCatalogdataController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBCatalogdataPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								类型:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="type" type="list"  datatype="*" typeGroupCode="catatype"   defaultVal="${tBCatalogdataPage.type}" hasLabel="false"  title="类型" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								父节点ID:
							</label>
						</td>
						<td class="value">
							<input id="fartherid" name="fartherid" type="text" style="width: 150px" class="inputxt easyui-combotree"  ignore="ignore"
								   value='${tBCatalogdataPage.fartherid}'
								   data-options="
											panelHeight:'220',
											url: 'tBCatalogdataController.do?datagrid&field=id,name',
											loadFilter: function(data) {
												var rows = data.rows || data;
												var win = frameElement.api.opener;
												var listRows = win.getDataGrid().treegrid('getData');
												joinTreeChildren(rows, listRows);
												convertTreeData(rows, 'parentText');
												return rows;
											},
											onSelect:function(node){
												$('#fartherid').val(node.id);
											},
											onLoadSuccess: function() {
												var win = frameElement.api.opener;
												var currRow = win.getDataGrid().treegrid('getSelected');
												if(!'${tBCatalogdataPage.id}') {
													//增加时，选择当前父菜单
													if(currRow) {
														$('#fartherid').combotree('setValue', currRow.id);
													}
												}else {
													//编辑时，选择当前父菜单
													if(currRow) {
														$('#fartherid').combotree('setValue', currRow.parentId);
													}
												}
											}
									"
							>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">父节点ID</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBCatalogdataPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位:
							</label>
						</td>
						<td class="value">
						    <input id="danwei" name="danwei" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBCatalogdataPage.danwei}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单价:
							</label>
						</td>
						<td class="value">
							<input id="price" name="price" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBCatalogdataPage.price}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单价</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								是否有效:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="status" type="radio"  datatype="*" typeGroupCode="dev_flag"  defaultVal="${tBCatalogdataPage.status}" hasLabel="false"  title="是否有效" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">是否有效</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="beizhu" name="beizhu" type="text" maxlength="64" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBCatalogdataPage.beizhu}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
