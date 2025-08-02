package com.example.UnitedGroup.security.Controller;

import com.example.UnitedGroup.security.Model.Users;
import com.example.UnitedGroup.security.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class UserController {

        @Autowired
        private  UserService userService;


        @PostMapping("/login")
        public String login(@RequestBody Users user){

                return userService.verify(user);
        }


        @PostMapping("/register")
        public Users register(@RequestBody Users user){
            return userService.register(user);
        }


        @PostMapping("/removeUser")
        public void removeUser(@RequestParam int id){
                 userService.removeUser(id);
        }

        @GetMapping("/getUserByName")
        public Optional<Users> getUser(@RequestParam String username){
                return userService.getUser(username);
        }

        @GetMapping("/getAllUsers")
        public List<Users> getAllUsers(){
                return userService.getAllUsers();
        }
}
