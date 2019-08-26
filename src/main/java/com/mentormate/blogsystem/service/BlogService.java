package com.mentormate.blogsystem.service;

import com.mentormate.blogsystem.domain.blog.Blog;
import com.mentormate.blogsystem.repository.BlogRepository;
import com.mentormate.blogsystem.service.dto.BlogDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final ModelMapper modelMapper;

    public BlogService(BlogRepository blogRepository, ModelMapper modelMapper) {
        this.blogRepository = blogRepository;
        this.modelMapper = modelMapper;
    }

    public BlogDTO create(BlogDTO blogDTO){
        var entity = modelMapper.map(blogDTO, Blog.class);
        return modelMapper.map(blogRepository.save(entity), BlogDTO.class);
    }

    public List<BlogDTO> getAll() {
        var blogs = blogRepository.findAll();
        return blogs.stream()
                .map(blog -> modelMapper.map(blog, BlogDTO.class))
                .collect(Collectors.toList());
    }
}
