package abstractions;

// Abstract class representing a Book with basic properties
public abstract class Book {
    protected String ISBN;
    protected String title;
    protected int yearPublished;
    protected double price;

    public Book(String ISBN, String title, int yearPublished, double price) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public boolean isOutdated(int currentYear, int maxAge) {
        return currentYear - yearPublished > maxAge;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getPrice() {
        return price;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
