package com.example.twittersignup.authentication;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.twittersignup.utils.HTTPUtils;

@Component
public class TwitterAuthenticationHelper {

	@Value("${oauth.consumerKey}")
	private String consumerKey;

	@Value("${oauth.token}")
	private String token;

	@Value("${oauth.signatureMethod}")
	private String signatureMethod;

	@Value("${oauth.timeStamp}")
	private String timeStamp;

	@Value("${oauth.nonce}")
	private String nonce;

	@Value("${oauth.version}")
	private String version;

	@Value("${oauth.signature}")
	private String signature;

	@Value("${oauth.refreshTokenUrl}")
	private String refreshTokenUrl;

	public String getRequestToken(){
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Authorization", "OAuth "
				+ "oauth_consumer_key="+consumerKey
				+ ",oauth_token="+token
				+ ",oauth_signature_method="+signatureMethod
				+ ",oauth_timestamp="+timeStamp
				+ ",oauth_nonce="+nonce
				+ ",oauth_version="+version
				+ ",oauth_signature="+signature);

		String response = HTTPUtils.sendPostWithHeaders(refreshTokenUrl, headers);
		return response;
	}


	public String parseResponse(String response){
		String[] individualFields = response.split("&");
		String oauthToken = individualFields[0].split("=")[1];
		return oauthToken;
	}
}
