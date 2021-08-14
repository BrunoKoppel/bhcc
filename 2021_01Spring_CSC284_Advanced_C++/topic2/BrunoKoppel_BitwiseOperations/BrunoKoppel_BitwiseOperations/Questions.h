#pragma once
#include <string>

struct Questions {
	int questionId;
	std::string prompt;
	bool response;

	Questions() {
		this->prompt = "";
		this->questionId = 0;
		this->response = 0;
	};

	Questions(std::string newPrompt, int questionId, bool response) {
		this->prompt = newPrompt;
		this->questionId = questionId;
		this->response = response;
	};
	
	Questions(std::string newPrompt, int questionId) {
		this->prompt = newPrompt;
		this->questionId = questionId;
		this->response = 0;
	};

	void setResponse(bool response) {
		this->response = response;
	}
};