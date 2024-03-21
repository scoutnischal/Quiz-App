package com.nischal.quizapp.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nischal.quizapp.model.Question;

import jakarta.transaction.Transactional;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
	List<Question> findByCategory(String category);
	  @Query(value = "SELECT * FROM question q Where q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
	  List<Question> findRandomQuestionsByCategory(String category, int numQ);
	
	  @Transactional
	  @Modifying
	  @Query("UPDATE Question q SET q.question_title = :question_title, q.option1 = :option1, q.option2 = :option2, q.option3 = :option3, q.option4 = :option4, q.right_answer = :right_answer, q.difficultylevel = :difficultyLevel, q.category = :category WHERE q.id = :id")
	  void updateQuestionById(@Param("id") Integer id, @Param("question_title") String question_title, @Param("option1") String option1, @Param("option2") String option2, @Param("option3") String option3, @Param("option4") String option4, @Param("right_answer") String rightAnswer, @Param("difficultyLevel") String difficultyLevel, @Param("category") String category);

}
