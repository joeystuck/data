Ext.define('WF.view.sys.config.editSysConfig', {
    extend: 'Ext.window.Window',
    alias: 'editSysConfig',
    title: '编辑',
    modal: true,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    initComponent: function () {
        this.callParent(arguments);
        var me = this;
        me.add({
            xtype: 'dataform',
            baseCls: 'x-plain',
            border: true,
            columns: 2,
            items: [{
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'name',
                colspan: 2,
                fieldLabel: '名称'
            },{
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'value',
                colspan: 2,
                fieldLabel: '值'
            },{
                allowBlank: true,
                name: 'remark',
                xtype: 'textarea',
                colspan: 2,
                fieldLabel: '备注'
            },{
                afterLabelTextTpl: required,
                allowBlank: false,
                colspan: 2,
                name: 'channelId',
                xtype: 'searchfield',
                emptyText: "--请选择--",
                displayField: 'name',
                valueField: "id",
                editable: false,
                queryMode: "local",
                store: 'channelStore',
                fieldLabel: '渠道'
            },{
                xtype: 'hidden',
                name: 'id'
            }]
        });
    },
    buttons: [{
        text: '保存',
        iconCls: "icon-ok",
        handler: function () {
            var currentWindow = this.up('window');
            var form = currentWindow.down('dataform').getForm();
            if (!form.isValid()) {
                return;
            }
            var doRefresh = currentWindow.doRefresh;
            callapi("data/admin/sysconfig/save.do", form.getValues(),
                function (result) {
                    if (result.success) {
                        Ext.MessageBox.show({
                            title: "提示",
                            msg: "保存成功",
                            modal: true,
                            icon: Ext.Msg.INFO,
                            buttons: Ext.Msg.OK
                        });
                        doRefresh.reload();
                        currentWindow.close();
                    }
                    else {
                        Ext.Msg.show({
                            title: '错误',
                            msg: result.data.msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR,
                            modal: true
                        });
                    }
                });
        }
    }]
});