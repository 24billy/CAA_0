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

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * JSON格式處理工具<br>
 * 將JSON的處理統一在此實現
 * 
 * @author VJChou
 */
public class JsonUtil {

	private static ObjectMapper mapper;            //Date格式 yyyy/MM/dd
	private static ObjectMapper mapperDateTime;    //Date格式 yyyy/MM/dd HH:mm:ss
	private static ObjectMapper om;                //KEY不包雙引號
	
	/**
	 * 將傳入物件轉成JSON字串
	 * 
	 * @param src
	 * @return String
	 * @throws ParseException
	 */
	public static String toJson(Object src) {
		StringWriter jsonStringWriter = new StringWriter();

		try {
			try {
				getObjectMapper().writeValue(jsonStringWriter, src);
				
				String jsonStr = jsonStringWriter.toString();

				return jsonStr;
			} finally {
				if (jsonStringWriter != null) {
					jsonStringWriter.close();
					jsonStringWriter = null;
				}
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}
	
	/**
     * 將傳入物件轉成JSON字串
     * 
     * @param src
     * @return String
     * @throws ParseException
     */
    public static String toJsonDateTime(Object src) {
        StringWriter jsonStringWriter = new StringWriter();

        try {
            try {
                getObjectMapperDateTime().writeValue(jsonStringWriter, src);
                String jsonStr = jsonStringWriter.toString();

                return jsonStr;
            } finally {
                if (jsonStringWriter != null) {
                    jsonStringWriter.close();
                    jsonStringWriter = null;
                }
            }
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
	
	/**
	 * 將傳入物件轉成JSON字串，但KEY不包雙引號
	 * 
	 * @param src
	 * @return String
	 * @throws ParseException
	 */
	public static String toJsonWithoutQuote(Object src) {
		StringWriter jsonStringWriter = new StringWriter();

		try {
			try {
			    if (om == null) {
			        om = new ObjectMapper();
                    om.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
                    om.setSerializationInclusion(Inclusion.NON_NULL);
                    om.configure(Feature.QUOTE_FIELD_NAMES, false);
			    }

				om.writeValue(jsonStringWriter, src);
				
				String jsonStr = jsonStringWriter.toString();

				return jsonStr;
			} finally {
				if (jsonStringWriter != null) {
					jsonStringWriter.close();
					jsonStringWriter = null;
				}
			}
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 將傳JSON字串入轉成物件
	 * 
	 * @param json
	 * @param classOfT
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> classOfT) {
		Gson gsonObj = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
		
		return gsonObj.fromJson(json, classOfT);
		
		/*
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(json, classOfT);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		*/
	}
	
	/**
     * 將傳JSON字串入轉成物件  Data Format為 yyyy/MM/dd HH:mm:ss
     * 
     * @param json
     * @param classOfT
     * @return
     */
    public static <T> T fromJsonDateTime(String json, Class<T> classOfT) {
        Gson gsonObj = new GsonBuilder().setDateFormat("yyyy/MM/dd HH:mm:ss").create();

        return gsonObj.fromJson(json, classOfT);
    }
	
	/**
	 * Date格式  yyyy/MM/dd
	 * 
	 * @return
	 */
	private static ObjectMapper getObjectMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			// 2014-04-14 
			//   修正Date格式問題。
			mapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd"));
			mapper.setSerializationInclusion(Inclusion.NON_NULL);
		}
		
		return mapper;
	}

	/**
     * Date格式  yyyy/MM/dd HH:mm:ss
     * 
     * @return
     */
    private static ObjectMapper getObjectMapperDateTime() {
        if (mapperDateTime == null) {
            mapperDateTime = new ObjectMapper();
    
            mapperDateTime.setDateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
            mapperDateTime.setSerializationInclusion(Inclusion.NON_NULL);
        }
        return mapperDateTime;
    }

	public static void main(String[] args) {   
	    Gson gson=  new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
	    String date = "\"2013-02-10T13:45:30+0800\"";
	    Date test = gson.fromJson(date, Date.class);
	}
	
}
