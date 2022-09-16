package com.example.sql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoverRepository extends CrudRepository<Cover,Integer> {
    void deleteByBlog_Id(int id);
}
