package com.example.library;
import java.util.*;

import javax.management.RuntimeErrorException;

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

    public void borrowBook(String isbn){
        for(Book book : books){
            if(book.getIsbn().equals(isbn)){
                if(book.isAvailable()){
                    book.setAvailable(false);
                    return;
                }else{
                    throw new RuntimeException("Book not available");
                }
            }
        }
        throw new RuntimeException("Book not found");
    }

    public void returnBook(String isbn) {
        for(Book book : books){
            if (book.getIsbn().equals(isbn)) {
                book.setAvailable(true);
                return;
            }
        }
        throw new RuntimeException("Book not found");
    }
    
}
