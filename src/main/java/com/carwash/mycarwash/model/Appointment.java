package com.carwash.mycarwash.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "user_id")
	private Long userid;
	
	@Column(name = "name")
	private String name;

	@Column(name = "mobile_number")
	private Long mobileNumber;
	
	@Column(name= "email")
	private String email;
	
	@Column(name = "vehicle_type")
	private String vehicleType;
	
	@Column(name = "vehicle_brand")
	private String vehicleBrand;
	
	@Column(name = "vehicle_model")
	private String vehicleModel;
	
	@Column(name = "vehicle_color")
	private String vehicleColor;
	
	@Column(name = "vehicle_number")
	private String vehicleNumber;
	
	@Column(name = "plan_id")
	private Long planid; 
	
	@Column(name = "price")
	private Long price;
	
	@Column(name = "wash_status")
	private String washStatus; 
	
	@Column(name = "appointment_date")
    private LocalDate date;
	
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

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public Long getPlan() {
		return planid;
	}

	public void setPlan(Long planid) {
		this.planid = planid;
	}
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}
	
	public String getWashStatus() {
		return washStatus;
	}

	public void setWashStatus(String washStatus) {
		this.washStatus = washStatus;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
// Getter and Setter for updated_at
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

	public Appointment(		
		    Long id,
		    Long userid,
		    String name,
		    String email,
		    Long mobileNumber,
		    String vehicleType,
		    String vehicleBrand,
		    String vehicleModel,
		    String vehicleColor,
		    String vehicleNumber,
		    Long planid,
		    Long price,
		    String washStatus,
		    LocalDate date,
		    LocalDateTime updatedAt,
		    LocalDateTime createdAt) {
		
		super();
		this.id = id;
		this.userid = userid;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.vehicleType = vehicleType;
		this.vehicleBrand = vehicleBrand;
		this.vehicleModel = vehicleModel;
		this.vehicleColor = vehicleColor;
		this.vehicleNumber = vehicleNumber;
		this.planid = planid;
		this.price = price;
		this.washStatus = washStatus;
		this.date = date;
		this.updatedAt = updatedAt;
		this.createdAt = createdAt;
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", userid=" + userid + ", name="+ name +", email="+ email +", mobileNumber="+ mobileNumber +", vehicleType=" + vehicleType + ", vehicleBrand="
				+ vehicleBrand + ", vehicleModel=" + vehicleModel + ", vehicleColor=" + vehicleColor
				+ ", vehicleNumber=" + vehicleNumber + ", plan=" + planid + ", price="+ price +", washStatus="+ washStatus +", date=" + date + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt
				+ "]";
	}
	

}
