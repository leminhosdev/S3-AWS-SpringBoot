package com.leminhosdev.s3amazon.repository;

import com.leminhosdev.s3amazon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
