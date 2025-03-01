package com.chatgpt.service;

import org.json.JSONException;

import com.chatgpt.model.ChatGPTResponse;

public interface ChatGPTService {
	
	ChatGPTResponse getChoicesFromChatGPT(String prompt) throws JSONException;

}
