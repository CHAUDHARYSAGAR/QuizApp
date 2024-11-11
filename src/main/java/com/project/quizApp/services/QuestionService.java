package com.project.quizApp.services;

import com.project.quizApp.dao.QuestionDao;
import com.project.quizApp.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionDao questionDao;

    // --------------------------------- For single insertion -------------------------
    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        }
    }

    // -------------------------------- For multiple insertion -----------------------------------
    public boolean addMultipleQuestions(List<Question> questions) {
        boolean status = false;
        try {
            questionDao.saveAll(questions);
            status = true;
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return status;
    }

    // --------------------- For getting all the data ---------------------------------------------
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    //------------------- get questions based on difficulty Leve -------------------------------------
    public List<Question> getQuestionsByDifficultyLevel(String level) {
        return questionDao.findByDifficultyLevel(level);
    }

    public ResponseEntity<String> deleteQ(int id) {
        try{
            if (questionDao.existsById(id)){
                questionDao.deleteById(id);
                return new ResponseEntity<>("deleted", HttpStatus.OK);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("not found", HttpStatus.BAD_REQUEST);
    }
}
