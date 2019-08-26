package com.mentormate.blogsystem.domain.blog;

import com.mentormate.blogsystem.domain.BaseEntity;
import com.mentormate.blogsystem.domain.user.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
public class Blog extends BaseEntity {

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private User createdBy;

    @OneToMany
    private Set<Comment> comments = new HashSet<>();

}
