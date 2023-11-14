package com.frt.askquestions.entity;

import com.frt.askquestions.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String lesson;

    @Column(name = "student_name", nullable = false)
    private String askerStudentName;

    @Column(name = "student_surname", nullable = false)
    private String askerStudentSurname;

    @Column(name = "teacher_name")
    private String answeringTeacherName;

    @Column(name = "teacher_surname")
    private String answeringTeacherSurname;

    private Status status;

}
