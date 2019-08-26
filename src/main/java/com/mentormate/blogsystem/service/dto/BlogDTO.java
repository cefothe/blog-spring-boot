package com.mentormate.blogsystem.service.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class BlogDTO {
    private Long id;
    private String title;
    private String content;
    private Set<CommentDTO> comments = new HashSet<>();

}
