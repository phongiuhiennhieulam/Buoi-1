package com.example.Model.Form;

import javax.persistence.Column;

public class CategoryForm {
    private int id;


    private String name;


    private String description;

    public CategoryForm(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryForm() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
