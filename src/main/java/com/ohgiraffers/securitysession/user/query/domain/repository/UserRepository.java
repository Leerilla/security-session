package com.ohgiraffers.securitysession.user.query.domain.repository;


import com.ohgiraffers.securitysession.auth.command.application.dto.AuthDetails;
import com.ohgiraffers.securitysession.auth.command.domain.aggregate.vo.UserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Mapper 매퍼가 되어야 함

@Component
public class UserRepository {

    private final PasswordEncoder passwordEncoder;

    public UserRepository(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public AuthDetails findUser(String userId){
        AuthDetails authDetails = null;

        if(userId.equals("user@gmail.com")){
            String pass = passwordEncoder.encode("pass");
            authDetails = new AuthDetails(1, "user@gmail.com", pass, UserRole.USER);
        }

        return authDetails;
    }
}
