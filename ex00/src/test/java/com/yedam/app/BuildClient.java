package com.yedam.app;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuildClient {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	@Test
	public void member() {
		Member member = Member.builder().id("11").build();
		//성공여부 확인
		assertEquals(member.getId(),"11");
	}

}
