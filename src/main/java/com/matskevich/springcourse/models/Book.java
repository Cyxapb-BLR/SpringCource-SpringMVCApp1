package com.matskevich.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    private String title;
    @NotEmpty
    @Size(min = 2, max = 100, message = "Name should be between 2 and 100 characters")
    private String author;
    @Min(value = 1800, message = "Year should be greater than 1800")
    private String yearOfPublishing;

    public Book() {
    }

    public Book(String title, String author, String yearOfPublishing) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(String yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
