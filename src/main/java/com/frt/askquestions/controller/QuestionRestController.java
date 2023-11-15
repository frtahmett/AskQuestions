package com.frt.askquestions.controller;

import com.frt.askquestions.dto.QuestionDto;
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

    // Build Ask Question REST API
    @PostMapping
    public ResponseEntity<QuestionDto> askQuestion(@RequestBody QuestionDto questionDto) {

        QuestionDto savedQuestion = questionService.askQuestion(questionDto);

        return new ResponseEntity<>(savedQuestion, HttpStatus.CREATED);

    }

    // Build Get Question REST API
    @GetMapping("{id}")
    public ResponseEntity<QuestionDto> listQuestionDetails(@PathVariable("id") Long questionId) {

        QuestionDto questionDto = questionService.listQuestionDetails(questionId);

        return ResponseEntity.ok(questionDto);
    }

    // Build Get All Questions REST API
    @GetMapping
    public ResponseEntity<List<QuestionDto>> listQuestions() {

        List<QuestionDto> questionDtoList = questionService.listQuestions();

        return ResponseEntity.ok(questionDtoList);
    }

    // Build Answer Question REST API
    @PutMapping("{id}")
    public ResponseEntity<QuestionDto> answerQuestion(@PathVariable("id") Long questionId, @RequestBody QuestionDto answeredQuestion) {

        QuestionDto questionDto = questionService.answerQuestion(questionId, answeredQuestion);

        return ResponseEntity.ok(questionDto);
    }
}
