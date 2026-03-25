package project_brief.repository;

import project_brief.library.ArrayListADT;
import project_brief.model.Book;



public interface IBookRepository {
    ArrayListADT<Book> getBook();
    ArrayListADT<Book> displayBookByTitle();
    ArrayListADT<Book> searchBookByTitle(String title);
    ArrayListADT<Book> displayBookByAuthorName();
    ArrayListADT<Book> searchBookByAuthorName(String author);
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(int id);
    Book findBookByID(int id);

    boolean reduceStock(Book book);
//    void sortBooksByTitle();
}
