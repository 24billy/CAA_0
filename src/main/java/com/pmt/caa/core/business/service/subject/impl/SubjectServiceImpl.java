package com.pmt.caa.core.business.service.subject.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.pmt.caa.core.business.service.subject.ISubjectService;
import com.pmt.caa.core.common.util.ResourceFileUtil;
import com.pmt.caa.core.db.jdbc.JdbcDAO;
import com.pmt.caa.core.vo.SubjectVo;

@Service
public class SubjectServiceImpl implements ISubjectService {

	@Autowired
	private JdbcDAO iaJdbcDAO;
	
    @Autowired
    @Qualifier(value = "transactionManager")
    private PlatformTransactionManager transactionManager;
    
    private DefaultTransactionDefinition def;
    
    public void setDataSource() {
        transactionManager = new DataSourceTransactionManager(iaJdbcDAO.getDataSource());
        def = new DefaultTransactionDefinition();
        
        // 建立交易的定義 :支援現在的交易，如果沒有的話就建立一個新的交易
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
    }
	
	@Override
	public List<Map<String, Object>> getSubjectRecord() {
		List<Map<String, Object>> dataList = null;
		try {
			String sqltext = ResourceFileUtil.SQL.getResource("test", "GET_SUBJECT_RECORD");
			
			dataList = iaJdbcDAO.queryForList(sqltext);

		} catch (Exception e) {
			e.printStackTrace();

			return Collections.emptyList();
		}

		return dataList;
	}

	@Override
	public boolean addSubject(String medical_no, String gender, String name, String birthday) {
		Connection con = null;
		
        TransactionStatus status = transactionManager.getTransaction(def);
        con = iaJdbcDAO.getConnection();
        
        try {
			con.setAutoCommit(false);
			
			// step 1 新增主檔
			String sqltext = "insert into subject_main(medical_no, gender, name, birthday, status) values('" + medical_no
					+ "' , '" + gender + "' , '" + name + "' , '" + birthday +   "' , 'Y')";
			System.out.println(sqltext);

			int updateCount = iaJdbcDAO.update(sqltext);
			
			if(updateCount == 0) {
                System.out.println("新增主檔失敗");
//                transactionManager.rollback(status);
                return false;
            }
			
			// step 2 新增一筆明細檔
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date current = new Date();
			System.out.println(sdFormat.format(current));
			
			String createdate = sdFormat.format(current);
			
			String sqltext2 = "insert into subject_detail(medical_no, createdate, status) values('" + medical_no
					+ "' , '" + createdate +   "' , 'Y')";
			System.out.println(sqltext2);
			
			int updateCount2 = iaJdbcDAO.update(sqltext2);
			
			if(updateCount2 == 0) {
                System.out.println("新增明細檔失敗");
                transactionManager.rollback(status);
                return false;
            }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(status);
			
			return false;
		} catch (Exception e) {
			System.out.println("@@@@ PK重複!!");
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			transactionManager.rollback(status);
			
			return false;
		} finally {
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        transactionManager.commit(status);
		
        return true;
	}

	@Override
	public SubjectVo getSubjectById(String medical_no) {
        List<Map<String, Object>> dataList = null;
        if(medical_no != null) {
            try {
                String sqltext = "select * from subject_main where medical_no = '" + medical_no + "'";
                
                System.out.println("getSubjectById sql = " + sqltext);

                dataList = iaJdbcDAO.queryForList(sqltext);
                System.out.println("dataList = " + dataList);
            } catch(Exception e) {
                e.printStackTrace();
                
                return null;
            }
            
            if(dataList != null && !dataList.isEmpty()) {
            	SubjectVo subjectVo = new SubjectVo();
                for(Map<String, Object> rowMap :dataList) {
                    
                    String gender = MapUtils.getString(rowMap, "gender");
                    String name = MapUtils.getString(rowMap, "name");
                    String birthday = MapUtils.getString(rowMap, "birthday");
                    String status = MapUtils.getString(rowMap, "status");
                    
                    
                    System.out.println("rowMap = " + rowMap);
                    
                    subjectVo.setMedical_no(medical_no);
                    subjectVo.setGender(gender);
                    subjectVo.setName(name);
                    subjectVo.setBirthday(birthday);
                    subjectVo.setStatus(status);
                }
                
                return subjectVo;
            }
            
        } else {
            
            return null;
        }
        
        return null;
	}
	
	@Override
	public boolean editSubject(String medical_no, String gender,
			String name, String birthday) {
		String sqltext = "update subject_main set (gender, name, birthday, status) = ('" + gender + "' , '" + name + "' , '" + birthday +   "', 'Y') where medical_no ='" + medical_no + "'";
		System.out.println(sqltext);

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}	
	
	@Override
	public boolean addSubjectRecord(String medical_no) {
		// step 2 新增一筆明細檔
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date current = new Date();
		System.out.println(sdFormat.format(current));

		String createdate = sdFormat.format(current);

		String sqltext = "insert into subject_detail(medical_no, createdate, status) values('"
				+ medical_no + "' , '" + createdate + "' , 'Y')";
		System.out.println(sqltext);

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}
	
	@Override
	public boolean deleteSubjectRecord(String id) {
		String sqltext = "update subject_detail set status='N' where id = '" + id
				+ "'";

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

	@Override
	public int getSubjectRecordByMedical_no(String medical_no) {
		List<Map<String, Object>> dataList = null;
		try {
			String sqltext = "select * from subject_detail where medical_no = '" + medical_no + "'";
			
			dataList = iaJdbcDAO.queryForList(sqltext);

		} catch (Exception e) {
			e.printStackTrace();

			return 0;
		}

		return dataList.size();
	}

	@Override
	public boolean deleteSubject(String medical_no) {
		String sqltext = "update subject_main set status='N' where medical_no = '" + medical_no
				+ "'";

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

}
