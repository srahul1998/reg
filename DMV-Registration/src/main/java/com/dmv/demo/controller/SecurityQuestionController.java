package com.dmv.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.demo.entity.SecurityQuestionsEntity;
import com.dmv.demo.repository.QuestionMasterRepo;
import com.dmv.demo.repository.SecurityQuestionAndAnswerRepo;
import com.dmv.demo.responses.response.ResponseUtil;

@RestController
@RequestMapping(value = "/securityquestions")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class SecurityQuestionController {

	/*
	 * 
	 */
	private static final Logger logs = LoggerFactory.getLogger(SecurityQuestionController.class);

	/*
	 * Injecting QuestionMasterRepo Repository for curd operation......
	 */
	@Autowired
	private QuestionMasterRepo QMrepo;
	/*
	 * Injecting SecurityQuestionAndAnswerRepo Repository for getting answer by qid
	 * operation......
	 */
	@Autowired
	private SecurityQuestionAndAnswerRepo qarepo;

	/*
	 * Injecting ResponseUtil Repository for sending response .....
	 */
	@Autowired
	private ResponseUtil responseUtil;

	/*
	 * This Method is for Getting All Questions
	 */

	@GetMapping(value = "/get-all")
	public ResponseEntity<?> GetAllQuestions() {

		ArrayList<SecurityQuestionsEntity> entity1 = (ArrayList<SecurityQuestionsEntity>) QMrepo.findAll();
		logs.info("GetAllQuestions method executed with ::" + entity1);
		return responseUtil.successResponse(entity1);

	}

	/*
	 * This Method is for Getting Question By Id
	 */

	@GetMapping(value = "/Question/{qid}")
	public String GetQuestionByQID(@PathVariable("qid") Integer qid) {

		Optional<SecurityQuestionsEntity> OptSqe = QMrepo.findById(qid);
		logs.info("GetQuestionByQID method executed with ::" + OptSqe.get());

		if (OptSqe.isPresent()) {

			SecurityQuestionsEntity entity = OptSqe.get();

			return entity.getQuestion();
		}

		else {
			return "Exception::" + new Exception("Questions Are Not Avalable");
		}
	}

	@GetMapping(value = "/findAnswerbyId/{qid}")
	public String findanswerbyId(@PathVariable("qid") Integer qid) {

		logs.info("findanswerbyId method called");

		return qarepo.findAnswerbyId(qid);
	}

}
