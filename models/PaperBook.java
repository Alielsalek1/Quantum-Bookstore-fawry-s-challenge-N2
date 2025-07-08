package models;

import abstractions.Book;
import abstractions.Buyable;
import services.ShipingService;

public class PaperBook extends Book implements Buyable {
    private int stock;
    public PaperBook(String ISBN, String title, int yearPublished, double price, int stock) {
        super(ISBN, title, yearPublished, price);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String emailAdress, String adress) {
        if (quantity > stock) {
            throw new IllegalStateException("Not enough stock available");
        }
        stock -= quantity;
        ShipingService.shipItem(emailAdress, adress, this);
        return price * quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
