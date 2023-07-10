package com.ohgiraffers.securitysession.auth.command.application.service;

import com.ohgiraffers.securitysession.auth.command.application.dto.AuthDetails;
import com.ohgiraffers.securitysession.user.query.application.UserController;
import com.ohgiraffers.securitysession.user.query.domain.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
public class AuthenticationService implements UserDetailsService {

    private final UserController userController;
    private final UserRepository userRepository;

    public AuthenticationService(UserController userController, UserRepository userRepository) {
        this.userController = userController;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthDetails auth = userRepository.findUser(username);
        if(Objects.isNull(auth)){
            throw new UsernameNotFoundException("회원 정보가 없습니다.");
        }

        return auth;
    }
}
