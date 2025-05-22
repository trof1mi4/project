package com.urfu.project.model;

import lombok.Data;
import lombok.Getter;

@Data
public class Book {
    @Getter
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
