package com.example.twittersignup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.twittersignup.authentication.TwitterAuthentication;

@RestController
public class AuthenticationController {

	@Autowired
	TwitterAuthentication twitterAuthentication;

	private static final Logger logger = LoggerFactory.getLogger(ApplicationController.class);

	@RequestMapping("/authenticate")
	public String authenticate(){
		String response = this.twitterAuthentication.authenticateApplication();
		logger.info("response is " + response);	
		return response;

	}
}
