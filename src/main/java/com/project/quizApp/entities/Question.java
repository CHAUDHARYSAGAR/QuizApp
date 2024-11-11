package com.project.quizApp.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String questionTitle;
    @Column
    private String option1;
    @Column
    private String option2;
    @Column
    private String option3;
    @Column
    private String option4;
    @Column
    private String rightAnswer;
    @Column
    private String difficultyLevel;
    @Column
    private String category;
}
