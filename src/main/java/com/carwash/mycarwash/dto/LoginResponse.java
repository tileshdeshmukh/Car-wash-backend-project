package com.carwash.mycarwash.dto;

public class LoginResponse {
	
	private String token;
    private String tokenType;
    private Long userId;
    private String email;
    private String name;
    
    
	public LoginResponse(String token, Long userId, String email, String name) {
		this.token = token;
		this.tokenType = "Bearer";
		this.userId = userId;
		this.email = email;
		this.name = name;
	}
	
	public String getToken() {
        return token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
    
    

}
