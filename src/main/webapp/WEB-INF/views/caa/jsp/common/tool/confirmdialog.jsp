<%
/**
 * Copyright (c) 2014 Far Eastone Telecommunications Co., Ltd.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of 
 * Far Eastone Telecommunications Co., Ltd. ("Confidential Information"). 
 * 
 * You shall not disclose such Confidential Information and shall use it 
 * only in accordance with the terms of license agreement you entered
 * into with Far Eastone Telecommunications Co., Ltd.
 *
 */
%>

<%@ page pageEncoding="UTF-8" %>

    <!-- confirm Dialog -->
    <div id="confirmDialog" class="hide">
    </div>

	<div id="warningBootBoxMsg" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel2" aria-hidden="true">
    	<div class="alert alert-error" style="margin: 0px; font-size: 14px;">
        	<strong></strong><span id="msgSpan"></span>
		</div>
	</div>

<script type="text/javascript">

/*
 * confirmDialog
 * 
 */
function doConfirmDialog(confirmFunction, confirmStatus) {
	var msg = '';
	
	if (confirmStatus == 'delete') {
		msg = '<br/>請確認是否刪除?<br/>';
    } else if (confirmStatus == 'cancel') {
    	msg = '<br/>提醒！您已按取消鈕，您所編輯文字將不予儲存保留。仍要取消請按”確認”，或”取消”回到編輯畫面<br/>';
    } else if (confirmStatus == 'close') {
    	msg = '<br/>請確認是否關閉?<br/>';
    } else if (confirmStatus == null || confirmStatus == "" || confirmStatus == undefined) {
    	msg = '<br/>請確認是否執行此動作?<br/>';
    }
	
	$('span[id="msgSpan"]').empty().html(msg);
	
	var $warningDiv = $('div[id="warningBootBoxMsg"]');
	
	bootbox.confirm($warningDiv.html(), function(result) {
		if (result)
		{
			confirmFunction();
		}
	});
}

</script>
