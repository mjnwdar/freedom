package cn.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.springmvc.model.User;
import cn.springmvc.service.UserService;
 
@Controller
@RequestMapping("/")
public class UserController {
 
	@Autowired
	private UserService userService;
	
    @RequestMapping("index")
    public String index(){
        return "index";
    }
    
    @RequestMapping("addUser")
    public int addUser(User user)
    {
    	int i = userService.insertUser(user);
    	return i;
    }
     
}
