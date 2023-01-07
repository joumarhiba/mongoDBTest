package com.mongoDB.repository;

import com.mongoDB.model.Post;
import com.mongodb.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import java.util.Arrays;
import org.bson.Document;
import org.bson.conversions.Bson;
import java.util.concurrent.TimeUnit;
import org.bson.Document;

@Repository
public class SearchRepo implements ISearchRepo{
    @Autowired
    MongoClient mongoClient;
    @Autowired
    MongoConverter mongoConverter;
    @Override
    public List<Post> findBytext(String text) {
        List<Post> posts =new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("testMongoDB");
        MongoCollection<Document> collection = database.getCollection("JobPost");

        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search", new Document("text",
                                new Document("query", text)
                                .append("path", Arrays.asList("profile", "desc", "tech")))),
                                 new Document("$sort",
                                 new Document("exp", 1L))));
        result.forEach(doc -> posts.add(mongoConverter.read(Post.class,doc)));

        return posts;
    }
}
