package com.example.UnitedGroup.security.Repository;

import com.example.UnitedGroup.security.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users , Integer> {


        Optional <Users> findByUsername(String username);




}
