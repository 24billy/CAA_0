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

import java.io.InputStream;

/**
 * 資源管理器
 * 
 * @author Billy
 */
public enum ResourceFileUtil {

	JSON("json"), // json檔案
	CSV("csv"), // csv檔案
	XLS("xls"), // xls檔案
	XLSX("xlsx"), // xlsx檔案
	XML("xml"), // xml檔案
	SQL("sql"); // SQL檔案

	private String target; // 指定資料夾

	private static String rootDir = "template";

	/** separator */
	private static String separator = "/";

	private ResourceFileUtil(String target) {
		this.target = target;
	}

	/**
	 * 根據指定的[路徑/檔案名稱]回傳[檔案]內容(文字). <br>
	 * 
	 * @param params
	 * @return String
	 */
	public final String getResource(String... params) {
		InputStream inStr = getResourceAsInputStream(params);

		if (inStr != null) {
			return ReadFileUtil.readTextFile(inStr);
		}

		return "";
	}
	
	/**
	 * 根據指定的[路徑/檔案名稱]回傳[檔案]內容(InputStream). <br>
	 * 
	 * @param params
	 * @return InputStream
	 */
	public final InputStream getResourceAsInputStream(String... params) {
		if (params != null && params.length != 0) {
			StringBuilder sb = new StringBuilder(separator + rootDir + separator + target + separator);

			int len = params.length;
			int count = 0;

			for (String index : params) {
				sb.append(index);
				count++;
				if (count < len) {
					sb.append(separator);
				}
			}

			sb.append("." + target);

			// 找到sql檔案
			InputStream inStr = ResourceFileUtil.class.getResourceAsStream(sb.toString());

			return inStr;
		}

		return null;		
	}

}
