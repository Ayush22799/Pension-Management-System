package com.PMS.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PMS.authorization.model.User;


 // Repository for User

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
