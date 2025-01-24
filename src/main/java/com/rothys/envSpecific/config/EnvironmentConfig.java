package com.rothys.envSpecific.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rothys.envSpecific.entity.DevDeploymentLog;
import com.rothys.envSpecific.entity.LocalDeploymentLog;
import com.rothys.envSpecific.service.DeploymentLogService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class EnvironmentConfig {
    private final DeploymentLogService service;

    @Bean
    @Profile("local")
    public LocalDeploymentLog localBuildTime(){
        return service.createLocalDeploymentLog();
        
    }
    
    @Bean
    @Profile("dev")
    public DevDeploymentLog devBuildTime(){
        return service.createDevDeploymentLog();
    }
}
