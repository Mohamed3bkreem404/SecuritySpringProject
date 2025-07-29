package com.example.UnitedGroup.security.Controller;

import com.example.UnitedGroup.security.Model.Users;
import com.example.UnitedGroup.security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

        @Autowired
        private  UserService userService;


        @PostMapping("/register")
        public Users register(@RequestBody Users user){
            return userService.register(user);
        }
}
