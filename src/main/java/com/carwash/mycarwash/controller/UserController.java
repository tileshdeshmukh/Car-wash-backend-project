package com.carwash.mycarwash.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.mycarwash.dto.UserResponse;
import com.carwash.mycarwash.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserResponse>> getAllUsers() {
		try {
			log.info("Executing controller: {} getAll", getClass().getSimpleName());
			  
			  List<UserResponse> userData = userService.getAllUsers();
			  
			  return ResponseEntity.ok(userData);
			  
		} catch (Exception e) {
            log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
		  
	}
	
	@GetMapping("/getUser/{id}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable long id){
		try {
			log.info("Executing controller: {} getAll", getClass().getSimpleName());
			
			UserResponse data = userService.getUserById(id);
			
			if(data != null) {
				return ResponseEntity.ok(data);
			}
			return ResponseEntity.notFound().build();
					
		}catch(Exception e) {
			log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

}
