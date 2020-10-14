package com.jmg.JPABoard.config;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jmg.JPABoard.config.args.ArgsNotFound;

public class ExceptionController {
	
	@ExceptionHandler(value = ArgsNotFound.class)
	public String 잘못된인수() {
		return "아규먼트 잘못들어왔어요";
	}

}
