package com.yedam.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//ajax의 어노테이션은 다름!
@RestController
public class AjaxController {
	@RequestMapping("/ex07")
	public SampleVO ex07(SampleVO sample) {
		//SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(50);
		
		return sample;
	}
	
	@RequestMapping("/ex08")
	public List<SampleVO> ex08() {
		List<SampleVO> list = new ArrayList<>();
		list.add(new SampleVO("choi", 10, new Date()));
		list.add(new SampleVO("kim", 17, new Date()));
		list.add(new SampleVO("jung", 20, new Date()));
		
		return list;
	}
}
