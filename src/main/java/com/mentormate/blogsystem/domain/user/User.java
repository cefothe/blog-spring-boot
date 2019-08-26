package com.mentormate.blogsystem.domain.user;

import com.mentormate.blogsystem.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String email;

    @ManyToMany
    private Set<Authority> authorities = new HashSet<>();

}
