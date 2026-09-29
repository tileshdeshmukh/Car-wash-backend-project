package com.carwash.mycarwash.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.mycarwash.model.Package;
import com.carwash.mycarwash.service.PackageService;

@RestController
@RequestMapping("/packages")
@CrossOrigin(origins = "http://localhost:4200")
public class PackageController {

	@Autowired
	private PackageService packageService;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	@GetMapping("/getAllPackages")
	public ResponseEntity<List<Package>> getAll() {	
		try {
            log.info("Executing controller: {}", getClass().getSimpleName());
            List<Package> packages = packageService.getPackages();
            return ResponseEntity.ok(packages);
            
        } catch (Exception e) {
            log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

	}
	
	@PostMapping("/addPackages")
	public ResponseEntity<Package> add(@RequestBody Package data) { 
	    try {
	        log.info("Executing controller: {}", getClass().getSimpleName());
	        data.setCreatedAt(LocalDateTime.now());
	        Package packages = packageService.addPackage(data); 
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(packages);
	        
	    } catch (Exception e) {
	        log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
	
	@DeleteMapping("deletePackages/{id}")
	public ResponseEntity<Package> deleteApoointment(@PathVariable long id){
		try {
			
	        log.info("Executing controller: {}", getClass().getSimpleName());
	        
	        Package packages = packageService.deletePackageById(id);
	       
	        return ResponseEntity.ok(packages);
	        
		}catch (Exception e) {
			
			log.error("Error in controller: {} - {}", getClass().getSimpleName(), e.getMessage(), e);
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
