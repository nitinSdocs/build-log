package com.rothys.envSpecific.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rothys.envSpecific.entity.DevDeploymentLog;



@Repository
public interface DevDeploymentLogRepository extends MongoRepository<DevDeploymentLog, String> {
    // Custom query methods can be defined here
}