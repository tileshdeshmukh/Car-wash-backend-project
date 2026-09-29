package com.carwash.mycarwash.controller;

import com.carwash.mycarwash.dto.LoginRequest;
import com.carwash.mycarwash.dto.LoginResponse;
import com.carwash.mycarwash.model.User;
import com.carwash.mycarwash.repository.UserRepository;
import com.carwash.mycarwash.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
    private UserService userService;

//    public AuthController(UserService userService) {
//        this.userService = userService;
//    }
    
    @Autowired
    UserRepository userRepository;
    

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.registerUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getMessage()));
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
//        try {
//            
//        	User user = userService.loginUser(credentials.get("email"), credentials.get("password"));
//            
//            // Return user summary details to client browser session state storage 
//            return ResponseEntity.ok(Map.of(
//                "userId", user.getId(),
//                "name", user.getName(),
//                "email", user.getEmail()
//            ));
//        } catch (Exception e) {
//            return ResponseEntity.status(401).body(Map.of("message", e.getMessage()));
//        }
//    }

    
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
    	
    	System.out.println("Controller run :==================================");
    	System.out.println("Request Data :"+ request);
    	
        LoginResponse response = userService.loginUser(request.getEmail(), request.getPassword());

        return ResponseEntity.ok(response);
    }
}
