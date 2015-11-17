Ext.require(['*']);

    Ext.onReady(function() {

        Ext.QuickTips.init();

        // NOTE: This is an example showing simple state management. During development,
        // it is generally best to disable state management as dynamically-generated ids
        // can change across page loads, leading to unpredictable results.  The developer
        // should ensure that stable state ids are set for stateful components in real apps.
        Ext.state.Manager.setProvider(Ext.create('Ext.state.CookieProvider'));

        var viewport = Ext.create('Ext.Viewport', {
            id: 'border-example',
            layout: 'border',
            items: [
            // create instance immediately
            Ext.create('Ext.Component', {
                region: 'north',
                height: 25, // give north and south regions a height 63
                deferredRender: false,
                contentEl: 'north',
                bodyStyle:'background:#f1f1f1'
            }), /*{
                // lazily created panel (xtype:'panel' is default)
                region: 'south',
                contentEl: 'south',
                split: true,
                height: 100,
                minSize: 100,
                maxSize: 200,
                collapsible: true,
                collapsed: true,
                title: 'South',
                margins: '0 0 0 0'
            }, {
                region: 'east',
                stateId: 'navigation-panel',
                title: 'East Side',
                animCollapse: true,
                collapsible: true,
                split: true,
                width: 225, // give east and west regions a width
                minSize: 175,
                maxSize: 400,
                margins: '0 5 0 0',
                contentEl: 'east'
            },*/ {
                region: 'west',
                stateId: 'navigation-panel',
                id: 'west-panel', // see Ext.getCmp() below
                title: 'Modulos',
                split: true,
                width: 150,
                minWidth: 150,
                maxWidth: 200,
                collapsible: false,
                animCollapse: false,
                autoScroll: true,
                margins: '0 0 0 5',
                contentEl: 'west'
            },
            // in this instance the TabPanel is not wrapped by another panel
            // since no title is needed, this Panel is added directly
            // as a Container
            Ext.create('Ext.Panel', {
                region: 'center', // a center region is ALWAYS required for border layout
                deferredRender: false,
                contentEl: 'center',
                autoScroll:true
            })]
        });
    });