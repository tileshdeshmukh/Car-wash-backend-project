package com.carwash.mycarwash.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.carwash.mycarwash.model.Appointment;
import com.carwash.mycarwash.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	@GetMapping("/getAllAppointment")
	public ResponseEntity<List<Appointment>> getAll() {	
		try {
            log.info("Executing controller: {} getAll", getClass().getSimpleName());
            List<Appointment> appointments = appointmentService.getAppointments();
            return ResponseEntity.ok(appointments);
            
        } catch (Exception e) {
            log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

	}
	
	@GetMapping("/getAllAppointmentByUserId/{id}")
	public ResponseEntity<List<Appointment>> getAllByUserId(@PathVariable Long id ) {	
		try {
            log.info("Executing controller: {} getAllByUserId ID {}", getClass().getSimpleName(), id);
            List<Appointment> appointmentsData = appointmentService.getAppointmentsByUserId(id);
            
            if(appointmentsData.isEmpty()) {
            	return ResponseEntity.noContent().build();
            }
            
            return ResponseEntity.ok(appointmentsData);
            
        } catch (Exception e) {
            log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

	}
	
	@PostMapping("/addAppointment")
	public ResponseEntity<Appointment> add(@RequestBody Appointment data) { 
	    try {
	        log.info("Executing controller: {}", getClass().getSimpleName());
	        data.setCreatedAt(LocalDateTime.now());
	        // Status like "Confirmed" (initial state) || "Washing" : (working state) || "Ready" : (Washing completed) || Delivered : (Dispatched to User) 
	        data.setWashStatus("Confirmed");
	        Appointment appointment = appointmentService.addAppointments(data); 
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
	        
	    } catch (Exception e) {
	        log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@DeleteMapping("deleteAppointment/{id}")
	public ResponseEntity<Appointment> delete(@PathVariable long id){
		try {
			
	        log.info("Executing controller: {}", getClass().getSimpleName());
	        
	        Appointment appointment = appointmentService.deleteApoointmentById(id);
	       
	        return ResponseEntity.ok(appointment);
	        
		}catch (Exception e) {
			
			log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
}
