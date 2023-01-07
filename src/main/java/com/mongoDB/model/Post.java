package com.mongoDB.model;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "JobPost")

public class Post {
    private String desc;
    private String profile;
    private int exp;
    private List tech;
}
