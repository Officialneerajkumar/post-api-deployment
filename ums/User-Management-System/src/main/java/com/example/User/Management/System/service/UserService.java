package com.example.User.Management.System.service;

import com.example.User.Management.System.model.User;
import com.example.User.Management.System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void addUser(User user){
        userRepository.save(user);
    }

    public User getUser(int id){
        return userRepository.findById(id).get();// --> .get() is required becouse the findBYId fun is optional
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public void updateUser(User user,int id){
        User userObj = userRepository.findById(id).get();
        userObj.setUserId(user.getUserId());
        userObj.setUserName(user.getUserName());
        userObj.setDate(user.getDate());
        userObj.setEmail(user.getEmail());
        userObj.setTime(user.getTime());
        userObj.setPhoneNumber(user.getUserId());
        userObj.setDateOfBirth(user.getDateOfBirth());
        userObj.setEmail(user.getEmail());

        userRepository.save(userObj);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
