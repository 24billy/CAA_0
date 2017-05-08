package com.pmt.caa.core.business.service.company;

import java.util.List;
import java.util.Map;

public interface ICompanyService {

	/**
	 * 查詢全部公司
	 * 
	 * @return
	 */
	List<Map<String, Object>> getCompany();

	/**
	 * 新增公司
	 * 
	 * @param name
	 * @return
	 */
	boolean addCompany(String name);

	/**
	 * 刪除公司
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteCompany(String id);

}
