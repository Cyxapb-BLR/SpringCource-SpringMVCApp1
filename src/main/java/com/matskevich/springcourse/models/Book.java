package com.matskevich.springcourse.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Title should not be empty")
    @Size(min = 2, max = 100, message = "Title should be between 2 and 100 characters")
    @Column(name = "title")
    private String title;

    @NotEmpty(message = "Author should not be empty")
    @Size(min = 2, max = 60, message = "Author should be between 2 and 60 characters")
    @Column(name = "author")
    private String author;

    @Min(value = 1500, message = "Year of publishing should be greater than 1500")
    @Column(name = "year_of_publishing")
    private int yearOfPublishing;

    public Book() {
    }

    public Book(String title, String author, int yearOfPublishing) {
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

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }
}
