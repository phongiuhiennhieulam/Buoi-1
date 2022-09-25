package com.example.Model.Form;

import com.example.Model.Entity.Category;
import org.springframework.web.multipart.MultipartFile;

public class BlogForm {
    private int id;

    private String title;


    private String content;


    private Category category;


    private MultipartFile[] covers;

    public BlogForm(String title, String content, Category category, MultipartFile[] covers) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.covers = covers;
    }

    public BlogForm() {
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile[] getCovers() {
        return covers;
    }

    public void setCovers(MultipartFile[] covers) {
        this.covers = covers;
    }
}
