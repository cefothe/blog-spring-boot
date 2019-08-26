package com.mentormate.blogsystem.web.rest;


import com.mentormate.blogsystem.service.dto.BlogDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/blog")
@RestController
public class BlogController {


    @PostMapping
    public void createBlog(@RequestBody BlogDTO request){

    }
}
