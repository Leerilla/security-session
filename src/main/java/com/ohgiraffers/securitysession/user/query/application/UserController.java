package com.ohgiraffers.securitysession.user.query.application;

import com.ohgiraffers.securitysession.auth.command.application.dto.AuthDetails;
import com.ohgiraffers.securitysession.user.query.domain.service.UserViewService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("/user")
public class UserController {

    private final UserViewService userViewService;

    public UserController(UserViewService userViewService) {
        this.userViewService = userViewService;
    }


    public AuthDetails findUser (String userId){
        AuthDetails auth = null; // userViewService.findUserId(userId);

        return auth;
    }
}
