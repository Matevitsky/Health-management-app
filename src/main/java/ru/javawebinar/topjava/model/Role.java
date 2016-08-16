package ru.javawebinar.topjava.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Sergey on 30.06.16.
 */


public enum Role implements GrantedAuthority {

    ROLE_USER,

    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
