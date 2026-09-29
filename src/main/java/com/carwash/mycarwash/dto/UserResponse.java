package com.carwash.mycarwash.dto;

import java.time.LocalDateTime;

public class UserResponse {
	
    private Long id;
    private String email;
    //private String password;
    private String name;
	private String mobile;
    private String membership;
    private LocalDateTime createdAt;
    
    
	public UserResponse(Long id, String email, String name, String mobile, String membership, LocalDateTime createdAt) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.mobile = mobile;
		this.membership = membership;
		this.createdAt = createdAt;
	}


	public UserResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getMembership() {
		return membership;
	}


	public void setMembership(String membership) {
		this.membership = membership;
	}


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	@Override
	public String toString() {
		return "UserResponse [id=" + id + ", email=" + email + ", name=" + name + ", mobile=" + mobile + ", membership="
				+ membership + ", createdAt=" + createdAt + "]";
	}
	
	

}
