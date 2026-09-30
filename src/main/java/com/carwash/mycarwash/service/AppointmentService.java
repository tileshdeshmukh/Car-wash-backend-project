package com.carwash.mycarwash.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carwash.mycarwash.controller.AppointmentController;
import com.carwash.mycarwash.model.Appointment;
import com.carwash.mycarwash.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	public List<Appointment> getAppointments() {
		
		log.info("Executing Service: {}", getClass().getSimpleName());
		
		List<Appointment> list = appointmentRepository.findAll();
		return list;
	}

	public Appointment addAppointments(Appointment data ) {

		log.info("Executing Service: {}", getClass().getSimpleName());
		Appointment responsData = appointmentRepository.save(data);

	    return responsData;

	}
	
	public Appointment deleteApoointmentById(long id) {
		log.info("Executing Service: {}", getClass().getSimpleName());
		
		Appointment appointment = appointmentRepository.findById(id)
	            .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Appointment not found with id: " + id));
	            
	    appointmentRepository.delete(appointment);
	    return appointment;
	}

	public List<Appointment> getAppointmentsByUserId(Long uid) {
		// TODO Auto-generated method stub
		List<Appointment> responseData = appointmentRepository.findByUseridOrderByUpdatedAtDesc(uid);
	
		return responseData;
	}
	
	public List<Appointment> getAppointmentsByEmail(String email) {
		// TODO Auto-generated method stub
		List<Appointment> responseData = appointmentRepository.findByEmailOrderByUpdatedAtDesc(email);
		
		return responseData;
	}
	
	public Appointment getAppointmentByUserId(Long id) {
		log.info("Executing Service: {}", getClass().getSimpleName());
		
		Appointment appointment = appointmentRepository.findById(id)
	            .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Appointment not found with id: " + id));
	            
	    return appointment;
	}

}
