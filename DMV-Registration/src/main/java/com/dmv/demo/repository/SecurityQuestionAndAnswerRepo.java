package com.dmv.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dmv.demo.entity.SecurityQuestionAndAnswerEntity;

@Repository
public interface SecurityQuestionAndAnswerRepo extends JpaRepository<SecurityQuestionAndAnswerEntity, Integer>{

	
       // public void saveAllQuestion(Set<SecurityQuestionEntity> entities);
	/*
	 * @Query(
	 * value="select qid from salesmanager.security_questions_and_answers where uid_fk=:uid"
	 * ) List<Integer> findByuid(@Param("uid") Integer uid);
	 */
	
	//@Query(value = "")
	// public String findAnswerByqid();
	
	
	@Query(value ="select answer from SecurityQuestionAndAnswerEntity where qid=:qid " )
    public String findAnswerbyId(@Param("qid") Integer qid) ; 
	
	
}
