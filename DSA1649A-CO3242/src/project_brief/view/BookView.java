package project_brief.view;


import project_brief.library.ArrayListADT;
import project_brief.model.Book;
import project_brief.service.BookService;
import project_brief.service.IBookService;
import project_brief.utils.CheckValidate;

import java.util.Scanner;


public class BookView {
    private static IBookService  bookService = new BookService();
    private static Scanner scanner = new  Scanner(System.in);

    public static void displayBook(ArrayListADT<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i); // Lấy sách tại vị trí i
            if (book != null) {
                System.out.println(book.toString());
            } else {
                break;
            }
        }
    }
    public static Book inputDataForNewBook() {
        int id = bookService.getBook().size() + 1;
        String title, author;
        double price;
        int quantity;



        do {
            System.out.print("Enter Title (Ex: Java Programming): ");
            title = scanner.nextLine();
            if (!CheckValidate.checkTitle(title)) {
                System.out.println("Invalid title! (Capitalize first letters)");
            }
        } while (!CheckValidate.checkTitle(title));

        do {
            System.out.print("Enter Author (Ex: James Gosling): ");
            author = scanner.nextLine();
            if (!CheckValidate.checkName(author)) {
                System.out.println("Invalid author name!");
            }
        } while (!CheckValidate.checkName(author));

        do {
            try {
                System.out.print("Enter Price: ");
                price = Double.parseDouble(scanner.nextLine());
                if (price < 0) {
                    System.out.println("Price cannot be negative!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price! Please enter a decimal number (e.g., 15.5).");
            }
        } while (true);

        do {
            try {
                System.out.print("Enter Quantity: ");
                quantity = Integer.parseInt(scanner.nextLine());
                if (quantity < 0) {
                    System.out.println("Quantity cannot be negative!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity! Please enter a whole number.");
            }
        } while (true);


        Book book = new Book(id,title,author,quantity,price,0);
        return book;
    }
    public static Book inputDataForEditBook(Book oldBook) {
        System.out.println("\n--- EDITING BOOK ID: " + oldBook.getId() + " ---");
        System.out.println("(Leave blank and press Enter to keep current value)");

        String title, author;
        double price;
        int quantity;

        do {
            System.out.print("Enter New Title (Current: " + oldBook.getTitle() + "): ");
            title = scanner.nextLine();
            if (title.isEmpty()) {
                title = oldBook.getTitle();
                break;
            }
            if (!CheckValidate.checkTitle(title)) {
                System.out.println("Invalid title format!");
            }
        } while (!CheckValidate.checkTitle(title));

        do {
            System.out.print("Enter New Author (Current: " + oldBook.getAuthor() + "): ");
            author = scanner.nextLine();
            if (author.isEmpty()) {
                author = oldBook.getAuthor();
                break;
            }
            if (!CheckValidate.checkName(author)) {
                System.out.println("Invalid author name format!");
            }
        } while (!CheckValidate.checkName(author));

        do {
            System.out.print("Enter New Price (Current: " + oldBook.getPrice() + "): ");
            String priceInput = scanner.nextLine();
            if (priceInput.isEmpty()) {
                price = oldBook.getPrice();
                break;
            }
            try {
                price = Double.parseDouble(priceInput);
                if (price < 0) System.out.println("Price cannot be negative!");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid price! Please enter a number.");
            }
        } while (true);

        do {
            System.out.print("Enter New Quantity (Current: " + oldBook.getQuantity() + "): ");
            String qtyInput = scanner.nextLine();
            if (qtyInput.isEmpty()) {
                quantity = oldBook.getQuantity();
                break;
            }
            try {
                quantity = Integer.parseInt(qtyInput);
                if (quantity < 0) System.out.println("Quantity cannot be negative!");
                else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity! Please enter a whole number.");
            }
        } while (true);


        return new Book(oldBook.getId(), title, author, quantity, price, oldBook.getNumberOfOrder());
    }


    public static void searchBook(){
        System.out.print("Enter Book Title or Author Name: ");
        String keyword = scanner.nextLine().trim();

        // try find by title
        ArrayListADT<Book> results = bookService.searchBookByTitle(keyword);

        // Bước 2: Nếu tìm theo Title không ra (size == 0), thử tìm theo Author
        if (results.size() == 0) {
            System.out.println("No Title matches... searching by Author Name instead.");
            results = bookService.searchBookByAuthorName(keyword);
        }


        if (results.size() > 0) {
            System.out.println("Found " + results.size() + " result(s):");
            displayBook(results);
        } else {
            System.out.println("No books found with keyword: " + keyword);
        }
    }


    public static void deleteBook() {
        System.out.println("\n--- DELETE BOOK ---");
        System.out.print("Enter the Book ID you want to delete: ");

        try {
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Are you sure you want to delete book ID " + id + "? (y/n): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("y")) {
                boolean isDeleted = bookService.deleteBook(id);

                if (isDeleted) {
                    System.out.println("Book deleted successfully!");
                } else {
                    System.out.println("Error: Book ID " + id + " not found.");
                }
            } else {
                System.out.println("Operation cancelled.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid ID! Please enter a number.");
        }
    }
}
