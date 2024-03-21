package com.nischal.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nischal.quizapp.dao.QuestionDao;
import com.nischal.quizapp.model.Question;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	  public ResponseEntity<List<Question>> getAllQuestions() {
	        try {
	        	List<Question> questions = questionDao.findAll();
	        	if(questions == null || questions.isEmpty()) {
	        		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.NOT_FOUND);
	        	}else {	        		
	        		return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
	        	}
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	    }	
	   
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			List<Question> questions = questionDao.findByCategory(category);
			if(questions == null || questions.isEmpty()) {
	                return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
	    	}else {	   
	    		return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
	    	}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		  return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("success",HttpStatus.CREATED);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Something is worng",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestionById(Integer id) {
		 try {
	            if (!questionDao.existsById(id)) {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
	            }
	            questionDao.deleteById(id);
	            return ResponseEntity.ok("Question deleted successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
	        }
	}

	
	@Transactional
    public ResponseEntity<String> updateQuestion(Question question) {
        try {
            Integer id = question.getId();
            if (id == null || !questionDao.existsById(id)) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
            }
            
            questionDao.updateQuestionById(id, question.getQuestion_title(), question.getOption1(), question.getOption2(), question.getOption3(), question.getOption4(), question.getRight_answer(), question.getDifficultylevel(), question.getCategory());
            return ResponseEntity.ok("Question updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }
}
