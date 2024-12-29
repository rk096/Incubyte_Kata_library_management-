package com.example.library;
import java.util.List;
import static org.junit.Assert.*;
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
}
