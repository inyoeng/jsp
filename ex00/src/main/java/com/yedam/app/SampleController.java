package com.yedam.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;

//pojo : 상속 받을 필요가 없다. 
@Controller //-> @Component상속 받아서 만들 수 있는 3가지: @Controller, @Service, @Repository(=DAO)
@RequestMapping("/sample/*") //sample 실행ㅎ면 여기로 꼭 들어온다. 
@Log 
public class SampleController {
	
	//기존 컨트롤러에 ajax컨츠롤러에 있던거를 넣고싶다?!
	//@restController = controller + responseBody
	@RequestMapping("/ex09")
	@ResponseBody //자바객체를 ->json우로 
	public SampleVO ex07(SampleVO sample) {
		//SampleVO sample = new SampleVO();
		sample.setName("홍길동");
		sample.setAge(50);
		
		return sample;
	}

	//@RequestMapping(value = "/a" method=Requestmethod.Post)
	@GetMapping("/a")
	public String basic() {
		log.info("basic...");
		return "sample/basicA";
	}
	@RequestMapping("/b")
	public void basic2() {
		log.info("basic2...");
	}
	
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("sam") SampleVO vo, Model model) { //dto = vo =do
		log.info(""+vo.toString());
		//model.addAttribute("sampleVO", vo); samplevo는 자동으로 알아서 model에 들어감. 안해둬도 됑
		model.addAttribute("pageNo","10");
		return "sample/ex01";
	}
	@GetMapping("/ex02")
	public void ex02(@RequestParam(name="username") String name, 
					@RequestParam(required=false, defaultValue="10")  int age) { 
		//String name = request.getParameter("username");
		log.info("name = "+ name+"age = "+age);
	}
	
	@GetMapping("/ex03")
	public void ex03(@RequestParam String[] ids) {
		log.info(Arrays.toString(ids));
	}
	@GetMapping("/ex04")
	public void ex04(@RequestParam List<String> ids) {
		log.info(ids.toString());
	}
	@GetMapping("/ex05")
	public void ex05(SampleVoList list) {
		log.info(list.toString());
	}
	
	@GetMapping("/ex06/{name}/{age}")
	public void ex06(@PathVariable String name,
					@PathVariable int age) {
		log.info("name= "+name+", age = "+age);
	}
	

}
