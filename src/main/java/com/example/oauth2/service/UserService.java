package com.example.oauth2.service;

import com.example.oauth2.domain.AppUser;
import com.example.oauth2.domain.Role;
import com.example.oauth2.domain.RoleToUserForm;

import java.util.List;

public interface UserService {
    AppUser saveUser(AppUser user);
    Role saveRole(Role role);
    void addRoleToUser(RoleToUserForm form);
    AppUser getUser(String username);
    List<AppUser> getUsers();
}
