package com.mongoDB.repository;

import com.mongoDB.model.Post;

import java.util.List;

public interface ISearchRepo {
    List<Post> findBytext(String text);
}
