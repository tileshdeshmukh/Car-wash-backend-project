package com.carwash.mycarwash.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carwash.mycarwash.model.Package;

public interface PackageRepository extends JpaRepository<Package, Long> {

}
