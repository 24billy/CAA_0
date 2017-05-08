package com.pmt.caa.core.business.service.company.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmt.caa.SpringTest;
import com.pmt.caa.core.business.service.company.ICompanyService;

public class CompanyServiceimplTest extends SpringTest {
	
	@Autowired
	ICompanyService companyService;

	@Test
	public void testGetCompany() {
		System.out.println("公司列表 : " + companyService.getCompany());
	}

	@Test
	public void testAddCompany() {
		String companyName = "測試A";
		
		boolean result = companyService.addCompany(companyName);
		
		System.out.println("新增公司 : " + result);
	}

	@Test
	public void testDeleteCompany() {
		String id = "7";
		
		boolean result = companyService.deleteCompany(id);
		
		System.out.println("刪除公司 : " + result);
	}

}
