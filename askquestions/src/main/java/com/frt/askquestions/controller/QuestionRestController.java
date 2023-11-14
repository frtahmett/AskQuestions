package com.frt.askquestions.controller;

import com.frt.askquestions.dto.QuestionDto;
import com.frt.askquestions.entity.Question;
import com.frt.askquestions.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/questions")
@AllArgsConstructor
public class QuestionRestController {

    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<QuestionDto> askQuestion(@RequestBody QuestionDto questionDto) {

        QuestionDto savedQuestion = questionService.askQuestion(questionDto);

        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);

    }

    @GetMapping("{id}")
    public ResponseEntity<QuestionDto> listQuestion(@PathVariable("id") Long questionId) {

        QuestionDto getQuestion = questionService.listQuestionDetails(questionId);

        return new ResponseEntity<>(getQuestion, HttpStatus.OK);
    }

    @GetMapping
    public List<Question> listQuestions() {
        return questionService.listQuestions();
    }
}
