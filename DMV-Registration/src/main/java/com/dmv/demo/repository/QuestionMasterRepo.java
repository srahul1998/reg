package com.dmv.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dmv.demo.entity.SecurityQuestionsEntity;

public interface QuestionMasterRepo extends JpaRepository<SecurityQuestionsEntity, Integer> {

}
