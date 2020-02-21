package com.example.demo.repository;

import com.example.demo.entity.Welcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WelcomeRepository extends JpaRepository<Welcome,Long> {

}
