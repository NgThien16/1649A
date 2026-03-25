package project_brief.repository;

import project_brief.library.ArrayListADT;
import project_brief.library.BinarySearch;
import project_brief.library.MergeSort;
import project_brief.model.Book;

public class BookRepository implements IBookRepository{
    private static ArrayListADT<Book> bookList =new ArrayListADT<>();
    static{
        bookList.add(new Book(1,"Harry Potter","J.K. Rowling", 100,10.0,0));
        bookList.add(new Book(2,"The Great Gatsby","F. Scott Fitzgerald", 100,12.0,0));
        bookList.add(new Book(3,"To Kill a Mockingbird","Harper Lee", 100,10.0,0));
        bookList.add(new Book(4,"The Alchemist","Paulo Coelho", 100,11.0,0));
    }
    @Override
    public ArrayListADT<Book> getBook() {
        return bookList;
    }

    @Override
    public ArrayListADT<Book> displayBookByTitle() {
        if(bookList.size()>1){
            MergeSort.sort(bookList,0, bookList.size()-1,"title");
        }
        return bookList;
    }


    @Override
    public ArrayListADT<Book> displayBookByAuthorName() {
        if(bookList.size()>1){
            MergeSort.sort(bookList,0, bookList.size()-1,"author");
        }
        return bookList;
    }



    @Override
    public boolean addBook(Book book) {
        bookList.add(book);
        return true;
    }

    @Override
    public boolean updateBook(Book updatedBook) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId()==updatedBook.getId()) {
                bookList.set(i, updatedBook);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id){
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i) != null && bookList.get(i).getId() == id) {
                bookList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Book findBookByID(int id) {
        for (int i = 0; i < bookList.size(); i++) {
            Book b = bookList.get(i);
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
    @Override
    public boolean reduceStock(Book book) {
        return false;
    }
    @Override
    public ArrayListADT<Book> searchBookByTitle(String title) {
        if (bookList.size() > 1) {
            MergeSort.sort(bookList, 0, bookList.size() - 1, "title");
        }

        int index = BinarySearch.search(bookList, title, "title");

        ArrayListADT<Book> result = new ArrayListADT<>();
        if (index != -1) {
            result.add(bookList.get(index));
        }
        return result;
    }

    @Override
    public ArrayListADT<Book> searchBookByAuthorName(String authorName) {
        if (bookList.size() > 1) {
            MergeSort.sort(bookList, 0, bookList.size() - 1, "author");
        }
        int index = BinarySearch.search(bookList, authorName, "author");

        ArrayListADT<Book> result = new ArrayListADT<>();
        if (index != -1) {
            result.add(bookList.get(index));
        }
        return result;
    }
}
