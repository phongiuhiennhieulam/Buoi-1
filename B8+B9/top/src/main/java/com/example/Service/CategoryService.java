package com.example.Service;

import com.example.Model.Entity.Category;
import com.example.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private CategoryRepository repo;
    @Override
    public List<Category> getAllCategory() {
        return repo.findAll();
    }

    @Override
    public Category getCategory(int id) {
        return repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Not exist: " + id));
    }
}
