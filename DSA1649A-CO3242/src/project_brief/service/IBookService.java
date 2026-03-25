package project_brief.service;

import project_brief.library.ArrayListADT;
import project_brief.model.Book;



public interface IBookService {
    ArrayListADT<Book> getBook();
    ArrayListADT<Book> displayBookByTitle();
    ArrayListADT<Book> displayBookByAuthorName();
    ArrayListADT<Book> searchBookByAuthorName(String author);
    ArrayListADT<Book> searchBookByTitle(String title);
    boolean addBook(Book book);

    boolean updateBook(Book book);
    boolean deleteBook(int id);
    Book findBookById(int id);
    boolean reduceStock(Book book);


}
