package com.pmt.caa.core.business.service.examiner.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmt.caa.SpringTest;
import com.pmt.caa.core.business.service.examiner.IExaminerService;
import com.pmt.caa.core.vo.ExaminerVo;

public class ExaminerServiceImplTest extends SpringTest {

	@Autowired
	IExaminerService examinerService;
	
	@Test
	public void testGetExaminer() {
		
		System.out.println("主試者列表 : " + examinerService.getExaminer());
	}

	@Test
	public void testAddExaminer() {

		String userid = "tom";
		String password = "1234";
		String name = "湯姆";
		String companyid = "1";
		String titleid = "1";
		
		boolean result = examinerService.addExaminer(userid, password, name, companyid, titleid);
		
		System.out.println("新增 主試者 : " + result);
	}

	@Test
	public void testGetExaminerById() {
		String id = "14";
		
		ExaminerVo result = examinerService.getExaminerById(id);
		
		System.out.println("主試者資料 ( " + id + ") : " + result );
	}

	@Test
	public void testEditExaminer() {
		String id = "14";
		String userid = "ken";
		String password = "ken123";
		String name = "肯恩";
		String companyid = "1";
		String titleid = "1";

		examinerService.editExaminer(id, userid, password, name, companyid, titleid);
	}

	@Test
	public void testDeleteExaminer() {
		String id = "14";
		boolean result = examinerService.deleteExaminer(id);
		
		System.out.println("刪除主試者 : " + result);
	}

}
