package com.chatgpt.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGPTResponse {

	private List<Choice> choices;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Choice {

		private String key;
		private int index;
	}

}
