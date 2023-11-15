package com.frt.askquestions.service;

import com.frt.askquestions.dto.QuestionDto;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    QuestionDto askQuestion(QuestionDto questionDto);

    QuestionDto listQuestionDetails(Long questionId);

    List<QuestionDto> listQuestions();
}
