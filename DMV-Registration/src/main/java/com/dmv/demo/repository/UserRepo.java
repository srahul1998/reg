package com.dmv.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmv.demo.entity.UserRoles;

@Repository
public interface UserRepo extends JpaRepository<UserRoles, Integer>{

}
