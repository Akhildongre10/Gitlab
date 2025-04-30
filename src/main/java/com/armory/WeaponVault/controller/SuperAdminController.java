package com.armory.WeaponVault.controller;

import com.armory.WeaponVault.entity.SuperAdmin;
import com.armory.WeaponVault.repository.SuperAdminRepository;
import com.armory.WeaponVault.security.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperAdminController {

    @Autowired
    private UserService userService;

//
//    // Handle GET request to show registration page or message (e.g., for UI or instructions)
//    @GetMapping("/login")
//    public ResponseEntity<String> showLogin() {
//        return ResponseEntity.ok("Login");
//    }

//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestBody SuperAdmin superAdmin) {
//        // Authenticate user with username and password
//        boolean isAuthenticated = userService.authenticate(superAdmin.getEmail(), superAdmin.getPassword());
//
//        if (isAuthenticated) {
//            return ResponseEntity.ok("User authenticated successfully");
//        } else {
//            // If authentication fails
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//        }
//    }

    @PostMapping("/register")
    public ResponseEntity<String> userRegister(@RequestBody SuperAdmin superAdmin) {

        if (userService.saveUser(superAdmin) != null) {
            return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Oops! User not registered", HttpStatus.OK);
        }
    }
}
