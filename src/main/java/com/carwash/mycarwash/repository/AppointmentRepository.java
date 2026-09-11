package com.carwash.mycarwash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carwash.mycarwash.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
	
	 List<Appointment> findByUseridOrderByUpdatedAtDesc(Long uid);
	 

}
