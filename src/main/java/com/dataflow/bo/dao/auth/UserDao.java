package com.dataflow.bo.dao.auth;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dataflow.bo.beans.auth.Users;

public interface UserDao extends CrudRepository<Users, Long> {
	Users findByUsername(String username);
    Users findByEmail(String email);
    Users findByuserId(Long id);
    List<Users> findAll();

}
