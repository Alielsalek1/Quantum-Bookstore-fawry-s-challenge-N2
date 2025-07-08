package services;

public class ShipingService {
    public static void shipItem(String recipientEmail, String address, Object item) {
        System.out.println("Shipping item to: " + recipientEmail);
    }
}