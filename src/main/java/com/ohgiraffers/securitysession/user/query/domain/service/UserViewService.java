package com.ohgiraffers.securitysession.user.query.domain.service;

import com.ohgiraffers.securitysession.auth.command.application.dto.AuthDetails;
import com.ohgiraffers.securitysession.user.query.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserViewService {

    private final UserRepository userRepository;

    public UserViewService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public AuthDetails findUserId(String userId){
        AuthDetails auth = userRepository.findUser(userId);

        return auth;
    }
}
