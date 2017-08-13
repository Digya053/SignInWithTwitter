package com.example.twittersignup.utils;

import java.io.IOException;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HTTPUtils {

	public static String sendGETRequest(String url){
		String response = null;
		HttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);

		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			HttpEntity httpEntity = httpResponse.getEntity();
			if(httpEntity != null){
				response = EntityUtils.toString(httpEntity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}

	public static String sendPostWithHeaders(String url, Map<String, String> headers){
		String response = null;
		HttpClient httpClient = HttpClients.createDefault();
		HttpRequest httpPost = new HttpPost(url);

		for(String header : headers.keySet()){
			httpPost.addHeader(header, headers.get(header));
		}

		try {
			HttpResponse httpResponse = httpClient.execute((HttpUriRequest) httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			if(httpEntity != null){
				response = EntityUtils.toString(httpEntity);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return response;
	}
}

