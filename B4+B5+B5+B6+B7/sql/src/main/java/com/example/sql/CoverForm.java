package com.example.sql;
import com.example.sql.Blog;
import lombok.Data;

import javax.persistence.*;



public class CoverForm {

    private Long id;
    private String name;

    private Blog blog;
}