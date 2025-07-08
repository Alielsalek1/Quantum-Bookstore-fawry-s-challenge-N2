package abstractions;

//interface for books that can be bought
public interface Buyable {
    double buy(int quantity, String emailAdress, String adress);
}
