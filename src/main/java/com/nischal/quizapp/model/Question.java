package com.nischal.quizapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Question {
	
	  	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    public Integer id;
	  	public String question_title;
	    public String option1;
	    public String option2;
	    public String option3;
	    public String option4;
	    public String right_answer;
	    public String difficultylevel;
	    public String category;
	    
	    public Integer getId() {
	        return id;
	    }

	    public String getQuestion_title() {
	        return question_title;
	    }
	    
	    public String getOption1() {
	        return option1;
	    }
	    
	    public String getOption2() {
	        return option2;
	    }
	    
	    public String getOption3() {
	        return option3;
	    }
	    
	    public String getOption4() {
	        return option4;
	    }
	    
	    public String getRight_answer() {
	        return right_answer;
	    }
	    
	    public String getDifficultylevel() {
	        return difficultylevel;
	    }
	    
	    public String getCategory() {
	        return category;
	    }
}
