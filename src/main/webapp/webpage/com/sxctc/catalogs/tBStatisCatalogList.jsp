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
        <t:datagrid name="tBCatalogdataList" checkbox="true" pagination="true" treegrid="true" fitColumns="false" title="服务目录统计" actionUrl="tBStatisCatalogController.do?datagrid&catalogtype=${type}"  idField="id" fit="true" queryMode="group">
            <t:dgCol title="主键"  field="id"  hidden="true" treefield="id" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="名称"  field="name" treefield="text" queryMode="single"  width="450"></t:dgCol>
            <t:dgCol title="单位"  field="danwei" treefield="fieldMap.danwei" queryMode="single"  width="80"></t:dgCol>
            <t:dgCol title="父节点ID"  field="fartherid"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="数量"  field="num"  hidden="true" treefield="fieldMap.num" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="类型"  field="type" hidden="true" treefield="fieldMap.type" queryMode="single"  dictionary="catatype"  width="120"></t:dgCol>
            <t:dgCol title="单价(元)"  field="price" queryMode="single" treefield="fieldMap.price"  width="80"></t:dgCol>
            <t:dgCol title="合计(元)"  field="total" treefield="fieldMap.total" queryMode="single"  width="120"></t:dgCol>
            <t:dgCol title="备注"  field="beizhu"  queryMode="single" treefield="fieldMap.beizhu" width="120"></t:dgCol>
            <t:dgCol title="操作" field="opt" width="200"></t:dgCol>
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
                //$("#tBCatalogdataList").treegrid("expandAll");
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
