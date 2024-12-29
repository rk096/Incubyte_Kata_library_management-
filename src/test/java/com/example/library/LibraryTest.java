package com.example.library;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeThat;

import org.junit.Test;


public class LibraryTest {
    
    @Test
    public void testAddBook() {
        Library library = new Library();
        library.addBook("1234567890", "Sample Book", "John Doe", 2023);

        List<Book> books = library.getAvailableBooks();
        assertEquals(1, books.size());
        Book book = books.get(0);
        assertEquals("1234567890", book.getIsbn());
        assertEquals("Sample Book", book.getTitle());
        assertEquals("John Doe", book.getAuthor());
        assertEquals(2023, book.getPublicationYear());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testBorrowBook() {
        Library library = new Library();
        library.addBook("1234567890", "Sample Book", "John Doe", 2023);

        library.borrowBook("1234567890");
        List<Book> books = library.getAvailableBooks();

        assertEquals(0, books.size());

        Exception exception = assertThrows(RuntimeException.class, () -> { library.borrowBook("1234567890");});

        assertEquals("Book not available", exception.getMessage());
    }
}
