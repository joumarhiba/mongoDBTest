package com.mongoDB.controller;

import com.mongoDB.model.Post;
import com.mongoDB.repository.PostRepo;
import com.mongoDB.repository.SearchRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class homeController {

    private final PostRepo postRepo;
    private final SearchRepo searchRepo;

    @ApiIgnore
    @GetMapping("/")
    public String home(HttpServletResponse response) throws IOException {
        return "heeeeeeeeeeeeeeeeeeey";
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postRepo.findAll();
    }


    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text) {
        return searchRepo.findBytext(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return postRepo.save(post);
    }
}
