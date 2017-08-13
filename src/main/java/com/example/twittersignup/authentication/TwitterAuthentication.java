package com.example.twittersignup.authentication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.twittersignup.utils.HTTPUtils;

@Service
public class TwitterAuthentication {

	private static final Logger logger = LoggerFactory.getLogger(TwitterAuthentication.class);

	@Autowired
	private TwitterAuthenticationHelper twitterAuthenticationHelper;

	@Value("${oauth.authenticationUrl}")
	private String authenticationUrl;

	public String authenticateApplication(){
		String getRequestToken = this.twitterAuthenticationHelper.getRequestToken();
		String oauthToken = this.twitterAuthenticationHelper.parseResponse(getRequestToken);
		logger.info("Found oauth token..");
		logger.info("Authenticating application..");
		String url = authenticationUrl + "?oauth_token="+oauthToken;
		String response = HTTPUtils.sendGETRequest(url);
		return response;
	}


}
