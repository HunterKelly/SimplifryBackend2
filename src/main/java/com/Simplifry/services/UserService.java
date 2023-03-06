package com.Simplifry.services;

import com.Simplifry.entities.Users;

public interface UserService {
    boolean existsByUsername(String username);
    void save(Users user);


    Users findUserByEmail(String email);
}
