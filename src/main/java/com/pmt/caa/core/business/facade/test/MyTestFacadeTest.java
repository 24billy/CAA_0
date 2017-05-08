package com.pmt.caa.core.business.facade.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmt.caa.SpringTest;

public class MyTestFacadeTest extends SpringTest {
	
	@Autowired
	MyTestFacade myTestFacade;

	@Test
	public void test() {
		System.out.println("111");
		myTestFacade.test();
		
		System.out.println("222");
	}

}
