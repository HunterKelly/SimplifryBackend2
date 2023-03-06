package com.Simplifry.repository;

import com.Simplifry.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <Users, Long>{
    boolean existsByUsername(String username);
    Users findByEmail(String email);

}
