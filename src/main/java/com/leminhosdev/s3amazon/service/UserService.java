package com.leminhosdev.s3amazon.service;

import com.leminhosdev.s3amazon.model.dto.UserRequest;
import com.leminhosdev.s3amazon.model.entity.User;
import com.leminhosdev.s3amazon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StorageFileService storageFIleService;

    public String saveUser(UserRequest userRequest) {


        String profileImageUrl = storageFIleService.uploadFile(
                userRequest.profileImageFile(),
                userRequest.name(),
                "profileImage");

        User user = new User(userRequest.name(),profileImageUrl);

        userRepository.save(user);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("user Name: " + userRequest.name());
        stringBuilder.append("user profile: " + profileImageUrl);


        return stringBuilder.toString();
    }
}
