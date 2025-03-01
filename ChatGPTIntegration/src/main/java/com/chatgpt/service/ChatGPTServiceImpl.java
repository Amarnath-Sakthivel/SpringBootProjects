package com.chatgpt.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import com.chatgpt.model.ChatGPTResponse;
import com.chatgpt.model.ChatGPTResponse.Choice;

@Service
public class ChatGPTServiceImpl implements ChatGPTService {

	@Value("${CHATGPT_MODEL}")
	private String model;

	@Value("${CHATGPT_MAX_TOKEN}")
	private Integer max_token;

	@Value("${CHATGPT_URL}")
	private String openai_url;

	@Value("${CHATGPT_OPENAI_API_KEY}")
	private String openai_api_key;

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ChatGPTResponse getChoicesFromChatGPT(String prompt) throws JSONException, HttpServerErrorException, HttpClientErrorException {

		ChatGPTResponse response = new ChatGPTResponse();

		List<Choice> choicesList = new ArrayList<>();

		// CHAT_GPT request
		JSONObject chatGPTRequest = new JSONObject();
		chatGPTRequest.put("model", model);
		chatGPTRequest.put("prompt", prompt);
		chatGPTRequest.put("max_tokens", max_token);

		// SET HTTP_HEADERS
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(openai_api_key);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(chatGPTRequest.toString(), headers);

		ResponseEntity<String> chatGPTResponse = restTemplate.exchange(openai_url, HttpMethod.POST, entity,
				String.class);

		JSONObject parseResponse = new JSONObject(chatGPTResponse.getBody());

		JSONArray choices = parseResponse.getJSONArray("choices");

		
		//iterate choices from openai response
		for (int i = 0; i < choices.length(); i++) {

			String choice = choices.getJSONObject(i).getString("text");

			int index = choices.getJSONObject(i).getInt("index");

			choicesList.add(new Choice(choice, index));

		}

		response.setChoices(choicesList);

		return response;

	}

}
