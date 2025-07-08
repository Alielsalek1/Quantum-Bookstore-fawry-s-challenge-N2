package models;

import abstractions.Book;

public class ReferenceBook extends Book {

    public ReferenceBook(String ISBN, String title, int yearPublished, double price) {
        super(ISBN, title, yearPublished, price);
    }

}
