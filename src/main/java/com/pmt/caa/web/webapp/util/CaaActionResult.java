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
 */

package com.pmt.caa.web.webapp.util;

import com.opensymphony.xwork2.Action;

/**
 * 定義控制器導頁的名稱<br>
 * 
 * 如：「SUCCESS」、「ERROR」
 * 
 * @author Paul
 */
public interface CaaActionResult extends Action {

	/**
	 * 導頁至「訊息」的名稱
	 */
	String MESSAGE = "message";

	/**
	 * 導頁至「開新視窗」的名稱
	 */
	String POPUP = "popup";

	/**
	 * 導頁至Wrapper result.jsp
	 */
	String FORWARD_RESTful = "RESTful";

	/**
	 * 導頁至「選擇登入角色」 畫面
	 */
	String CONFIRM_LOGIN = "CONFIRM_LOGIN";

	/**
	 * 導頁至「逾時」 畫面
	 */
	String TIME_OUT = "timeout";

}
