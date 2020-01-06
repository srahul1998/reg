package com.dmv.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmv.demo.entity.UserDetlsEntity;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetlsEntity, Integer>{
	
	UserDetlsEntity findByUname(String uname);
	    
	/*
	 * @Query( value =
	 * "select q.qid  from SecurityQuestionAndAnswerEntity q inner join user_dtls u on u.uid=q.uid_fk where q.uid_fk=:id"
	 * ) List<Integer> findqidByUid_fk(@Param("id") Integer id);
	 */
	
}
