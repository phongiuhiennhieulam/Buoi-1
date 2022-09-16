package com.example.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;
    public List<Category> listAllCategory(){

        return (List<Category>) repo.findAll();
    }
    public Category getCategory(int id){

        return repo.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Not exist: " + id));
    }
}
