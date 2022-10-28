package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;
    private String name;

    public Category() {}

    public Category(int categoryID, String name) {
        this.categoryID = categoryID;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Category {" +
                "categoryID = " + this.categoryID +
                ", name = '" + this.name + '\'' +
                '}';
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
