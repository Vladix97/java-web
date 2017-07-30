package com.bookhut.models.binding_models;

public class AddBookModel {

    private String title;

    private String author;

    private Integer pages;

    public AddBookModel(String title, String author, Integer pages) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
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
}
