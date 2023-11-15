package com.frt.askquestions.dto;

import com.frt.askquestions.entity.Question;

public class DTOConverter {

    public static QuestionDto convertQuestionEntityToDto(Question question) {
        return new QuestionDto(
                question.getId(),
                question.getLesson(),
                question.getAskerStudentName(),
                question.getAskerStudentSurname(),
                question.getAnsweringTeacherName(),
                question.getAnsweringTeacherSurname(),
                question.getStatus()
        );
    }

    public static Question convertQuestionDTOToEntity(QuestionDto questionDto) {
        return new Question(
                questionDto.getId(),
                questionDto.getLesson(),
                questionDto.getAskerStudentName(),
                questionDto.getAskerStudentSurname(),
                questionDto.getAnsweringTeacherName(),
                questionDto.getAnsweringTeacherSurname(),
                questionDto.getStatus()
        );
    }
}
