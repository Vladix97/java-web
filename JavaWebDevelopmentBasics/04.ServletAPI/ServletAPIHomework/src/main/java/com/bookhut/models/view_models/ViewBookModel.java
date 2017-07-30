package com.bookhut.models.view_models;

import java.util.Date;

public class ViewBookModel {

    private String title;

    private String author;

    private Integer pages;

    private Date creationDate;

    public ViewBookModel(String title, String author, Integer pages, Date creationDate) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
        this.setCreationDate(creationDate);
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
