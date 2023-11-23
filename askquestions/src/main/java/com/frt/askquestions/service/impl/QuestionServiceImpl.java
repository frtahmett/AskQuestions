package com.frt.askquestions.service.impl;

import com.frt.askquestions.Exception.ResourceNotFoundException;
import com.frt.askquestions.dto.DTOConverter;
import com.frt.askquestions.dto.QuestionDto;
import com.frt.askquestions.entity.Question;
import com.frt.askquestions.enums.Status;
import com.frt.askquestions.repository.QuestionRepository;
import com.frt.askquestions.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;


    public QuestionDto askQuestion(QuestionDto questionDto) {
        Question question = DTOConverter.convertQuestionDTOToEntity(questionDto);
        question.setStatus(Status.ASKED);

        Question savedQuestion = questionRepository.save(question);

        return DTOConverter.convertQuestionEntityToDto(savedQuestion);

    }

    @Override
    public QuestionDto listQuestionDetails(Long questionId) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question isn't exists with given id : " + questionId));

        return DTOConverter.convertQuestionEntityToDto(question);
    }

    @Override
    public List<QuestionDto> listQuestions() {

        List<Question> questions = questionRepository.findAll();

        return questions.stream().map(DTOConverter::convertQuestionEntityToDto)
              .collect(Collectors.toList());
    }

    @Override
    public QuestionDto answerQuestion(Long questionId, QuestionDto answeredQuestion) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question isn't exists with given id : " + questionId));

        if(question.getStatus() == Status.ASKED){
            question.setAnsweringTeacherName(answeredQuestion.getAnsweringTeacherName());
            question.setAnsweringTeacherSurname(answeredQuestion.getAnsweringTeacherSurname());
            question.setStatus(Status.SOLVED);
        }
        else {
            throw new ResourceNotFoundException("Status isn't correct with given question : " + questionId);
        }



        Question answeredQuestionObj = questionRepository.save(question);


        return DTOConverter.convertQuestionEntityToDto(answeredQuestionObj);
    }

}
