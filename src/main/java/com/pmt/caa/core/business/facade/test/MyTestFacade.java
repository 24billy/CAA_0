package com.pmt.caa.core.business.facade.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.caa.core.business.service.test.IMyTest;

@Service
public class MyTestFacade {
	@Autowired
	IMyTest myTestimpl;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Map<String, Object>> test() {
		String medical_no = "A001";
		 
		myTestimpl.deleteSubject(medical_no);
		
		// PK重複
		myTestimpl.addSubject(medical_no);
		
		return null;
	}
}
