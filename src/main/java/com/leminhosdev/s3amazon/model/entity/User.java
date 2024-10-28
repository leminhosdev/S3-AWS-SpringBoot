package com.leminhosdev.s3amazon.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    private String profileImageUrl;

    public User(String name, String profileImageUrl) {

        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public User() {
    }
}
