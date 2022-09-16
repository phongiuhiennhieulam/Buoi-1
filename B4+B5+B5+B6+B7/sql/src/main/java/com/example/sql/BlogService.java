package com.example.sql;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.example.sql.Blog;
import com.example.sql.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService{
    @Autowired
    private BlogRepository repo;
    public List<Blog> listAll(){
        System.out.println("service");
        System.out.println(repo.findAll());
        return (List<Blog>) repo.findAll();
    }
    public List<Blog> listAllFilter(int id){
        return repo.getBlogByCategory_Id(id);
    }


    public void save(Blog blog) {
        repo.save(blog);
    }

    public Blog saveAndReturn(Blog blog) {
        return repo.save(blog);
    }

    public Blog get(Integer id){
        Optional<Blog> result = repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        return null;
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }
    public Blog update(int id, Blog blog) {
        Blog blog1 = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Blog not exits " + id));
        if (blog1 != null) {
            blog1.setTitle(blog.getTitle());
            blog1.setCategory(blog.getCategory());
            blog1.setContent(blog.getContent());
            blog1.setFile(blog.getFile());
            return repo.save(blog1);
        }
        return null;
    }


}
