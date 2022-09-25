package com.example.Service;

import com.example.Model.Entity.Category;

import java.util.List;

public interface ICategoryService {
    public List<Category> getAllCategory();
    public Category getCategory(int id);
}
