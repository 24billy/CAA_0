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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author VJChou
 */
public class ReadFileUtil {

	// add at 2013-12-04
	private static final String encoding = "UTF-8";

	/**
	 * 回傳文字格式內容
	 * 
	 * @param inStream
	 * @return String
	 */
	public static String readTextFile(InputStream inStream) {
		String content = "";

		try {
			int ca = inStream.available();
			byte[] by = new byte[ca];
			
			inStream.read(by);
			content = new String(by, encoding);
			inStream.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}
	
}
