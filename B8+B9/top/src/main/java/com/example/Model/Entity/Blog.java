package com.example.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name ="category_id")
    private Category category;


    @OneToMany(mappedBy = "blog")
    private Set<Cover> covers;

    @Transient
    private List<MultipartFile> files;

    public Blog() {
    }

    public Blog(String title, String content, Category category, Set<Cover> covers) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.covers = covers;
    }

    public Blog(String title, String content, Category category) {
        this.title = title;
        this.content = content;
        this.category = category;
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

    public Set<Cover> getCovers() {
        return covers;
    }

    public void setCovers(Set<Cover> covers) {
        this.covers = covers;
    }
}
