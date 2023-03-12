package com.example.Post.API.service;

import com.example.Post.API.dao.Repository;
import com.example.Post.API.model.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Repository repository;

    public int savePost(Post setObj) {
        Post postObj = repository.save(setObj);
        return postObj.getPostId();
    }

    public JSONArray findAllPost() {
        List<Post> postList = repository.findAll();
        JSONArray response = new JSONArray();
        for(Post posts : postList){
            JSONObject post = new JSONObject();
            post.put("postId",posts.getPostId());
            post.put("title",posts.getTitle());
            post.put("description",posts.getDescription());
            response.put(post);
        }
        return response;
    }
}
