package models;

import abstractions.Book;
import abstractions.Buyable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Inventory {
    private Map<String, Book> books;

    public Inventory() {
        this.books = new HashMap<>();
    }

    public void removeOutdatedBooks(int currentYear, int maxAge) {
        Iterator<Map.Entry<String, Book>> it = books.entrySet().iterator();

        // iterating throughout the Hashmap to remove all outdated books
        while (it.hasNext()) {
            Map.Entry<String, Book> entry = it.next();
            Book b = entry.getValue();
            if (b.isOutdated(currentYear, maxAge)) {
                it.remove();
            }
        }
    }

    public double buy(String ISBN, int quantity, String email, String address) {
        Book b = books.get(ISBN);

        if (b == null) {
            throw new IllegalArgumentException("Book not found");
        }
        else if (b instanceof Buyable) {
            return ((Buyable) b).buy(quantity, email, address);
        } else {
            throw new IllegalArgumentException("Book is not buyable");
        }
    }

    public boolean has(String ISBN) {
        return books.containsKey(ISBN);
    }

    public void add(Book b) {
        books.put(b.getISBN(), b);
    }

    public void remove(String ISBN) {
        books.remove(ISBN);
    }
}
