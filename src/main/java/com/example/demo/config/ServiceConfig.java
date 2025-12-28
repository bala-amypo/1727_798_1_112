package com.example.demo.config;

import com.example.demo.repository.AuditTrailRecordRepository;
import com.example.demo.service.AuditTrailService;
import com.example.demo.service.impl.AuditTrailServiceImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public AuditTrailService auditTrailService(
            AuditTrailRecordRepository auditTrailRecordRepository) {

        return new AuditTrailServiceImpl(auditTrailRecordRepository);
    }
}
