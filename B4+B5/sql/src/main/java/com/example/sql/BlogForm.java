package com.example.sql;




public class BlogForm{

    private int id;


    private String title;

    private String cover;

    private String content;

    private String file;

    public BlogForm(int id, String title, String cover, String content,String file) {
        this.id = id;
        this.title = title;
        this.cover = cover;
        this.content = content;
        this.file = file;
    }
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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

