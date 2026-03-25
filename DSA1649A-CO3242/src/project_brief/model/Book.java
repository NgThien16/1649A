package project_brief.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int quantity;
    private double price;
    private int numberOfOrder;

    public Book(){

    }

    public Book(int id, String title, String author, int quantity, double price, int numberOfOrder) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
        this.price = price;
        this.numberOfOrder = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfOrder() {
        return numberOfOrder;
    }

    public void setNumberOfOrder(int numberOfOrder) {
        this.numberOfOrder = numberOfOrder;
    }
    @Override
    public String toString() {
        return String.format("ID: %-3d | Title: %-20s | Author: %-15s | Price: %-8.2f | Stock: %-5d | Ordered: %d",
                id, title, author, price, quantity, numberOfOrder);
    }
}
