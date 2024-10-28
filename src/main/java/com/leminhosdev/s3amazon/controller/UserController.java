package com.leminhosdev.s3amazon.controller;


import com.leminhosdev.s3amazon.model.dto.UserRequest;
import com.leminhosdev.s3amazon.model.entity.User;
import com.leminhosdev.s3amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> saveUser(@ModelAttribute UserRequest userRequest) {

       String profileImageUrl =  userService.saveUser(userRequest);
       return ResponseEntity.ok(profileImageUrl);
    }
}
