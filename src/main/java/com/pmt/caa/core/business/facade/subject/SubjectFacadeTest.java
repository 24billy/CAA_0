package com.pmt.caa.core.business.facade.subject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmt.caa.SpringTest;

public class SubjectFacadeTest extends SpringTest{

	@Autowired
	private SubjectFacade s;
	
	@Test
	public void testDeleteSubjectRecord2() {
		System.out.println("111");
		
		s.deleteSubjectRecord2();
		
		System.out.println("222");
	}

}
