package com.pmt.caa.core.business.service.test;

import java.util.List;
import java.util.Map;

public interface IMyTest {
	boolean addSubject(String medical_no);
	
	boolean deleteSubject(String medical_no);
	
	Map<String, Object> getResponse(String id);  
}
