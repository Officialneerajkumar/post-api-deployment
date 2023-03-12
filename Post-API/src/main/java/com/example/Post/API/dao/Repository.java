package com.example.Post.API.dao;

import com.example.Post.API.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Post,Integer> {

}
