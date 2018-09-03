<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/context/mytags.jsp" %>

<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <%--<t:datagrid name="typeValueList" actionUrl="systemController.do?typeGrid&typegroupid=${typegroupid}" idField="id" queryMode="group">--%>
            <%--<t:dgCol title="common.code" field="id" hidden="true"></t:dgCol>--%>
            <%--<t:dgCol title="common.type.name" field="typename"></t:dgCol>--%>
            <%--<t:dgCol title="common.type.code" field="typecode"></t:dgCol>--%>
            <%--<t:dgCol title="common.operation" field="opt"></t:dgCol>--%>
            <%--<t:dgDelOpt url="systemController.do?delType&id={id}" title="common.delete" urlclass="ace_button"  urlfont="fa-trash-o"></t:dgDelOpt>--%>
            <%--<t:dgToolBar title="common.add.param" langArg="common.type" icon="icon-add" url="systemController.do?addorupdateType&typegroupid=${typegroupid}" funname="add"></t:dgToolBar>--%>
            <%--<t:dgToolBar title="common.edit.param" langArg="common.type" icon="icon-edit" url="systemController.do?addorupdateType&typegroupid=${typegroupid}" funname="update"></t:dgToolBar>--%>
        <%--</t:datagrid>--%>

        <t:datagrid name="tBBusinessList" checkbox="false" pagination="true" actionUrl="tBStatisCatalogController.do?typeGroupGrid&typegroupid=${typegroupid}" sortName="unitCode" idField="id" fit="true" queryMode="group" fitColumns="false" singleSelect="false" onLoadSuccess="mergeCells">
            <t:dgCol title="单位名称"  field="unitCode"  queryMode="single"  dictionary="unit_name"  width="200" align="center"></t:dgCol>
            <t:dgCol title="系统名称"  field="projectName"  queryMode="single"  width="200" align="center"></t:dgCol>
            <t:dgCol title="当年所选量"  field="sum"  queryMode="single"  width="100" align="center"></t:dgCol>
            <t:dgCol title="总计（万元）"  field="total"  queryMode="single"  width="100" align="center"></t:dgCol>
        </t:datagrid>
    </div>
</div>
<script>
    function addType(title,addurl,gname,width,height) {
        alert($("#id").val());
        add(title,addurl,gname,width,height);
    }

    function mergeCells(data) {
        var mark=1;
        for (var i=1; i <data.rows.length; i++) {
            if (data.rows[i]['unitCode'] == data.rows[i-1]['unitCode']) {
                mark += 1;
                $("#tBBusinessList").datagrid('mergeCells',{
                    index: i+1-mark,
                    field: 'unitCode',
                    rowspan:mark
                });
            }else{
                mark=1;
            }
        }
    }
</script>

