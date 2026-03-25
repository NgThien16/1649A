package project_brief.view;

import project_brief.library.ArrayListADT;
import project_brief.library.LinkedQueueADT;
import project_brief.model.Book;
import project_brief.model.Order;
import project_brief.model.ShippingStatus;
import project_brief.model.User;
import project_brief.service.BookService;
import project_brief.service.IBookService;
import project_brief.service.IOrderService;
import project_brief.service.OrderService;

import java.time.LocalDate;
import java.util.Scanner;

public class OrderView {
    private static IBookService bookService = new BookService();
    private static IOrderService orderService = new OrderService();
    private static Scanner scanner = new Scanner(System.in);

    public static void displayOrder(ArrayListADT<Order> orderList) {
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            if (order != null) {
                System.out.println(order.toString());
            } else {
                break;
            }
        }

    }

    public static Order inputToOrder(User currentUser) {
        System.out.println("Enter Book ID");
        int id = Integer.parseInt(scanner.nextLine());
        Book book = bookService.findBookById(id);
        if (book == null) {
            System.out.println("Book not found");
            return null;
        }

        int quantity;
        while (true) {
            System.out.println("How many products do you want to buy? (Available: " + book.getQuantity() + ")");
            quantity = Integer.parseInt(scanner.nextLine());

            if (quantity <= 0) {
                System.out.println("Please enter a positive integer!");
            } else if (quantity > book.getQuantity()) {
                System.out.println(" Inventory not enough products!");
            } else {
                break;
            }
        }
        book.setQuantity(book.getQuantity() - quantity);
        book.setNumberOfOrder(book.getNumberOfOrder()+quantity);
        String name = currentUser.getName();
        String address = currentUser.getAddress();
        ArrayListADT<Book> items = new ArrayListADT<Book>();
        items.add(book);

        Order order = new Order(name, ShippingStatus.PENDING, items, address, LocalDate.now(), quantity);
        double totalPrice = book.getPrice() * quantity;

        System.out.println("\n*******************************************");
        System.out.println("✨ ORDER PLACED SUCCESSFULLY! ✨");
        System.out.println("*******************************************");
        System.out.println("ID Order   : " + order.getOrderID());
        System.out.println("Customer   : " + name);
        System.out.println("Address   : " + address);
        System.out.println("Product    : " + book.getTitle());
        System.out.println("Quantity   : " + quantity);
        System.out.println("Total Bill : $" + totalPrice);
        System.out.println("Status     : " + ShippingStatus.PENDING);
        System.out.println("*******************************************\n");
        return order;

    }

    public static void approveOrder(LinkedQueueADT<Order> orderList) {
        while (!orderList.isEmpty() && orderList.peek().getStatus() != ShippingStatus.PENDING) {
            orderList.poll();
        }
        if (orderList.isEmpty()) {
            System.out.println(" No orders waiting for approval.");
            return;
        }

        Order currentOrder = orderList.peek();
        System.out.println("\n--- ORDER PENDING APPROVAL ---");
        System.out.println(currentOrder.toString());

        boolean flag = true;
        while (flag) {
            System.out.println("\nSelect Action:");
            System.out.println("1. Approve (Set to SHIPPING)");
            System.out.println("2. Reject (Set to CANCELLED & Return Stock)");
            System.out.println("3. Skip (Back to Menu)");
            System.out.print("Choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    currentOrder.setStatus(ShippingStatus.SHIPPING);
                    orderList.poll();
                    System.out.println("Order approved! Status changed to SHIPPING.");
                    flag = false;
                    break;

                case 2:
                    currentOrder.setStatus(ShippingStatus.CANCELLED);

                    for (int i = 0; i < currentOrder.getItems().size(); i++) {
                        Book b = currentOrder.getItems().get(i);
                    }

                    orderList.poll();
                    System.out.println(" Order rejected! Status changed to CANCELLED.");
                    flag = false;
                    break;

                case 3:
                    System.out.println("Skipped.");
                    flag = false;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }

    public static void displayOrderForCustomer(ArrayListADT<Order> history, User currentUser) {
        System.out.println("\n--- 👤 YOUR ORDER HISTORY ---");
        boolean found = false;

        for (int i = 0; i < history.size(); i++) {
            Order current = history.get(i);
            if (current.getCustomerName().equalsIgnoreCase(currentUser.getName())) {
                System.out.println(current.toString());
                found = true;
            }
        }

        if (!found) System.out.println("No orders found.");
    }

    public static void cancelOrderByCustomer(User currentUser) {
        System.out.println("Input id to delete");
        int id = Integer.parseInt(scanner.nextLine());

        Order order = orderService.findOrderById(id);

        if (order != null && order.getStatus() == ShippingStatus.PENDING) {
            order.setStatus(ShippingStatus.CANCELLED);
            returnStock(order);
            System.out.println("Order cancelled. Stock returned.");
        } else {
            System.out.println("Cannot cancel! Order is already shipping or not found.");
        }
    }
    private static void returnStock(Order order) {
        Book bookInStore = bookService.findBookById(order.getItems().get(0).getId());
        if (bookInStore != null) {
            int newQuantity = bookInStore.getQuantity() + order.getOrderQuantity();
            bookInStore.setQuantity(newQuantity);
        }
    }

    public static void confirmReceived(User currentUser) {
        System.out.println("Input id to confirm your order: ");
        int id = Integer.parseInt(scanner.nextLine());
        Order order = orderService.findOrderById(id);

        if (order != null && order.getStatus() == ShippingStatus.SHIPPING) {
            // Hiển thị thông tin ngắn gọn để người dùng xác nhận đúng đơn
            System.out.println("Confirm receiving Order #" + id + " (" + order.getCustomerName() + ")?");
            System.out.print("Do you want to confirm? (y/n): ");
            String choice = scanner.nextLine().trim().toLowerCase();

            if (choice.equals("y")) {
                order.setStatus(ShippingStatus.DELIVERED);
                System.out.println("🎉 Thank you! Order marked as DELIVERED.");
            } else {
                System.out.println("Operation cancelled. Order status remains SHIPPING.");
            }
        } else {
            if (order == null) {
                System.out.println(" Order ID not found!");
            } else {
                System.out.println("Order must be in SHIPPING status to confirm (Current: " + order.getStatus() + ").");
            }
        }
    }
}





