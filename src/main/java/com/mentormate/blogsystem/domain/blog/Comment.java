package com.mentormate.blogsystem.domain.blog;

import com.mentormate.blogsystem.domain.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Comment extends BaseEntity {
    private String title;
    private String content;
}
