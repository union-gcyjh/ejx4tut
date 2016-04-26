puremvc.define({
        name: 'ejx4ui.model.proxy.CommonProxy',
        parent: puremvc.Proxy
    }, {
        LOCAL_STORAGE_NAME: 'ejx4ui-commonproxy',
        stats: {},
        list: [], // 数据模型
        onRegister: function () {
            commonPoxyObj = this;
        },
        /**
         * Session Data
         * 用户登入，获取用户菜单信息、并查看分发流水
         */
        getSessionData: function (data) {
        	utils.ajaxPost(staticParam.action_reqPath_main, 'getSessionData', '',  function(o) {
    			commonPoxyObj.sendNotification(ejx4ui.AppConstants.COMMON_SESSION_DATA_RESPONSE, o);
    		});
        },
        /**
         * 加载特定页面的Tab选项卡<br>
         * 根据菜单节点text的不同，进行对应操作。
         */
        addTab: function (data) {
        	commonPoxyObj.sendNotification(ejx4ui.AppConstants.COMMON_MAINTABS_ADD_RESPONSE, data);
        },
        /**
         * 修改用户个人密码
         */
        updateUserPwd: function(data){
        	utils.ajaxPost(staticParam.action_reqPath_main, 'updateUserPwdByUser', data,  function(o) {
    			commonPoxyObj.sendNotification(ejx4ui.AppConstants.COMMON_PASSWORD_UPDATE_RESPONSE, o);
    		});
        },
        /**
         * 获取通知数据
         */
        getNoticeData : function(data) {
			utils.ajaxPost(staticParam.action_reqPath_main, 'getNoticeData', data,
							function(o) {
								commonPoxyObj.sendNotification(ejx4ui.AppConstants.COMMON_NOTICE_DATA_RESPONSE,o);
							});
		}
        
    },
    {
        NAME: 'CommonProxy'
    }
);
