package com.yedam.app;

public class BuilderTest {

	public static void main(String[] args) {
		
		//초기화 해주기
		Member member = Member.builder().id("aa").pw("gg").name("d").build();

	}

}
