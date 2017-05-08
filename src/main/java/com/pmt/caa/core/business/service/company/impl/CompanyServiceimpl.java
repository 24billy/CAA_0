package com.pmt.caa.core.business.service.company.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.caa.core.business.service.company.ICompanyService;
import com.pmt.caa.core.db.jdbc.JdbcDAO;

@Service
public class CompanyServiceimpl implements ICompanyService {

	@Autowired
	private JdbcDAO iaJdbcDAO;

	@Override
	public List<Map<String, Object>> getCompany() {
		List<Map<String, Object>> dataList = null;
		try {
			String sqltext = "select * from company where status='Y'";

			dataList = iaJdbcDAO.queryForList(sqltext);

		} catch (Exception e) {
			e.printStackTrace();

			return Collections.emptyList();
		}

		return dataList;
	}

	@Override
	public boolean addCompany(String name) {

		String sqltext = "insert into company(name,status) values('" + name
				+ "', 'Y')";

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteCompany(String id) {
		String sqltext = "update company set status='N' where id = '" + id
				+ "'";

		int updateStatus = iaJdbcDAO.update(sqltext);

		if (updateStatus > 0) {
			return true;
		}

		return false;
	}

}
