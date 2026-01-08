package com.gil.skillhubapi.service;

import com.gil.skillhubapi.entity.LoginHistory;
import com.gil.skillhubapi.repository.LoginHistoryRepository;
import com.gil.skillhubapi.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    public void save(CustomUserDetails user, String token) {
        LoginHistory history = new LoginHistory();
        history.setUserId(user.getId());
        history.setEmail(user.getEmail());
        history.setAccessToken( token );
        loginHistoryRepository.save( history );
    }
}
