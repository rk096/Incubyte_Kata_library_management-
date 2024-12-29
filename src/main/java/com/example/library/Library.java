package com.example.library;
import java.util.*;

public class Library {

    private List<Book> books;

    public Library(){
        this.books = new ArrayList<>();
    }

    public void addBook(String isbn, String title, String author, int publicationYear){
        Book book = new Book(isbn, title, author, publicationYear, true);
        books.add(book);
    }

    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = new ArrayList<>();
        for(Book book : books){
            if(book.isAvailable()){
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
}
