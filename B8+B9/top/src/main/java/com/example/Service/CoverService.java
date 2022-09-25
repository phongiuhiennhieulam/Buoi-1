package com.example.Service;

import com.example.Model.Entity.Cover;
import com.example.Repository.CoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverService implements ICoverService{
    @Autowired
    private CoverRepository repo;
    @Override
    public void deleteServiceByBlogID(int id) {
        repo.deleteById(id);
    }



    @Override
    public void save(Cover cover) {
        repo.save(cover);
    }
}
