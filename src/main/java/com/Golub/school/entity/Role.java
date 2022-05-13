package com.Golub.school.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    user,admin,mentor;

    @Override
    public String getAuthority() {
        return name();
    }
}
