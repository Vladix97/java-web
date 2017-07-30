package com.bookhut.entities;

import java.util.Date;

public class Book {

    private Long id;

    private String title;

    private String author;

    private Integer pages;

    private Date creationDate;

    public Book() {
        super();
    }

    public Book(String title, String author, Integer pages) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);

        this.setCreationDate(new Date());
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return this.pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
