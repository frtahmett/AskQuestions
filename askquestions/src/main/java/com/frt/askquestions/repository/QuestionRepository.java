package com.frt.askquestions.repository;


import com.frt.askquestions.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {


    // List<Question> saveQuestion();

    // List<Question> getQuestion(Long id);

}
