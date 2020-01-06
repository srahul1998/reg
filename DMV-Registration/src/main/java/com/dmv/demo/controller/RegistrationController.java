package com.dmv.demo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmv.demo.entity.UserDetlsEntity;
import com.dmv.demo.repository.UserDetailsRepo;
import com.dmv.demo.responses.response.ResponseUtil;

@RestController
@RequestMapping(value = "/registration")
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class RegistrationController {
	
	private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private UserDetailsRepo detailsRepo;
	
	@Autowired
	private ResponseUtil responseUtil;
	
	
	/*
	 * This Method is for Putting  all user's details with all Questions&answers
	 */
	@PostMapping(value = "/create-user",consumes = "application/json")
	public ResponseEntity<?> userRegisrtation(@RequestBody UserDetlsEntity detlsEntity) {
		
		
		log.info("userRegisrtation Executed Sucessfully.....");
		
		return  responseUtil.successResponse(detailsRepo.save(detlsEntity));
	}

	@GetMapping(value = "uname/{uname}")
	public UserDetlsEntity getByname(@PathVariable("uname") String uname) {
		
		return detailsRepo.findByUname(uname);
	}
	
	/*
	 * @GetMapping(value = "uid/{uid}") public List<Integer>
	 * getByUid(@PathVariable("uid") Integer id) {
	 * log.info("Join Query Method with Uid_fk::::"+id); return
	 * detailsRepo.findqidByUid_fk(id); }
	 */
	
}
