package com.yedam.app.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.domain.BoardVO;
import com.yedam.app.board.domain.Criteria;
import com.yedam.app.board.domain.PageVO;
import com.yedam.app.board.service.BoardService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/board/*")
@Log
//@SessionAttributes("cri")
public class BoardController {
	// boardController는 boardService에 의존적
	@Autowired
	BoardService boardService;

	// 조회는 get, 등록,수정은post
	// 전체조회
	@GetMapping("/list")
	public void list(Model model, @ModelAttribute("cri")  Criteria cri) {
		System.out.println("cri===" + cri);
		// 전체 건수 구하기
		int total = boardService.getTotalCount(cri);
		model.addAttribute("list", boardService.getList(cri));
		model.addAttribute("pageMaker", new PageVO(cri, total));
	}

	// 단건조회(수정페이지로..?)
	// bno 파라미터 넘겨줘서 -> 파라미터를 담는 command객체에서 결과 return -> model에 담아서 viewpage에 전달.
	// get.jsp만들어주기
	@GetMapping("/get")
	public void get(Model model, BoardVO board, @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("board", boardService.read(board));
	}

	// 등록페이지로 s
	@GetMapping("/register")
	public void registerForm() {

	}

	// 등록 처리
	@PostMapping("/register")
	public String register(BoardVO vo, RedirectAttributes rttr) {
		boardService.insert(vo);
		rttr.addFlashAttribute("result", vo.getBno());
		return "redirect:/board/list"; // 파라미터 전달이 되지 않는 redirect
	}

	// 수정 페이지
	@GetMapping("/update")
	public void modify(Model model, BoardVO board, @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("board", boardService.read(board));
	}

	// 수정 처리
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {

		int result = boardService.update(vo);
		log.info(cri.toString());
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		// rttr.addFlashAttribute("result", vo.getBno());

		/*
		 * rttr.addFlashAttribute("pageNum", cri.getPageNum());
		 * rttr.addFlashAttribute("amount", cri.getAmount());
		 */

		
		  rttr.addAttribute("pageNum", cri.getPageNum()); 
		  rttr.addAttribute("amount", cri.getAmount());
		 
		return "redirect:/board/list"; // 파라미터 전달이 되지 않는 redirect ?pageNum=" + cri.getPageNum() + "&amount=" +
										// cri.getAmount()
	}

	// 삭제 처리
	@PostMapping("/delete")
	public String delete(BoardVO vo, RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {

		int result = boardService.delete(vo);
		log.info(vo.toString());
		if (result == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addFlashAttribute("result", vo.getBno());
		/*
		 * rttr.addFlashAttribute("pageNum", cri.getPageNum());
		 * rttr.addFlashAttribute("amount", cri.getAmount());
		 */

		rttr.addFlashAttribute(cri);
		/*
		 * rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
		 * cri.getAmount());
		 */
		//cri를 session 안에 담았기 때문에 필요없땅
		return "redirect:/board/list"; // 파라미터 전달이 되지 않는 redirect
	}
}
