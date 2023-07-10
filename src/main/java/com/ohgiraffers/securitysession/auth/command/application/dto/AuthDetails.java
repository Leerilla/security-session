package com.ohgiraffers.securitysession.auth.command.application.dto;


import com.ohgiraffers.securitysession.auth.command.domain.aggregate.vo.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class AuthDetails implements UserDetails {

    private int userCode;
    private String userId;
    private String userPass;
    private UserRole role;

    public AuthDetails(int userCode, String userId, String userPass, UserRole role) {
        this.userCode = userCode;
        this.userId = userId;
        this.userPass = userPass;
        this.role = role;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if(this.role.getValue().length() > 0){
            List<String> authList = Arrays.asList(this.role.getValue().split(","));
            for (String auth: authList) {
                authorities.add(new SimpleGrantedAuthority(auth));
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.userPass;
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

