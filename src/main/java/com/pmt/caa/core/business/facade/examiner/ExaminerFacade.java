package com.pmt.caa.core.business.facade.examiner;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmt.caa.core.business.service.examiner.IExaminerService;
import com.pmt.caa.core.vo.ExaminerVo;


@Service
public class ExaminerFacade {

	@Autowired
	IExaminerService examinerService;

	public boolean checkLoginStatus(String userid, String password) {
		return examinerService.checkLoginStatus(userid, password);
	}
	
	public List<Map<String, Object>> getExaminer() {
		return examinerService.getExaminer();
	}

	public boolean addExaminer(String userid, String password, String name,
			String companyid, String titleid) {
		return examinerService.addExaminer(userid, password, name, companyid, titleid);
	}

	public ExaminerVo getExaminerById(String id) {
		return examinerService.getExaminerById(id);
	}

	public boolean editExaminer(String id, String userid, String password, String name,
			String companyid, String titleid) {
		return examinerService.editExaminer(id, userid, password, name, companyid, titleid);
	}
	
    public boolean deleteExaminer(String id) {
        return examinerService.deleteExaminer(id);
    }
    
}
