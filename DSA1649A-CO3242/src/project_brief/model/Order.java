package project_brief.model;

import project_brief.library.ArrayListADT;

import java.time.LocalDate;

public class Order {
    private int orderID;
    private String customerName;
    private ShippingStatus status;
    private ArrayListADT<Book> items;
    private String address;
    private LocalDate orderDate;
    private int orderQuantity;

    public Order() {
    }
    private static int count = 0;
    public Order( String customerName, ShippingStatus status,ArrayListADT<Book> items, String address, LocalDate orderDate, int orderQuantity) {
        this.orderID = ++count;
        this.customerName = customerName;
        this.status = status;
        this.items = items;
        this.address = address;
        this.orderDate = orderDate;
        this.orderQuantity = orderQuantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ShippingStatus getStatus() {
        return status;
    }

    public void setStatus(ShippingStatus status) {
        this.status = status;
    }

    public ArrayListADT<Book> getItems() {
        return items;
    }

    public void setItems(ArrayListADT<Book> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    @Override
    public String toString() {
        String result = "========================================\n";
        result += "ORDER ID: " + orderID + "\n";
        result += "Customer: " + customerName + "\n";
        result += "Status: " + status + "\n";
        result += "Address: " + address + "\n";
        result += "Date: " + orderDate + "\n";
        result += "Quantity: " + orderQuantity + "\n";
        result += "----------------------------------------\n";
        result += "ITEMS IN ORDER:\n";

        double total = 0;
        if (items != null && items.size() > 0) {
            for (int i = 0; i < items.size(); i++) {
                Book b = items.get(i);
                if (b != null) {
                    double subTotal = b.getPrice() * this.orderQuantity;
                    result += "- " + b.getTitle() + " x" + this.orderQuantity + " (Price: " + b.getPrice() + ")\n";
                    total += subTotal;
                }
            }
        } else {
            result += "(No items)\n";
        }

        result += "----------------------------------------\n";
        result += "TOTAL PRICE: " + total + "\n";
        result += "========================================\n";

        return result;
    }
}
