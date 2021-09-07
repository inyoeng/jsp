package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.PageVO;
import com.yedam.app.board.service.EmployeeService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/employee/*")
@Log
public class EmployeeController {
   @Autowired EmployeeService empService;
   
   @GetMapping("/list")
   public void list(Model model, @ModelAttribute("cri") Criteria cri) {
     int total = empService.getCount(cri);
     model.addAttribute("list", empService.getEmp(cri));
     model.addAttribute("pageMaker", new PageVO(cri, total));
   }
}