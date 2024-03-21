//package com.nischal.quizapp.model;
//
//import java.util.List;
//
//import org.hibernate.annotations.ManyToAny;
//import org.springframework.data.annotation.Id;
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Data
//public class Quiz {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY) 
//	  private Long id;
//	private String title;
//	
//	@ManyToMany
//	private List<Question> questions;
//
////	public void setQuestions(List<Question> questions2) {
////		this.questions = questions2;
////	}
////
////	public void setTitle(String title2) {
////		 this.title = title2;
////	}
//	
//}
