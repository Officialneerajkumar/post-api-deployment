package com.example.Post.API.controller;

import com.example.Post.API.model.Post;
import com.example.Post.API.service.Service;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/post-api")
public class Controller {

    @Autowired
    private Service service;

    @PostMapping(value = "/add-post")
    public ResponseEntity<String> addPost(@RequestBody String postData){
        JSONObject requestJson = new JSONObject(postData);
        JSONObject errorList = isValidRequest(requestJson);

        if(errorList.isEmpty()){
            Post setObj = setPost(requestJson);
            int postId = service.savePost(setObj);
            return new ResponseEntity<>("saved post with id : "+postId,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(""+errorList, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-post")
    public ResponseEntity<String> getAllPost(){
        JSONArray response = service.findAllPost();
        return new ResponseEntity<>(response.toString(),HttpStatus.OK);
    }

    private Post setPost(JSONObject requestJson) {
        Post setObj = new Post();
        setObj.setTitle(requestJson.getString("title"));
        setObj.setDescription(requestJson.getString("description"));

        return setObj;
    }

    private JSONObject isValidRequest(JSONObject requestJson) {
        JSONObject errorList = new JSONObject();

        if(!requestJson.has("title")){
            errorList.put("title","missing parameter");
        }

        if(!requestJson.has("description")){
            errorList.put("description","missing parameter");
        }
        return errorList;
    }
}
