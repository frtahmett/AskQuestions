package com.frt.askquestions.repository;


import com.frt.askquestions.dto.QuestionDto;
import com.frt.askquestions.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Long> {


    // Question saveQuestion();

    // Question getQuestion(Long id);

    // List<Questions> getQuestions();


}
