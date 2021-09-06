package com.yedam.app.board.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.domain.BoardVO;

@Controller
public class BoardRestController {
	//vo로 리턴하나 map으로 리턴하나 같다. 
	
	@RequestMapping("test1")
	@ResponseBody
	public Map<String, Object> test1(@RequestParam String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		
		if(id.equals("admin")) {
			map.put("result", true);
		}
		else {
			map.put("result", false);
		}
			
		return map;
	}
	
	/*
	 * @RequestMapping(value= "test2", produces = {MediaType.APPLICATION_XML_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE})
	 * 
	 * @ResponseBody public BoardVO test2(BoardVO vo) { vo.setBno(10);
	 * vo.setContent("ddd"); vo.setRegdate(new Date());//예쁘게 바꿔주기 위해
	 * vo에서 @jsonFormat해주기 return vo; }
	 */
	
	@RequestMapping(value="test2")
	@ResponseBody
	public BoardVO test2(BoardVO vo) {
		vo.setBno(10);
		vo.setContent("ddd");
		vo.setRegdate(new Date());//예쁘게 바꿔주기 위해 vo에서 @jsonFormat해주기
	return vo;
}
}
