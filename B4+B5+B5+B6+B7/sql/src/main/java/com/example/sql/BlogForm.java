package com.example.sql;


import org.springframework.web.multipart.MultipartFile;

public class BlogForm{

    private int id;


    private String title;



    private String content;

    private MultipartFile[] file;
    private Category category;


    public BlogForm(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }

    public BlogForm(int id, String title, String content, MultipartFile[] file, Category category) {
        this.id = id;
        this.title = title;

        this.content = content;
        this.file = file;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

