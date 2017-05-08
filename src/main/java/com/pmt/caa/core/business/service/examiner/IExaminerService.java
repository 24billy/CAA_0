package com.pmt.caa.core.business.service.examiner;

import java.util.List;
import java.util.Map;

import com.pmt.caa.core.vo.ExaminerVo;

public interface IExaminerService {
	
	/**
	 * 登入檢查
	 * 
	 * @return
	 */
	boolean checkLoginStatus(String userid, String password);

	/**
	 * 取得全部 主試者
	 * 
	 * @return
	 */
	List<Map<String, Object>> getExaminer();

	/**
	 * 新增 主試者
	 * 
	 * @param userid
	 * @param password
	 * @param name
	 * @param companyid
	 * @return
	 */
	boolean addExaminer(String userid, String password, String name,
			String companyid, String titleid);

	/**
	 * 以id 查詢 主試者
	 * 
	 * @param id
	 * @return
	 */
	ExaminerVo getExaminerById(String id);

	/**
	 * 編輯 主試者
	 * 
	 * @param id
	 * @param userid
	 * @param password
	 * @param name
	 * @param companyid
	 * @return
	 */
	boolean editExaminer(String id, String userid, String password,
			String name, String companyid, String titleid);

	/**
	 * 刪除 主試者
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteExaminer(String id);

}
