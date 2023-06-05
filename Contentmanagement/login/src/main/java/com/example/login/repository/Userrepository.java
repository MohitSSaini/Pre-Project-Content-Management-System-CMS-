package com.example.login.repository;

import com.example.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Userrepository extends JpaRepository<User,Integer> {
}
