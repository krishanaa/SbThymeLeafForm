/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kamal.SpringBootThymeleafForm.controller;

import com.example.kamal.SpringBootThymeleafForm.model.User;
import com.example.kamal.SpringBootThymeleafForm.service.UserService;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kamal
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    
    private UserService userService;
    
    @GetMapping(value = "/createuser")
    public ModelAndView createUserView(){
        ModelAndView modelAndView=new ModelAndView("createuser");
        modelAndView.addObject("user",new User());
        modelAndView.addObject("allProfiles",getProfiles());
        return modelAndView;
    }
    
    @PostMapping("/createuser")
    public ModelAndView createUser(@Valid User user, BindingResult result){
    ModelAndView modelAndView= new ModelAndView();
    if(result.hasErrors()){
    modelAndView.setViewName("createuser");
    modelAndView.addObject("user", user);
    modelAndView.addObject("allProfiles", getProfiles());
    return modelAndView;
    }
    userService.addUser(user);
    modelAndView.addObject("allUsers",userService.getAllUsers());
    modelAndView.setViewName("userinfo");
    logger.info("Form submitted successfully.");
    return modelAndView; 
    
    }
    
    private List<String> getProfiles(){
        List<String> list= new ArrayList<>();
        list.add("Associate");
        list.add("AVP");
        list.add("VP");
        list.add("Director");
        return list;
        
    }
    
    
}
