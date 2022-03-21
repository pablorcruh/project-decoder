package com.ead.authuser.services;

import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UtilService {

    String createUrl(UUID userId, Pageable pageable);
}
