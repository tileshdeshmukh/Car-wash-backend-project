package com.carwash.mycarwash.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;
    
    private String name;
	private String mobile;
    private String membership = "Gold Member";

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", mobile="
				+ mobile + ", membership=" + membership + ", createdAt=" + createdAt + "]";
	}

	public User(Long id, String email, String password, String name, String mobile, String membership,
			LocalDateTime createdAt) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.mobile = mobile;
		this.membership = membership;
		this.createdAt = createdAt;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
