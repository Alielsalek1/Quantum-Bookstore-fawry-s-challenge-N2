package models;

import abstractions.Book;
import abstractions.Buyable;
import services.EmailService;

public class EBook extends Book implements Buyable {
    private String filetype;

    public EBook(String ISBN, String title, int yearPublished, double price,
                String filetype) {
        super(ISBN, title, yearPublished, price);
        this.filetype = filetype;
    }

    @Override
    public double buy(int quantity, String emailAdress, String adress) {
        EmailService.sendEmail(emailAdress, this);
        return price * quantity;
    }

    public String getFiletype() {
        return filetype;
    }

    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
}
