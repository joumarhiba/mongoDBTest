package com.mongoDB.controller;

import com.mongoDB.model.Post;
import com.mongoDB.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class homeController {

    private final PostRepo postRepo;

    @ApiIgnore
    @GetMapping("/")
    public String home(HttpServletResponse response) throws IOException {
        return "heeeeeeeeeeeeeeeeeeey";
    }

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        return postRepo.save(post);
    }
}
