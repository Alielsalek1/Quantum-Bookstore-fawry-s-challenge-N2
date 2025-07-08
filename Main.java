import models.*;
import abstractions.Book;
import abstractions.Buyable;
import models.Inventory;

public class Main {
    public static void main(String[] args) {
//        testHappyCase();
//         testRemoveOutdatedBooks();
//         testAddingRemovingBuyingBooks();
         testBookOutOfStock();
    }

    public static void testHappyCase() {
        try {
            PhysicalBook book1 = new PhysicalBook(
                "1234", "x", 1925, 15.99, 10
            );
            
            EBook book2 = new EBook(
                "654", "z", 2023, 12.99, "PDF"
            );

            ReferenceBook book3 = new ReferenceBook(
                "12", "y", 1975, 299.99
            );

            Inventory inventory = new Inventory();

            inventory.add(book1);
            inventory.add(book2);
            inventory.add(book3);

            double cost1 = book1.buy(2, "ali.com", "cairo");
            double cost2 = book2.buy(1, "ali.com", null);

            System.out.println("Physical book cost: $" + cost1);
            System.out.println("E-book cost: $" + cost2);
        } catch (Exception e) {
            System.out.println("test FAILED: " + e.getMessage());
        }
    }

    public static void testRemoveOutdatedBooks() {
        try {
            PhysicalBook oldBook1 = new PhysicalBook(
                    "1234", "x", 1925, 15.99, 10
            );
            
            PhysicalBook oldBook2 = new PhysicalBook(
                    "12345", "x", 1925, 15.99, 10
            );
            
            EBook modernBook = new EBook(
                    "654", "z", 2023, 12.99, "PDF"
            );

            Inventory inventory = new Inventory();

            inventory.add(oldBook1);
            inventory.add(oldBook2);
            inventory.add(modernBook);

            int cutoffYear = 2000;

            inventory.removeOutdatedBooks(cutoffYear, 0);
            System.out.println(oldBook1.getISBN() + " " + inventory.has(oldBook1.getISBN()));
            System.out.println(oldBook2.getISBN() + " " + inventory.has(oldBook2.getISBN()));
            System.out.println(modernBook.getISBN() + " " + inventory.has(modernBook.getISBN()));
        } catch (Exception e) {
            System.out.println("Remove outdated books test FAILED: " + e.getMessage());
        }
    }

    public static void testAddingRemovingBuyingBooks() {
        try {
            PhysicalBook Book1 = new PhysicalBook(
                    "1234", "x", 1925, 15.99, 10
            );

            PhysicalBook Book2 = new PhysicalBook(
                    "12345", "x", 1925, 15.99, 10
            );

            Inventory inventory = new Inventory();

            inventory.add(Book1);
            inventory.add(Book2);

            double rareCost = inventory.buy(Book1.getISBN(), 1, "ali.com", "cairo");
            System.out.println("Bought book1 for:" + rareCost);
            System.out.println("book1 stock remaining: " + Book1.getStock());
            
            double testCost = inventory.buy(Book2.getISBN(), 3, "ali.com", "cairo");
            System.out.println("Bought 3 book2 for:" + testCost);
            System.out.println("book2 stock remaining: " + Book2.getStock());

            inventory.remove(Book1.getISBN());
            System.out.println(Book1.getISBN() + " " + inventory.has(Book1.getISBN()));
            
        } catch (Exception e) {
            System.out.println("Adding, removing, and buying books test FAILED: " + e.getMessage());
        }
    }

    public static void testBookOutOfStock() {
        try {
            PhysicalBook Book1 = new PhysicalBook(
                    "1234", "x", 1925, 15.99, 1
            );

            PhysicalBook Book2 = new PhysicalBook(
                    "12345", "x", 1925, 15.99, 1
            );

            Inventory inventory = new Inventory();

            inventory.add(Book1);
            inventory.add(Book2);

            double rareCost = inventory.buy(Book1.getISBN(), 1, "ali.com", "cairo");
            System.out.println("Bought book1 for:" + rareCost);
            System.out.println("book1 stock remaining: " + Book1.getStock());

            double testCost = inventory.buy(Book2.getISBN(), 3, "ali.com", "cairo");
            System.out.println("Bought 3 book2 for:" + testCost);
            System.out.println("book2 stock remaining: " + Book2.getStock());

        } catch (Exception e) {
            System.out.println("Book out of stock test FAILED: " + e.getMessage() + "\n");
        }
    }
}