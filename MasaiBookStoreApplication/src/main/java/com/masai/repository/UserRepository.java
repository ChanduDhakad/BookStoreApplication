package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

   public Optional<User> findByMobileNumber(String mobileNumber);
   Optional<User>  findByEmail(String email);
  
}
