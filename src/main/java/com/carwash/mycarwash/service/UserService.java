package com.carwash.mycarwash.service;

import com.carwash.mycarwash.dto.LoginResponse;
import com.carwash.mycarwash.dto.UserResponse;
import com.carwash.mycarwash.model.User;
import com.carwash.mycarwash.repository.UserRepository;
import com.carwash.mycarwash.security.JwtService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private JwtService jwtService;
	
//	New syntax for Object creation (Autowired dependancy injetion )
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }
        // Hash password securely before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    
    public LoginResponse loginUser(String email, String Password) {
    	
    	User user = userRepository.findByEmail(email)
    	        .orElseThrow(() -> {
    	            log.warn("User not found with email: {}", email);
    	            return new UsernameNotFoundException("User not found");
    	        });
    	
    	if(!passwordEncoder.matches(Password, user.getPassword())) {
    		
    		throw new RuntimeException("Invalid email or password");
    	}
    	
    	String token = jwtService.generateToken(user.getEmail());
    	
    	return new LoginResponse(
                token,
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    	
    }

//    public User loginUser(String email, String password) {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new RuntimeException("User not found!"));
//        
//        if (!passwordEncoder.matches(password, user.getPassword())) {
//            throw new RuntimeException("Invalid credentials!");
//        }
//        return user;
//    }
    
    
    
    public List<UserResponse> getAllUsers(){
    	
    	List<User> usersData = userRepository.findAll();
    	
    	List<UserResponse> userResponseObj = new ArrayList<>();
		  
		for(User user : usersData ) {
			
			UserResponse response = new UserResponse();
			
			response.setId(user.getId());
			response.setName(user.getName());
			response.setMobile(user.getMobile());
			response.setEmail(user.getEmail());
			response.setMembership(user.getMembership());
			response.setCreatedAt(user.getCreatedAt());
			
			userResponseObj.add(response);
		}
		  
    	return userResponseObj;
    }
    
    public UserResponse getUserById(long id) {

//    	User user = userRepository.findById(id).get();
    	User user = userRepository.findById(id)
    	        .orElseThrow(() -> new RuntimeException("User not found"));
    	
    	UserResponse userResponseObj = new UserResponse();
    	
    	userResponseObj.setId(user.getId());
    	userResponseObj.setName(user.getName());
    	userResponseObj.setMobile(user.getMobile());
    	userResponseObj.setEmail(user.getEmail());
    	userResponseObj.setMembership(user.getMembership());
    	userResponseObj.setCreatedAt(user.getCreatedAt());
    	
    	return userResponseObj;
    }
}
