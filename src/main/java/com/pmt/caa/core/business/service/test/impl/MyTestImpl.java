package com.pmt.caa.core.business.service.test.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.caa.core.business.service.test.IMyTest;
import com.pmt.caa.core.common.util.ResourceFileUtil;
import com.pmt.caa.core.db.jdbc.JdbcDAO;

@Service
public class MyTestImpl implements IMyTest {

	@Autowired
	private JdbcDAO iaJdbcDAO;
	
	@Override
	public boolean addSubject(String medical_no) {
		
		String gender = "F";
		String name = "test";
		String birthday = "1999-10-10";
		
		String sqltext = "insert into subject_main(medical_no, gender, name, birthday, status) values('" + medical_no
				+ "' , '" + gender + "' , '" + name + "' , '" + birthday +   "' , 'Y')";
		System.out.println(sqltext);

		int updateCount = iaJdbcDAO.update(sqltext);
		
		if (updateCount == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteSubject(String medical_no) {
		String gender = "F";
		String name = "test222";
		String birthday = "1999-10-10";
		
		String sqltext = "update subject_main set (gender, name, birthday, status) = ('" + gender + "' , '" + name + "' , '" + birthday +   "', 'N') where medical_no ='" + medical_no + "'";
		System.out.println(sqltext);

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

	@Override
	public Map<String, Object> getResponse(String id) {
		List<Map<String, Object>> dataList = null;
		Map<String, Object> dataMap = null;
		try {
//			String sqltext = ResourceFileUtil.SQL.getResource("test", "GET_RESPONSE");
			String sqltext = "select * from test where id = '" + id + "'";
			
			dataMap = iaJdbcDAO.queryForMap(sqltext);
			
			dataList = iaJdbcDAO.queryForList(sqltext);

		} catch (Exception e) {
			e.printStackTrace();

			return new HashMap<String, Object>();
		}

		return dataMap;
	}
	
	
}
