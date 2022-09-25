package com.example.Service;

import com.example.Model.Entity.Blog;

import java.util.List;

public interface IBlogService {
    public List<Blog> getAllBlog();

    public List<Blog> getAllBlogByCategory(int id);

    public void deleteBlog(int id);

    public Blog editBlog(int id,Blog blog);

    public Blog addBlog(Blog blog);
    public Blog get(Integer id);

}
