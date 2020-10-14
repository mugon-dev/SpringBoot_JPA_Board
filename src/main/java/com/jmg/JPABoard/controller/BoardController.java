package com.jmg.JPABoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping("/board")
public class BoardController {

	@GetMapping({"","/","/list"})
	public String list(Model model) {
		return "list";
	}
}
