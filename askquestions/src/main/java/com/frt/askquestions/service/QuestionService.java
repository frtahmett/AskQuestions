package com.frt.askquestions.service;

import com.frt.askquestions.dto.QuestionDto;
import com.frt.askquestions.entity.Question;

import java.util.List;

public interface QuestionService {

    QuestionDto askQuestion(QuestionDto questionDto);

    QuestionDto listQuestionDetails(Long id);

    List<Question> listQuestions();
}
