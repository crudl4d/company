package com.company;

public class Book {
    private String name;
    private String author;
    public Book(String name, String author){
        this.name=name;
        this.author=author;
    }
    public String getName(){return this.name;}
    public String getAuthor(){return this.author;}
}
