package com.project.quizApp.controllers;

import com.project.quizApp.entities.Question;
import com.project.quizApp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    // Endpoint for adding a single question
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    // Endpoint for adding multiple questions
    @PostMapping("/multiple")
    public boolean addMultipleQuestions(@RequestBody List<Question> questions) {
        return questionService.addMultipleQuestions(questions);
    }

    // Endpoint for getting all questions
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    // Endpoint for getting questions by difficulty level
    @GetMapping("/Difficulty/{level}")
    public List<Question> getByDifficultyLevel(@PathVariable String level) {
        return questionService.getQuestionsByDifficultyLevel(level);
    }

    // Endpoint for delete question
    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable int id) {
        return questionService.deleteQ(id);
    }
}
