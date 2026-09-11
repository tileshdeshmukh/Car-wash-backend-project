package com.carwash.mycarwash.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.carwash.mycarwash.controller.AppointmentController;
import com.carwash.mycarwash.model.Package;
import com.carwash.mycarwash.repository.PackageRepository;

@Service
public class PackageService {
	
	@Autowired
	PackageRepository packageRepository;
	
	private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);
	
	public List<Package> getPackages() {
		
		log.info("Executing Service: {}", getClass().getSimpleName());
		
		List<Package> list = packageRepository.findAll();
		return list;
	}

	public Package addPackage(Package data ) {

		log.info("Executing Service: {}", getClass().getSimpleName());
		Package responsData = packageRepository.save(data);
	
	    return responsData;
		
		
	}
	
	public Package deletePackageById(long id) {
		log.info("Executing Service: {}", getClass().getSimpleName());
		
		Package packageData = packageRepository.findById(id)
	            .orElseThrow(() -> new jakarta.persistence.EntityNotFoundException("Packages not found with id: " + id));
	            
		packageRepository.delete(packageData);
	    return packageData;
	}

}
