package services;

public class EmailService {
    public static void sendEmail(String recipientEmail, Object item) {
        System.out.println("Sending email to: " + recipientEmail);
    }
}