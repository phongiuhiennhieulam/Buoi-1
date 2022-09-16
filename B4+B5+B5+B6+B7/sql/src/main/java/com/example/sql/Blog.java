package com.example.sql;

import com.example.sql.Category;
import com.example.sql.Cover;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Blog")
@Getter
@Setter
public class Blog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column

    private String title;
    @Column
    private String content;
    @ManyToOne
    private Category category;
    @JsonIgnore
    @OneToMany(mappedBy = "blog")
    private List<Cover> file;

    public Blog( String title, String content, Category category) {

        this.title = title;
        this.content = content;
        this.category = category;
    }

    public Blog() {
    }
}