package com.pmt.caa.core.business.service.test.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.pmt.caa.SpringTest;
import com.pmt.caa.core.business.service.test.IMyTest;

public class MyTestImplTest extends SpringTest {
	
	@Autowired
	IMyTest myTestimpl;

	@Test
	public void testAddSubject() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteSubject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetResponse() {
		String id = "2";
		Map<String, Object> result = myTestimpl.getResponse(id);
		
		String response = (String) result.get("response");
		String responseTime = (String) result.get("responsetime");
		
		System.out.println(result);
		System.out.println(response);
		System.out.println(responseTime);
		
		List<String> items = Arrays.asList(response.split("\\s*,\\s*"));
		List<String> time = Arrays.asList(responseTime.split(","));
		
		System.out.println(items);
		System.out.println(time);
		
	}

	@Test
	public void testGetResponse2() {
		String response = "  2     ,    8   , 8,2  ";
		String responseTime = "1.5, 3.4, 2.2, 0.8, 1.5";
		
		double aa = 1.2;
		
		List<Double> intList = new ArrayList<Double>();
		
		List<String> items = Arrays.asList(response.trim().split("\\s*,\\s*"));
		List<String> time =Arrays.asList(responseTime.trim().split("\\s*,\\s*"));
		
		List<String> answers = Arrays.asList("2", "8","2","2");
		
		List<Integer> score = new ArrayList<Integer>();
		int totalScore = 0;
		
		for (int i = 0; i< items.size(); i++) {
			
			if (items.get(i).equals(answers.get(i))) {
				score.add(1);
				
				totalScore += 1;
			} else {
				score.add(0);
			}
			
		}
		
		double total = 0;
		
		for(String s : time) {
			intList.add(Double.valueOf(s));
			
			total = total + Double.valueOf(s);
		}
		
		System.out.println(items);
		System.out.println(time);
		
		
		System.out.println(answers);
		
		System.out.println(intList);
		System.out.println(total);
		
		System.out.println(score);
		System.out.println(totalScore);
		
	}
	
}
