package com.pmt.caa.core.business.service.examiner.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.caa.core.business.service.examiner.IExaminerService;
import com.pmt.caa.core.common.util.ResourceFileUtil;
import com.pmt.caa.core.db.jdbc.JdbcDAO;
import com.pmt.caa.core.vo.ExaminerVo;

@Service
public class ExaminerServiceImpl implements IExaminerService {

	@Autowired
	private JdbcDAO iaJdbcDAO;

	@Override
	public boolean checkLoginStatus(String userid, String password) {
		String sqltext = "select * from examiner where userid = '" + userid + "' and password = '" + password + "'";
		
		List<Map<String, Object>> dataList = iaJdbcDAO.queryForList(sqltext);
		
		if (dataList.size() == 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Map<String, Object>> getExaminer() {

		List<Map<String, Object>> dataList = null;
		try {
			String sqltext = ResourceFileUtil.SQL.getResource("test", "GET_EXAMINER");
			
			dataList = iaJdbcDAO.queryForList(sqltext);

		} catch (Exception e) {
			e.printStackTrace();

			return Collections.emptyList();
		}

		return dataList;
	}
	
	@Override
	public boolean addExaminer(String userid, String password, String name, String companyid, String titleid) {
		String sqltext = "insert into examiner(userid, password, name, companyid, title, status) values('" + userid
				+ "' , '" + password + "' , '" + name + "' , '" + companyid + "' , '" + titleid +  "', 'Y')";
		
		System.out.println("addExaminer SQL : " + sqltext);

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

	@Override
	public ExaminerVo getExaminerById(String examinerId) {
        List<Map<String, Object>> dataList = null;
        if(examinerId != null) {
            try {
                String sqltext = "select * from examiner where id = '" + examinerId + "'";
                
                System.out.println("getExaminerById sql = " + sqltext);

                dataList = iaJdbcDAO.queryForList(sqltext);
                System.out.println("dataList = " + dataList);
            } catch(Exception e) {
                e.printStackTrace();
                
                return null;
            }
            
            if(dataList != null && !dataList.isEmpty()) {
            	ExaminerVo examinerVo = new ExaminerVo();
                for(Map<String, Object> rowMap :dataList) {
                    String id = MapUtils.getString(rowMap, "id");
                    
                    String userid = MapUtils.getString(rowMap, "userid");
                    
                    String password = MapUtils.getString(rowMap, "password");
                    
                    String name = MapUtils.getString(rowMap, "name");
                    
                    String companyid = MapUtils.getString(rowMap, "companyid");
                    
                    String title = MapUtils.getString(rowMap, "title");
                    
                    System.out.println("rowMap = " + rowMap);
                    
                    examinerVo.setId(id);
                    examinerVo.setUserid(userid);
                    examinerVo.setPassword(password);
                    examinerVo.setName(name);
                    examinerVo.setCompanyid(companyid);
                    examinerVo.setTitle(title);
                    examinerVo.setStatus("Y");
                }
                
                return examinerVo;
            }
            
        } else {
            
            return null;
        }
        
        return null;
	}
	
	@Override
	public boolean editExaminer(String id, String userid, String password, String name, String companyid, String titleid) {
		String sqltext = "update examiner set (userid, password, name, companyid, title, status) = ('" + userid
				+ "' , '" + password + "' , '" + name + "' , '" + companyid + "', '" + titleid +  "' , 'Y') where id ='" + id + "'";
		System.out.println(sqltext);

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteExaminer(String id) {
		String sqltext = "update examiner set status='N' where id = '" + id
				+ "'";

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

}
