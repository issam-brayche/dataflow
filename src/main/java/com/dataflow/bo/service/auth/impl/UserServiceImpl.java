package com.dataflow.bo.service.auth.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dataflow.bo.beans.auth.Role;
import com.dataflow.bo.beans.auth.UserRole;
import com.dataflow.bo.beans.auth.Users;
import com.dataflow.bo.dao.auth.RoleDao;
import com.dataflow.bo.dao.auth.UserDao;
import com.dataflow.bo.service.auth.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
	
	public void save(Users user) {
        userDao.save(user);
    }
	
	public Users findByuserId(Long id) {
        return userDao.findByuserId(id);
    }

    public Users findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public Users findByEmail(String email) {
        return userDao.findByEmail(email);
    }
    
    
    public Users createUser(Users user, Set<UserRole> userRoles) {
        Users localUser = userDao.findByUsername(user.getUsername());

        if (localUser != null) {
            LOG.info("User with username {} already exist. Nothing will be done. ", user.getUsername());
        } else {
            String encryptedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encryptedPassword);

            for (UserRole ur : userRoles) {
                roleDao.save(ur.getRole());
            }

            user.getUserRoles().addAll(userRoles);

            

            localUser = userDao.save(user);
        }

        return localUser;
    }
    
    public boolean checkUserExists(String username, String email){
        if (checkUsernameExists(username) || checkEmailExists(username)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUsernameExists(String username) {
        if (null != findByUsername(username)) {
            return true;
        }

        return false;
    }
    
    public boolean checkEmailExists(String email) {
        if (null != findByEmail(email)) {
            return true;
        }

        return false;
    }

    public Users saveUser (Users user) {
        return userDao.save(user);
    }
    
    public List<Users> findUserList() {
        return userDao.findAll();
    }

    public void enableUser (String username) {
        Users user = findByUsername(username);
        user.setEnabled(true);
        userDao.save(user);
    }

    public void disableUser (String username) {
        Users user = findByUsername(username);
        user.setEnabled(false);
        System.out.println(user.isEnabled());
        userDao.save(user);
        System.out.println(username + " is disabled.");
    }

	@Override
	public void createTestUser() {
		Users user = new Users();
		user.setFirstName("Issam");
		user.setLastName("Brayche");
		user.setPhone("0605994517");
		user.setEmail("issamebrayche@gmail.com");
		user.setUsername("issbr");
		user.setPassword("issbr");

		Set<UserRole> userRoles = new HashSet<>();
		Role role = roleDao.findByName("ROLE_USER");
		if (role == null) {
			role = new Role();
			role.setName("ROLE_USER");
			role = roleDao.save(role);
		}
		userRoles.add(new UserRole(user, role));

		createUser(user, userRoles);
		
	}

}
