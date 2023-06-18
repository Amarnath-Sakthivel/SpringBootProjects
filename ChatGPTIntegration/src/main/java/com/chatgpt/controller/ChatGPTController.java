package com.chatgpt.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatgpt.model.ChatGPTRequest;
import com.chatgpt.model.ChatGPTResponse;
import com.chatgpt.service.ChatGPTService;

/**
 * 
 * @author Amarnath Sakthivel
 *
 */

@RestController
@RequestMapping("/openai")
public class ChatGPTController {

	@Autowired
	private ChatGPTService chatGPTService;

	@PostMapping("/")
	public ResponseEntity<ChatGPTResponse> getChoices(@RequestBody ChatGPTRequest chatGPTRequest) throws JSONException {
		return new ResponseEntity<>(chatGPTService.getChoicesFromChatGPT(chatGPTRequest.getPrompt()), HttpStatus.OK);
	}
}
