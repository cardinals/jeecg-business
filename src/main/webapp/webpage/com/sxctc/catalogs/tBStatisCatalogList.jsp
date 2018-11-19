<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<style>
    div.datagrid-cell{
        height:auto;
    }
</style>
<div id="main_typegroup_list" class="easyui-layout" fit="true">  
    <div region="center" style="padding:0px;border:0px">
        <%--<t:datagrid name="tBCatalogdataList" title="厅局信息管理" actionUrl="systemController.do?typeGroupGrid&typegroupcode=unit_name"
        idField="id" treegrid="false" pagination="false"  sortOrder="desc" sortName="createDate" onLoadSuccess="loadSuccess" queryMode="group" btnCls="bootstrap btn btn-info btn-xs">
            <t:dgCol title="common.code" field="id" hidden="true"></t:dgCol>
            <t:dgCol title="厅局名称" field="typegroupname" width="100" query="true"></t:dgCol>
            <t:dgCol title="dict.code" field="typegroupcode" width="100" treefield="code" query="true"></t:dgCol>
            <t:dgCol title="common.operation" field="opt" width="100"></t:dgCol>
            &lt;%&ndash;<t:dgDelOpt url="systemController.do?delTypeGroup&id={id}" title="common.delete" urlclass="ace_button" urlStyle="background-color:#ec4758;" urlfont="fa-trash-o"></t:dgDelOpt>&ndash;%&gt;
            <t:dgFunOpt funname="queryTypeValue(id,typegroupname)" title="管理" urlclass="ace_button"  urlfont="fa-search"></t:dgFunOpt>
            &lt;%&ndash;<t:dgToolBar title="common.add.param" langArg="lang.dictionary.type" icon="fa fa-plus" url="systemController.do?aouTypeGroup" funname="add"></t:dgToolBar>
            &lt;%&ndash;<t:dgToolBar title="common.add.param" langArg="lang.dictionary.value" icon="icon-add" funname="tBCatalogdataList_AddType"></t:dgToolBar>&ndash;%&gt;
            <t:dgToolBar title="common.edit" icon="fa fa-edit" url="systemController.do?aouTypeGroup" funname="update"></t:dgToolBar>
            <t:dgToolBar title="common.refreshType" icon="fa fa-refresh" url="systemController.do?refreshTypeGroupAndTypes" funname="doSubmit"></t:dgToolBar>&ndash;%&gt;
        </t:datagrid>--%>

        <%--<t:datagrid name="tBCatalogdataList" title="服务目录统计" actionUrl="tBStatisCatalogController.do?datagrid&catalogtype=${type}" idField="id" treegrid="true" pagination="false" onLoadSuccess="loadSuccess" queryMode="group" btnCls="bootstrap btn btn-info btn-xs">--%>
        <%--<t:datagrid name="tBCatalogdataList" checkbox="false" pagination="true" treegrid="true" treeField="name" fitColumns="false" title="服务目录统计" actionUrl="tBStatisCatalogController.do?datagrid&catalogtype=${type}"  idField="id" fit="true" queryMode="group" onLoadSuccess="loadSuccess" rowStyler="mystyle">
            <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="名称"  field="name" queryMode="single"  width="500"></t:dgCol>
            <t:dgCol title="单位"  field="danwei"  queryMode="single"  width="100"></t:dgCol>
            <t:dgCol title="父节点ID"  field="fartherid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="数量"  field="num"  hidden="true"  queryMode="single"  width="50"></t:dgCol>
            <t:dgCol title="类型"  field="type" hidden="true" queryMode="single"  dictionary="catatype"  width="120"></t:dgCol>
            <t:dgCol title="单价"  field="price" queryMode="single"  width="60"></t:dgCol>
            <t:dgCol title="合计（万元）"  field="total" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="备注"  field="beizhu"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
            <t:dgFunOpt funname="queryTypeValue(id,typegroupname)" title="查看使用详情" urlclass="ace_button"  urlfont="fa-search" exp="danwei#ne#"></t:dgFunOpt>
        </t:datagrid>--%>
        <t:datagrid name="tBCatalogdataList" checkbox="true" pagination="true" treegrid="true" fitColumns="true" title="服务目录统计" actionUrl="tBStatisCatalogController.do?datagrid&catalogtype=${type}"  idField="id" fit="true" queryMode="group">
            <t:dgCol title="主键"  field="id"  hidden="true" treefield="id" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="名称"  field="name" treefield="text" queryMode="single"  width="260"></t:dgCol>
            <t:dgCol title="单位"  field="danwei" treefield="fieldMap.danwei" queryMode="single"  width="50"></t:dgCol>
            <t:dgCol title="父节点ID"  field="fartherid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="数量"  field="num"  hidden="true" treefield="fieldMap.num" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="类型"  field="type" hidden="true" treefield="fieldMap.type" queryMode="single"  dictionary="catatype"  width="120"></t:dgCol>
            <t:dgCol title="单价"  field="price" queryMode="single" treefield="fieldMap.price"  width="50"></t:dgCol>
            <t:dgCol title="合计（万元）"  field="total" treefield="fieldMap.total" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="备注"  field="beizhu"  queryMode="single" treefield="fieldMap.beizhu" width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
            <t:dgFunOpt funname="queryTypeValue(id,typegroupname)" title="查看使用详情" urlclass="ace_button"  urlfont="fa-search" exp="danwei#ne#"></t:dgFunOpt>
        </t:datagrid>
    </div>
</div>

<div id="dataOptId" data-options="region:'east',
	title:'使用详情',
	collapsed:true,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
     style="width: 650px; overflow: hidden;" id="eastPanel">
    <div class="easyui-panel" style="padding:0px;border:0px;" fit="true" border="false" id="userListpanel"></div>
</div>

<script type="text/javascript">
    $(function() {
        var li_east = 0;

        $("#tBCatalogdataList").treegrid({
            onExpand : function(row){
                $("#tBCatalogdataList").treegrid("expandAll",row.id);
                // var children = $("#tBCatalogdataList").treegrid('getChildren',row.id);
                //  if(children.length<=0){
                //  	row.leaf=true;
                //  	$("#tBCatalogdataList").treegrid('refresh', row.id);
                //  }
            },
            onLoadSuccess: function () {
                $("#tBCatalogdataList").treegrid("expandAll");
            }
        });
    });

    function mystyle() {
        return "height:31px";
    }
    function queryTypeValue(typegroupid, typegroupname){
        <%--var title = '<t:mutiLang langKey="lang.dictionary.type"/>: ' + typegroupname;--%>
        var title = '使用详情';
        if(li_east == 0){
            $('#main_typegroup_list').layout('expand','east');
        }
        $('#main_typegroup_list').layout('panel','east').panel('setTitle', title);
        $('#userListpanel').panel("refresh", "tBStatisCatalogController.do?goTypeGrid&typegroupid=" + typegroupid);
    }
    function loadSuccess() {
        $('#main_typegroup_list').layout('panel','east').panel('setTitle', "");
        $('#main_typegroup_list').layout('collapse','east');
        $('#userListpanel').empty();
    }
</script>
