package com.example.sql;
import com.example.sql.Blog;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "Cover")
public class Cover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToOne
    private Blog blog;

    public Cover(String name, Blog blog) {
        this.name = name;
        this.blog = blog;
    }

    public Cover() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}