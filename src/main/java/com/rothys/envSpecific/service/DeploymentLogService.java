// filepath: /D:/OneDrive - SmartDocs/Desktop/Programming/EnvSpecificBean/envSpecific/src/main/java/com/rothys/envSpecific/service/DeploymentLogService.java
package com.rothys.envSpecific.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

import com.rothys.envSpecific.entity.DevDeploymentLog;
import com.rothys.envSpecific.entity.LocalDeploymentLog;
import com.rothys.envSpecific.repositories.DevDeploymentLogRepository;
import com.rothys.envSpecific.repositories.LocalDeploymentLogRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeploymentLogService {
    private final LocalDeploymentLogRepository localRepo;
    private final DevDeploymentLogRepository devRepo;

    public LocalDeploymentLog createLocalDeploymentLog() {
        LocalDeploymentLog buildTimeLog = new LocalDeploymentLog();
        buildTimeLog.setDeploymentTime(ZonedDateTime.now());
        log.info("Local build: {}", buildTimeLog);
        return localRepo.save(buildTimeLog);
    }

    public DevDeploymentLog createDevDeploymentLog() {
        DevDeploymentLog buildTimeLog = new DevDeploymentLog();
        buildTimeLog.setDeploymentTime(ZonedDateTime.now());
        log.info("Dev build: {}", buildTimeLog);
        return devRepo.save(buildTimeLog);
    }
}