package org.example;

public class Book extends Product {
    private String nameBook;
    private String author;

    public Book(int id, String title, int price, String nameBook, String author) {
        super(id, title, price);
        this.nameBook = nameBook;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }
}

