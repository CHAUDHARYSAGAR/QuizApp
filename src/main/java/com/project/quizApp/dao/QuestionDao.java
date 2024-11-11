package com.project.quizApp.dao;

import com.project.quizApp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByDifficultyLevel(String difficultyLevel);

    @Query(value = "SELECT * from question q where q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQByCategory(String category, int numQ);
}
