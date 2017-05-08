package com.pmt.caa.core.business.service.subject;

import java.util.List;
import java.util.Map;

import com.pmt.caa.core.vo.SubjectVo;

public interface ISubjectService {
	
	/**
	 * 取得全部 受試者的全部紀錄
	 * 
	 * @return
	 */
	List<Map<String, Object>> getSubjectRecord();

	/**
	 * 新增  受試者 (新增主檔 + 一筆明細檔)
	 * 
	 * @param medical_no
	 * @param gender
	 * @param name
	 * @param birthday
	 * @return
	 */
	boolean addSubject(String medical_no, String gender, String name,
			String birthday);
	
	/**
	 * 以medical_no 查詢 受試者
	 * 
	 * @param medical_no
	 * @return
	 */
	SubjectVo getSubjectById(String medical_no);
	
	/**
	 * 編輯 受試者
	 * 
	 * @param medical_no
	 * @param gender
	 * @param name
	 * @param birthday
	 * @return
	 */
	boolean editSubject(String medical_no, String gender,
			String name, String birthday);

	/**
	 * 新增 一筆明細 (受試者的某次測驗)
	 * 
	 * @param medical_no
	 * @return
	 */
	boolean addSubjectRecord(String medical_no);

	/**
	 * 刪除 一筆明細 (受試者的某次測驗)
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteSubjectRecord(String id);

	/**
	 * 
	 * @param medical_no
	 * @return
	 */
	int getSubjectRecordByMedical_no(String medical_no);
	
	/**
	 * 
	 * @param medical_no
	 * @return
	 */
	boolean deleteSubject(String medical_no);

}
