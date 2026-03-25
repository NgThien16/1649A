package project_brief.controller;

import project_brief.library.ArrayListADT;
import project_brief.model.Book;
import project_brief.service.BookService;
import project_brief.service.IBookService;
import project_brief.view.BookView;

import java.util.Scanner;


public class BookController {
    private static IBookService bookService = new BookService();
    private static Scanner scanner = new Scanner(System.in);

    public void displayAllBooks(){
        ArrayListADT<Book> bookList =  bookService.getBook();
        BookView.displayBook(bookList);
    }
    public void addBook() {
        System.out.println("Add new book:");
        Book book = BookView.inputDataForNewBook();
        boolean isAddSuccess = bookService.addBook(book);
        if (isAddSuccess) {
            System.out.println("successfully add book");
        } else {
            System.out.println("can not add book");
        }
    }
    public void editBook() {
        System.out.print("Enter the Book ID you want to edit: ");
        int id = Integer.parseInt(scanner.nextLine());

        Book oldBook = bookService.findBookById(id);

        if (oldBook != null) {
            Book updatedBook = BookView.inputDataForEditBook(oldBook);

            boolean isSuccess = bookService.updateBook(updatedBook);

            if (isSuccess) {
                System.out.println("Successfully edited book!");
            } else {
                System.out.println("Can not edit book!");
            }
        } else {
            System.out.println("Book ID not found!");
        }
    }
    public void deleteBook(){
        BookView.deleteBook();

    }
    public void searchBook(){
        System.out.println("============Search Book==============");
        BookView.searchBook();
    }

    public void displayByAuthorName() {
        ArrayListADT<Book> bookList =  bookService.displayBookByAuthorName();
        BookView.displayBook(bookList);
    }

    public void displayByTitle() {
        ArrayListADT<Book> bookList =  bookService.displayBookByTitle();
        BookView.displayBook(bookList);

    }
}
