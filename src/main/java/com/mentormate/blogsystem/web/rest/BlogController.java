package com.mentormate.blogsystem.web.rest;


import com.mentormate.blogsystem.service.BlogService;
import com.mentormate.blogsystem.service.dto.BlogDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/blog")
@RestController
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping
    public BlogDTO createBlog(@RequestBody BlogDTO request){
        return blogService.create(request);
    }

    @GetMapping
    public List<BlogDTO> getAll(){
        return blogService.getAll();
    }
}
