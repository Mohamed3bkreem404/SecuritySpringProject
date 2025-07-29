package com.example.UnitedGroup.security.Service;

import com.example.UnitedGroup.security.Model.Users;
import com.example.UnitedGroup.security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

        @Autowired
        private  UserRepository userRepository;

        private  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

        public Users register(Users user) {
             user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }
}
