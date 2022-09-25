package com.example.Model.Form;

import com.example.Model.Entity.Blog;

public class CoverForm {
    private int id;

    private String name;

    private Blog blog;

    public CoverForm() {
    }

    public CoverForm(String name, Blog blog) {
        this.name = name;
        this.blog = blog;
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
