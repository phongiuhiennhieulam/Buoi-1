package com.example.Service;

import com.example.Model.Entity.Blog;
import com.example.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private BlogRepository repo;
    @Override
    public List<Blog> getAllBlog() {
        return repo.findAll();
    }

    @Override
    public List<Blog> getAllBlogByCategory(int id) {
        return repo.getBlogByCategory_Id(id);
    }

    @Override
    public void deleteBlog(int id) {
        repo.deleteById(id);
    }

    @Override
    public Blog editBlog(int id, Blog blog) {
        Blog blog1 = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog not exits " + id));
        if (blog1 != null) {
            blog1.setTitle(blog.getTitle());
            blog1.setCategory(blog.getCategory());
            blog1.setContent(blog.getContent());
            blog1.setCovers(blog.getCovers());
            return repo.save(blog1);
        }
        return null;

    }
    public Blog get(Integer id){
        Optional<Blog> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }

    @Override
    public Blog addBlog(Blog blog) {
        return repo.save(blog);
    }
}
