package gientech.spring.springbeanannotation.controller;

import gientech.spring.springbeanannotation.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("userController")
public class UserController{
    @Resource(name = "userService")
    private UserService userService;

    public void save(){
        userService.save();
    }
}
