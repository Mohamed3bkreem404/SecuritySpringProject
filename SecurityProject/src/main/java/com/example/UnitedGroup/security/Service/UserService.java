package com.example.UnitedGroup.security.Service;

import com.example.UnitedGroup.security.Model.Users;
import com.example.UnitedGroup.security.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

        @Autowired
        private  UserRepository userRepository;

        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        JWTService jwtService;

        private  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);

        public Users register(Users user) {
             user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        }

        public Optional<Users> getUser(String username){
            return userRepository.findByUsername(username);
        }

        public void removeUser(int id){
            userRepository.deleteById(id);
        }

        public List<Users> getAllUsers(){
            return userRepository.findAll();
        }

    public String verify(Users user) {
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        if (auth.isAuthenticated()) {
            return jwtService.generateToken(user.getUsername() , user.getPassword());
        } else {
            return "Fail";
        }
    }






}
