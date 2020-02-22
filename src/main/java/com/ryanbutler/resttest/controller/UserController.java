package com.ryanbutler.resttest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryanbutler.resttest.bean.Result;

@RestController
public class UserController {
	
	@RequestMapping("/")
	public String getMsg() {
		return "Hello world";
	}
	
	@RequestMapping("/result")
	public Result getResult() {
		return new Result(0);
	}
	
}