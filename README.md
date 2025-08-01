# Hello, This is my Implementation for Fawry's Quantum Bookstore challenge N2

## Structure
- I made a base class called Product (abstract class).
- All books use this base class to reuse code.
- If a book can be bought, it implements the Buyable interface.
- EBook and PhysicalBook each have their own interface to show what makes them special.
- I used a HashMap with the ISBN as the key to store the books.
- I have ShippingService (dummy) that handles shipping to user
- I have EmailService (dummy) that handles sending emails to users

## Features
- You can add books to the inventory.
- You can buy books if they are buyable and in stock.
- You can remove outdated books (books older than X years).
- You can remove books by object or by ISBN.

## Tests
I wrote some test functions in the main() method:

```java
testHappyCase();
testRemoveOutdatedBooks();
testAddingRemovingBuyingBooks();
testBookOutOfStock();
```

## Screenshots of running the application

![Screenshot 2025-07-08 220942](Screenshots/Screenshot%202025-07-08%20220942.png)
![Screenshot 2025-07-08 221005](Screenshots/Screenshot%202025-07-08%20221005.png)
![Screenshot 2025-07-08 221029](Screenshots/Screenshot%202025-07-08%20221029.png)
![Screenshot 2025-07-08 221050](Screenshots/Screenshot%202025-07-08%20221050.png)
