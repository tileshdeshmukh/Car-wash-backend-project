package com.carwash.mycarwash.model;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="package")
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cost", nullable = false)
	private Long cost;
	
	@Column(name = "updated_at", nullable = true)
	private LocalDateTime updatedAt;
	
	@Column(name = "created_at", nullable = false, updatable = true)
	private LocalDateTime createdAt;
	
	
	@PrePersist
	protected void onCreate() {
		LocalDateTime now = LocalDateTime.now();
		if (this.createdAt == null) {
			this.createdAt = now;
		}
		// When creating a record, updated_at should match created_at initially
		if (this.updatedAt == null) {
			this.updatedAt = now;
		}
	}
	
	//2. Added @PreUpdate hook to refresh timestamp automatically on changes
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCost() {
		return cost;
	}

	public void setCost(Long cost) {
		this.cost = cost;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Package(Long id, String name, Long cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Packages [id=" + id + ", name=" + name + ", cost=" + cost + ", updatedAt="+ updatedAt +", createdAt="+ createdAt +"]";
	}
	
	

}
