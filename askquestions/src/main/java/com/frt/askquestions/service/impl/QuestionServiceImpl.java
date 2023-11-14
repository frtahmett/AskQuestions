package com.frt.askquestions.service.impl;

import com.frt.askquestions.dto.QuestionDto;
import com.frt.askquestions.entity.Question;
import com.frt.askquestions.repository.QuestionRepository;
import com.frt.askquestions.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;


    @Override
    public QuestionDto askQuestion(QuestionDto questionDto) {

        // Convert QuestionDto into Question Jpa  Entity
        Question question = new Question();
        question.setLesson(questionDto.getLesson());
        question.setAskerStudentName(questionDto.getAskerStudentName());
        question.setAskerStudentSurname(questionDto.getAskerStudentSurname());
        question.setStatus(questionDto.getStatus());

        // Question Jpa Entity
        Question savedQuestion = questionRepository.save(question);

        //Convert saved Question Jpa entity object into QuestionDTO object
        QuestionDto savedQuestionDto = new QuestionDto();
        savedQuestionDto.setId(savedQuestion.getId());
        savedQuestionDto.setLesson(savedQuestion.getLesson());
        savedQuestionDto.setAskerStudentName(savedQuestion.getAskerStudentName());
        savedQuestionDto.setAskerStudentSurname(savedQuestion.getAskerStudentSurname());
        savedQuestionDto.setStatus(savedQuestion.getStatus());

        return savedQuestionDto;
    }

    @Override
    public QuestionDto listQuestionDetails(Long id) {

        Question getQuestion = questionRepository.findById(id).get();

        QuestionDto getQuestionDto = new QuestionDto();
        getQuestionDto.setId(getQuestion.getId());
        getQuestionDto.setLesson(getQuestion.getLesson());
        getQuestionDto.setAskerStudentName(getQuestion.getAskerStudentName());
        getQuestionDto.setAskerStudentSurname(getQuestion.getAskerStudentSurname());
        getQuestionDto.setStatus(getQuestion.getStatus());

        return getQuestionDto;
    }

    @Override
    public List<Question> listQuestions() {

//        List<Question> questions = questionRepository.findAll();


        return (List<Question>) questionRepository.findAll();
    }


}
