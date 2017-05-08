package com.pmt.caa.core.business.facade.subject;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pmt.caa.core.business.service.subject.ISubjectService;
import com.pmt.caa.core.vo.SubjectVo;

@Service
public class SubjectFacade {
	@Autowired
	ISubjectService subjectService;

	public List<Map<String, Object>> getSubjectRecord() {
		return subjectService.getSubjectRecord();
	}
	
	public boolean addSubject(String medical_no, String gender, String name, String birthday) {
		return subjectService.addSubject(medical_no, gender, name, birthday);
	}

	public SubjectVo getSubjectById(String medical_no) {
		return subjectService.getSubjectById(medical_no);
	}
	
	public boolean editSubject(String medical_no, String gender, String name, String birthday) {
		return subjectService.editSubject(medical_no, gender, name, birthday);
	}
	
	public boolean addSubjectRecord(String medical_no) {
		return subjectService.addSubjectRecord(medical_no);
	}
	
	public boolean deleteSubjectRecord(String id) {
		return subjectService.deleteSubjectRecord(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean deleteSubjectRecord2() {
		
		subjectService.deleteSubjectRecord("33");
		
		subjectService.addSubject("A001", "F", "1", "1");
		
		
		return true;
	}
	
}
