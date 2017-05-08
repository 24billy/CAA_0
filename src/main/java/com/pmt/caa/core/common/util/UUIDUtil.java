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

package com.pmt.caa.core.common.util;

import java.util.UUID;

/**
 *
 * @author steveHsu
 */
public class UUIDUtil {
	
	public static String getUUID32() {
		return  UUID.randomUUID().toString().replaceAll("-", "");
	}

}
