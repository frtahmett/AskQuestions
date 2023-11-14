package com.frt.askquestions.dto;

import com.frt.askquestions.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {

    private Long id;
    private String lesson;
    private String askerStudentName;
    private String askerStudentSurname;
    private String answeringTeacherName;
    private String answeringTeacherSurname;
    private Status status;

}
