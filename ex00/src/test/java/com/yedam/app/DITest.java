package com.yedam.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.java.Log;

@Log
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/*-context.xml")
public class DITest {
	//autowired가 di(dependency injection)
	@Autowired Employees emp;
	@Test
	public void test1() {
		//new 없이 Employee객체 가져오는 방법 -> bean 등록하기
		log.info(emp.getEmployeeId());
	}
}
