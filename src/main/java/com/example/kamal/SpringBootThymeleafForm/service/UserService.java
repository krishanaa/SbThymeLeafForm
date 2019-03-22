/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.kamal.SpringBootThymeleafForm.service;

import com.example.kamal.SpringBootThymeleafForm.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author kamal
 */
@Service
public class UserService {
    private List<User> userList=new ArrayList<>();
    public List<User> getAllUsers(){
        return userList;
    }
    public void addUser(User user){
        userList.add(user);
    }
    
    
}
