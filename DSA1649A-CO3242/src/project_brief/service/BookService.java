package project_brief.service;

import project_brief.library.ArrayListADT;
import project_brief.model.Book;
import project_brief.repository.BookRepository;
import project_brief.repository.IBookRepository;

public class BookService implements IBookService {
    private IBookRepository bookRepository = new BookRepository();
    @Override
    public ArrayListADT<Book> getBook() {
        return bookRepository.getBook();
    }

    @Override
    public ArrayListADT<Book> displayBookByTitle() {
        return bookRepository.displayBookByTitle();
    }

    @Override
    public ArrayListADT<Book> displayBookByAuthorName() {
        return bookRepository.displayBookByAuthorName();
    }

    @Override
    public ArrayListADT<Book> searchBookByAuthorName(String author) {
        return bookRepository.searchBookByAuthorName(author);
    }

    @Override
    public ArrayListADT<Book> searchBookByTitle(String title) {
        return bookRepository.searchBookByTitle(title);
    }

    @Override
    public boolean addBook(Book book) {
        return bookRepository.addBook(book);
    }

    @Override
    public boolean updateBook(Book book) {
        return bookRepository.updateBook(book);
    }

    @Override
    public boolean deleteBook(int id){
        return bookRepository.deleteBook(id);
    }

    @Override
    public Book findBookById(int id) {
        return bookRepository.findBookByID(id);
    }
    @Override
    public boolean reduceStock(Book book) {
        return false;
    }


}
