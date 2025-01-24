package com.rothys.envSpecific.entity;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "buildLog_Local")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalDeploymentLog {
    @Id
    private String id;
    private ZonedDateTime deploymentTime;
}
