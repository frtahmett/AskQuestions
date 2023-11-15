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

        Question savedQuestion = questionRepository.save(question);
        question.setStatus(Status.ASKED);

        return DTOConverter.convertQuestionEntityToDto(savedQuestion);

    }

    @Override
    public QuestionDto listQuestionDetails(Long questionId) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Question isn't exist with given id : " + questionId));

        return DTOConverter.convertQuestionEntityToDto(question);
    }

    @Override
    public List<QuestionDto> listQuestions() {

        List<Question> questions = questionRepository.findAll();

        return questions.stream().map(DTOConverter::convertQuestionEntityToDto)
              .collect(Collectors.toList());
    }


}
