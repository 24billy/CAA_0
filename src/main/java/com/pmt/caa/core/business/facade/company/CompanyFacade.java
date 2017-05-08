package com.pmt.caa.core.business.facade.company;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.caa.core.business.service.company.ICompanyService;

@Service
public class CompanyFacade {

	@Autowired
	ICompanyService companyService;

	public List<Map<String, Object>> getCompany() {
		return companyService.getCompany();
	}

	public boolean addCompany(String name) {
		return companyService.addCompany(name);
	}

	public boolean deleteCompany(String id) {
		return companyService.deleteCompany(id);
	}

}
