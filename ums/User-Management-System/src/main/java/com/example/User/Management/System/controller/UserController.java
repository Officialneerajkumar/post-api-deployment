package com.example.User.Management.System.controller;

import com.example.User.Management.System.model.User;
import com.example.User.Management.System.service.UserService;
import com.example.User.Management.System.util.UserValidator;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/ums")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody String requestUser){
        JSONObject json = new JSONObject(requestUser);
        List<String> validationList = userValidator.validateUser(json);

        if(validationList.isEmpty()){
            User user = userValidator.setUser(json);
            userService.addUser(user);
            return new ResponseEntity<>("User saved", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Please pass these mandatory parameters- " +
                    validationList, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUserById")
    public ResponseEntity<String> getUser(@RequestParam int userId){

        return new ResponseEntity<>(""+userService.getUser(userId),HttpStatus.OK); //userService.getUser(userId);
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
    @PutMapping("/updateUserInfo")
    public void updateUserInfo(@RequestBody User user ,int id){
        userService.updateUser(user,id);
    }

    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }

}
