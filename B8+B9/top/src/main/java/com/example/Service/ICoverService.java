package com.example.Service;

import com.example.Model.Entity.Cover;

public interface ICoverService {
    public void deleteServiceByBlogID(int id);
    public void save(Cover cover);
}
