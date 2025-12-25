package com.example.demo.service;

import com.example.demo.entity.VerificationRequest;
import java.util.List;

public interface VerificationRequestService {

    VerificationRequest create(VerificationRequest request);

    List<VerificationRequest> getAll();

    List<VerificationRequest> getByCredentialId(Long credentialId);
}
