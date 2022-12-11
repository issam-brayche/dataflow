package com.dataflow.bo.dao.auth;

import org.springframework.data.repository.CrudRepository;

import com.dataflow.bo.beans.auth.Role;

public interface RoleDao extends CrudRepository<Role, Integer>{
	Role findByName(String name);
}
