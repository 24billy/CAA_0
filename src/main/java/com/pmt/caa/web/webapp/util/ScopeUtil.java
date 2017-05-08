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

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

/**
 * J2EE Scope(容器存取範圍)管理器 (透過Struts2實現)
 * 
 * @author VJChou
 */
public class ScopeUtil {

	/**
	 * The Enum Scope.
	 */
	public static enum Scope {
		REQUEST, SESSION, APPLICATION
	};

	/**
	 * Gets the scope attribute.
	 * 
	 * @param scope
	 *            the scope
	 * @return the scope attribute
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getScopeAttribute(Scope scope) {
		ActionContext actionCtx = ActionContext.getContext();

		if (actionCtx != null) {
			switch (scope) {
			case APPLICATION:
				return actionCtx.getApplication();
			case SESSION:
				return actionCtx.getSession();
			case REQUEST:
			default:
				return (Map<String, Object>) actionCtx.get("request");
			}
		}

		return null;
	}
	
}
