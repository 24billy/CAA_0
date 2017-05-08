package com.pmt.caa.web.webapp.action;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.struts2.ServletActionContext;

import com.pmt.caa.core.common.Context;
import com.pmt.caa.core.vo.UserSessionVO;
import com.pmt.caa.web.webapp.util.CaaActionResult;
import com.pmt.caa.web.webapp.util.ScopeUtil;
import com.pmt.caa.web.webapp.util.ScopeUtil.Scope;


public class CaaAbstractAction {

	/** The data map. */
	private Map<String, Object> dataMap;
	
	private String jsonData; // JSON 參數名稱
	
	/**
	 * 將傳入資訊存入requestScope，並導頁至「Wrapper/result.jsp」.<br>
	 *
	 * @param jsonData the json data
	 * @return String
	 */
	public String forwardJsonString(String jsonData) {
		Map<String, Object> reqMp = ScopeUtil.getScopeAttribute(Scope.REQUEST);
		reqMp.put(Context.R_RESULT_ATTR_KEY, jsonData);

		return CaaActionResult.FORWARD_RESTful;
	}
	
	/**
	 * Prepare session info.<br>
	 *
	 * @param userSessionVO the user session vo
	 * @return true, if successful
	 */
	public UserSessionVO prepareSessionInfo(UserSessionVO userSessionVO) {
    	userSessionVO.setLoginDateTime(new Date());
        
        HttpServletRequest request = ServletActionContext.getRequest();
        String remoteAddr = request.getRemoteAddr();
        remoteAddr = validate(remoteAddr);

        userSessionVO.setRemoteAddr(remoteAddr);
        
        return userSessionVO;
    }
	
	public void setUserSessionVO(UserSessionVO userSessionVO) {
		userSessionVO = prepareSessionInfo(userSessionVO);
		
		Map<String, Object> sessionMap = ScopeUtil.getScopeAttribute(Scope.SESSION);
		sessionMap.put(Context.S_SESSION_KEY, userSessionVO);
	}
	
    /**
     * 取得登入後的Session封裝物件.<br>
     * 
     * @return SessionVO
     */
//    public UserSessionVO getSessionVO() {
//        Map<String, Object> sessionMap = ScopeUtil.getScopeAttribute(Scope.SESSION);
//
//        UserSessionVO userSessionVO = null;
//        if (sessionMap.containsKey(Context.S_SESSION_KEY)) {
//        	userSessionVO = (UserSessionVO) MapUtils.getObject(sessionMap, Context.S_SESSION_KEY);
//
//            if (userSessionVO == null) {
//            	userSessionVO = new UserSessionVO();
//            }
//        } else {
//        	userSessionVO = new UserSessionVO();
//            sessionMap.put(Context.S_SESSION_KEY, userSessionVO);
//        }
//
//        return userSessionVO;
//    }	

    /**
     * Removes the session vo.<br>
     *
     * @return true, if successful
     */
    public boolean removeUserSessionVO() {
        Map<String, Object> sessionMap = ScopeUtil.getScopeAttribute(Scope.SESSION);
        if (sessionMap != null && !sessionMap.isEmpty()) {
            if (sessionMap.containsKey(Context.S_SESSION_KEY)) {
                sessionMap.remove(Context.S_SESSION_KEY);
                return true;
            }
        }
        
        return false;
    }    
    
	/**
	 * Gets the reqest parameter.<br>
	 *
	 * @param request the request
	 * @param paramName the param name
	 * @return the reqest parameter
	 */
	protected String getReqestParameter(HttpServletRequest request, String paramName) {
		String str = request.getParameter(paramName);
		str = canonicalize(str);
		return validate(str);
	}
	
	/**
	 * Gets the reqest query str.<br>
	 *
	 * @param request the request
	 * @return the reqest query str
	 */
	protected String getReqestQueryStr(HttpServletRequest request) {
		String str = request.getQueryString();
		str = canonicalize(str);
		return validate(str);
	}
	
	/**
	 * Validate.<br>
	 *
	 * @param paramName the param name
	 * @return the string
	 */
	protected String validate(String paramName) {
    	return paramName;
    }
	
	/**
	 * Canonicalize.<br>
	 *
	 * @param prevalidatedStr the prevalidated str
	 * @return the string
	 */
	protected String canonicalize(String prevalidatedStr) {
		if (prevalidatedStr != null) {
            return new String(prevalidatedStr.getBytes());
        }
        return null;
    }

	/**
	 * Gets the data map.<br>
	 *
	 * @return the data map
	 */
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	/**
	 * Sets the data map.<br>
	 *
	 * @param dataMap the data map
	 */
	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }

}
