package com.jmg.JPABoard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jmg.JPABoard.config.args.ArgsNotFound;
import com.jmg.JPABoard.dto.BoardSaveRequestDto;
import com.jmg.JPABoard.service.BoardService;

@Controller
//@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	//메인페이지 + 리스트
	@GetMapping({"","/","/list"})
	public String list(Model model, @PageableDefault(size = 5, sort = "id", direction = Direction.DESC)Pageable pageable) {
		model.addAttribute("boards", boardService.boardListPaging(pageable));
		return "list";
	}
	
	//save페이지
	@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm";
	}
	
	//데이터입력
	@PostMapping("/save")
	public String save(BoardSaveRequestDto dto) {
		boardService.boardWrite(dto);
		return "redirect:/list";
	}
	
	//글 하나보기
	@GetMapping("/board/{id}")
	public String detail(@PathVariable int id, Model model) throws ArgsNotFound {
		model.addAttribute("board", boardService.boardRead(id));
		return "detail";
	}
	
	//글 하나 삭제
	@DeleteMapping("/board/{id}")
	@ResponseBody
	public String delete(@PathVariable int id) {
		boardService.boardDelete(id);
		return "ok";
	}
	
	//글 수정
	@PutMapping("/board/{id}")
	@ResponseBody
	public String update(@PathVariable int id, @RequestBody BoardSaveRequestDto dto) {
		boardService.boardUpdate(id, dto);
		return "ok";
	}
	
}
