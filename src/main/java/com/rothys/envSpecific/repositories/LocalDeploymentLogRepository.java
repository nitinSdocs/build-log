package com.rothys.envSpecific.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rothys.envSpecific.entity.LocalDeploymentLog;

@Repository
public interface LocalDeploymentLogRepository extends MongoRepository<LocalDeploymentLog, String> {
    // Custom query methods can be defined here
}
