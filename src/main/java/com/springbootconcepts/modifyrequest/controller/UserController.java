package com.springbootconcepts.modifyrequest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootconcepts.modifyrequest.doain.User;
import com.springbootconcepts.modifyrequest.emailvalidation.EmailValidation;

@RestController
@RequestMapping("/")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping(value = "save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        logger.info("save user info into database");
        
        String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        System.out.println(user.getEmail());
        System.out.println(EmailValidation.patternMatches(user.getEmail(), regexPattern));
        if ( ! EmailValidation.patternMatches(user.getEmail(), regexPattern) ) {
        	return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
        }
        ResponseEntity<User> responseEntity = new ResponseEntity<>(user, HttpStatus.CREATED);
        return responseEntity;
    }
}