package com.MulitThreading.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.MulitThreading.entity.Vendor;

@Repository
public interface VendorRepository extends MongoRepository<Vendor, String> {
	
}