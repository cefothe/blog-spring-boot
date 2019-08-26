package com.mentormate.blogsystem.domain.blog;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Comment {
    private String title;
    private String content;
}
