package com.Simplifry.serviceImpl;

import com.Simplifry.entities.Users;
import com.Simplifry.repository.UserRepository;
import com.Simplifry.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }


    @Override
    public void save(Users user) {
        userRepository.save(user);
    }

@Override
    public Users findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
