package com.mentormate.blogsystem.repository;

import com.mentormate.blogsystem.domain.blog.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Long> {
}
