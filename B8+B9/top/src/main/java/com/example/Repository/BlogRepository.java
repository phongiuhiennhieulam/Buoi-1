package com.example.Repository;

import com.example.Model.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Integer> {
    public List<Blog> getBlogByCategory_Id(int id);
}
