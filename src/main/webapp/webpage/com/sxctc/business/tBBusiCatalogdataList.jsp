<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery-webos,easyui,tools,DatePicker,autocomplete"></t:base>
<div class="easyui-layout" fit="true">
    <div region="center" style="padding:0px;border:0px">
        <t:datagrid name="tBCatalogdataList"  checkbox="true" pagination="false" fitColumns="true" treegrid="true"
                    actionUrl="tBBusiCatalogdataController.do?datagrid&businessId=${businessId}&type=${type}" idField="id"  queryMode="group" singleSelect="true">
            <t:dgCol title="id"  field="id"   hidden="true" treefield="id"  queryMode="group"  width="140"></t:dgCol>
            <t:dgCol title="名称"  field="name" treefield="text" width="150"></t:dgCol>
            <t:dgCol title="单位"  field="danwei" treefield="fieldMap.danwei" width="40"></t:dgCol>
            <t:dgCol title="单价"  field="price" treefield="fieldMap.price" width="40"></t:dgCol>
            <t:dgCol title="数量"  field="num" treefield="fieldMap.num" extendParams="editor:'numberbox'" width="80"></t:dgCol>
            <t:dgCol title="备注"  field="beizhu" treefield="fieldMap.beizhu" width="80"></t:dgCol>

            <%--<t:dgToolBar operationCode="edit" title="编辑" icon="icon-edit"  funname="editRow"></t:dgToolBar>--%>
            <%--<t:dgToolBar operationCode="save" title="保存" icon="icon-save" url="jeecgListDemoController.do?saveRows" funname="saveData"></t:dgToolBar>--%>
            <%--<t:dgToolBar operationCode="undo" title="取消编辑" icon="icon-undo" funname="reject"></t:dgToolBar>--%>
        </t:datagrid>
    </div>
</div>
<script type="text/javascript">
    $(document).ready(function(){
        initTreegrid();
    });

    function initTreegrid() {
        $("#tBCatalogdataList").treegrid({
            onExpand : function(row){
                $("#tBCatalogdataList").treegrid("expandAll",row.id)
                // var children = $("#tBCatalogdataList").treegrid('getChildren',row.id);
                // if(children.length<=0){
                //     row.leaf=true;
                //     $("#tBCatalogdataList").treegrid('refresh', row.id);
                // }
            },
            onDblClickRow:function(index,row){
                editRow('','',"tBCatalogdataList");
            },
            onClickCell:function(index, field, value){
                endEdit('','',"tBCatalogdataList");
            },
            onAfterEdit:function(index, row, changes){//获取行编辑数据并动态计算
                /*$('#datagrid-cost').datagrid('updateRow',{//只在页面更新
                    index: index,
                    row: {
                        costTotal: changes.factCostAmount*1.2
                    }
                });*/
                saveData('','',"tBCatalogdataList");

            },
            onLoadSuccess: function () {
                $("#tBCatalogdataList").treegrid("expandAll");
            }
        });
    }
    var editingId;

    //保存数据
    function saveData(title,addurl,gname){
        alert("进来保存方法了")
        if (editingId != undefined){
            var t = $('#'+gname);
            t.treegrid('endEdit', editingId);
            editingId = undefined;
            t.treegrid('reloadFooter');
        }

        // 保存
        var id=this.gettBCatalogdataListSelections('id').toString();
        var num=this.gettBCatalogdataListSelections('fieldMap.num');
        alert(id);
        alert(num);
        $.ajax({
            url:"tBBusiCatalogController.do?doAdd",
            type:"post",
            data:{
                catalogId:id,
                businessId:"${businessId}",
                checkNum: Number(num)
            },
            dataType:"json",
            success:function(data){
                tip(data.msg);
                if(data.success){
                    return;
                }
            }
        });
    }

    //编辑行
    function editRow(title,addurl,gname){
        if (editingId != undefined){
            $('#'+gname).treegrid('select', editingId);
            return;
        }
        var rows=$('#'+gname).treegrid("getSelected");
        var children = $("#tBCatalogdataList").treegrid('getChildren',rows.id);
        if(children.length>0){
            tip("请选择子条目");
            return false;
        }
        if ((rows._parentId === undefined) && (rows.leaf === undefined) ){
            tip("请选择子条目");
            return false;
        }
        if(rows.length===0){
            tip("请选择条目");
            return false;
        }
        if (rows){
            editingId = rows.id;
            $('#'+gname).treegrid('beginEdit', editingId);
        }
        // for(var i=0;i<rows.length;i++){
        //     var index= $('#'+gname).treegrid('getRowIndex', rows[i]);
        //     $('#'+gname).treegrid('beginEdit', index);
        // }
    }

    //取消编辑
    function reject(title,addurl,gname){
        if (editingId != undefined){
            $('#'+gname).treegrid('cancelEdit', editingId);
            editingId = undefined;
        }

    }

    //结束编辑
    function endEdit(title,addurl,gname){
        if (editingId != undefined){
            $('#'+gname).treegrid('endEdit', editingId);
            editingId = undefined;
        }

    }

</script>