package com.example.UnitedGroup.security.Repository;

import com.example.UnitedGroup.security.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

        Users findByUsername(String username);
}
