package com.example.twittersignup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

	@RequestMapping("/application")
	public String test(){
		return "application";
	}

}
