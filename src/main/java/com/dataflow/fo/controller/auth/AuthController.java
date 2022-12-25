package com.dataflow.fo.controller.auth;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dataflow.bo.beans.auth.Role;
import com.dataflow.bo.beans.auth.UserRole;
import com.dataflow.bo.beans.auth.Users;
import com.dataflow.bo.dao.auth.RoleDao;
import com.dataflow.bo.service.auth.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private RoleDao roleDao;
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@RequestMapping("/index")
    public String index() {
        return "index";
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model) {
        Users user = new Users();
        user.setFirstName("Issam");
        user.setLastName("Brayche");
        user.setPhone("0605994517");
        user.setEmail("issamebrayche@gmail.com");
        user.setUsername("issbr");
        user.setPassword("issbr");

        model.addAttribute("user", user);

        return "signup";
    }
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") Users user,  Model model) {

        if(userService.checkUserExists(user.getUsername(), user.getEmail()))  {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

            if (userService.checkUsernameExists(user.getUsername())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } else {
        	 Set<UserRole> userRoles = new HashSet<>();
        	 Role role = roleDao.findByName("ROLE_USER");
        	 if(role == null) {
        		 role = new Role();
        		 role.setName("ROLE_USER");
        		 role = roleDao.save(role);
        		 
        	 }
             userRoles.add(new UserRole(user, role));
             
            userService.createUser(user, userRoles);

            return "redirect:/";
        }
    }
	
	@RequestMapping("/userFront")
	public String userFront(Principal principal, Model model) {

        return "userFront";
    }
	
	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String profile(Principal principal, Model model) {
		Users user = userService.findByUsername(principal.getName());

		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.POST)
	public String profilePost(@ModelAttribute("user") Users newUser, Model model) {
		Users user = userService.findByUsername(newUser.getUsername());
		user.setUsername(newUser.getUsername());
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());

		model.addAttribute("user", user);

		userService.saveUser(user);

		return "profile";
	}

}
