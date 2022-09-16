package com.example.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoverService {
    @Autowired
    CoverRepository repo;
    public void save(Cover cover) {
        repo.save(cover);
    }
    public void deleteBy(int id){
        repo.deleteById(id);
    }
}
