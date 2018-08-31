<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>毛利润指标</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="tBProfitTargetController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${tBProfitTargetPage.id }"/>
		<table style="width: 100%;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right" style="width: 30%">
							<label class="Validform_label">
								单位名称:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="unitCode" type="list"  datatype="n"  typeGroupCode="unit_name"   defaultVal="${tBProfitTargetPage.unitCode}" hasLabel="false"  title="单位名称" readonly="readonly"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目名称:
							</label>
						</td>
						<td class="value">
						    <input id="projectName" name="projectName" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBProfitTargetPage.projectName}' readonly="readonly"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目令号:
							</label>
						</td>
						<td class="value">
						    <input id="projectOrder" name="projectOrder" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBProfitTargetPage.projectOrder}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目令号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目经理:
							</label>
						</td>
						<td class="value">
						    <input id="projectManage" name="projectManage" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBProfitTargetPage.projectManage}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目经理</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								合同签订时间:
							</label>
						</td>
						<td class="value">
									  <input id="signTime" name="signTime" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore" value='<fmt:formatDate value='${tBProfitTargetPage.signTime}' type="date" pattern="yyyy-MM-dd"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同签订时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								合同额(万元):
							</label>
						</td>
						<td class="value">
						    <input id="contractValue" name="contractValue" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore"  value='${tBProfitTargetPage.contractValue}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同额(万元)</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								毛利率:
							</label>
						</td>
						<td class="value">
						    <input id="profitTargetRatio" name="profitTargetRatio" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore"  value='${tBProfitTargetPage.profitTargetRatio}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毛利率</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								毛利润(万元):
							</label>
						</td>
						<td class="value">
						    <input id="profitTarget" name="profitTarget" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore" readonly="readonly" value='${tBProfitTargetPage.profitTarget}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">毛利润(万元)</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								确认收入额(万元):
							</label>
						</td>
						<td class="value">
						    <input id="confirmIncome" name="confirmIncome" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore"  value='${tBProfitTargetPage.confirmIncome}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">确认收入额(万元)</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								确认收入比例:
							</label>
						</td>
						<td class="value">
						    <input id="confirmIncomeRatio" name="confirmIncomeRatio" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value='${tBProfitTargetPage.confirmIncomeRatio}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">确认收入比例</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								回款总额(万元):
							</label>
						</td>
						<td class="value">
						    <input id="receivedPay" name="receivedPay" type="text" maxlength="32" style="width: 150px" class="inputxt"  datatype="/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/,*0-7" ignore="ignore"  value='${tBProfitTargetPage.receivedPay}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回款总额(万元)</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								回款比例:
							</label>
						</td>
						<td class="value">
						    <input id="receivedPayRatio" name="receivedPayRatio" type="text" maxlength="32" style="width: 150px" class="inputxt"  ignore="ignore" readonly="readonly" value='${tBProfitTargetPage.receivedPayRatio}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">回款比例</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								项目实施状态:
							</label>
						</td>
						<td class="value">
							<t:dictSelect field="projectStatus" type="list"  datatype="n"  typeGroupCode="proj_stat"   defaultVal="${tBProfitTargetPage.projectStatus}" hasLabel="false"  title="项目实施状态"></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">项目实施状态</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
 <script src = "webpage/com/sxctc/profit/tBProfitTarget.js"></script>
 <script type="text/javascript">
     $("#profitTargetRatio").blur(function(){
         var contractValue = $("#contractValue").val();
         var radio = $("#profitTargetRatio").val();
         if (radio == null) {
             radio = 0.00;
             $("#profitTargetRatio").val("0%");
			 $("#profitTarget").val(0);
			 return;
		 }

         var oldRadio = $("#profitTargetRatio").val();
		 if (oldRadio !=null && oldRadio.substr(oldRadio.length-1,1) == "%") {
		     return;
		 }
         $("#profitTargetRatio").val(radio + "%");

         if (contractValue != null) {
             var num = (contractValue * radio)/100;
             //alert(num.toFixed(2));
             $("#profitTarget").val(num.toFixed(2));
		 }



     });

     $("#confirmIncome").blur(function(){
         var contractValue = $("#contractValue").val();
         var confirmIncome = $("#confirmIncome").val();
         if (confirmIncome != null && contractValue != null && contractValue != 0) {
             var num = (confirmIncome/contractValue)*100;
             $("#confirmIncomeRatio").val(num.toFixed(2) + "%");
         }
     });

     $("#receivedPay").blur(function(){
         var receivedPay = $("#receivedPay").val();
         var confirmIncome = $("#confirmIncome").val();
         if (receivedPay != null && confirmIncome != null && confirmIncome != 0) {
             var num = (receivedPay/confirmIncome)*100;
             $("#receivedPayRatio").val(num.toFixed(2) + "%");
         }
     });
 </script>
