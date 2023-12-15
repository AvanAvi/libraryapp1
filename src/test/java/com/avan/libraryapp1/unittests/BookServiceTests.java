package com.avan.libraryapp1.unittests;
import java.util.List;
import java.util.Collections;
import org.mockito.Mockito;
import java.util.Arrays;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;

import com.avan.libraryapp1.model.Book;
import com.avan.libraryapp1.repository.BookRepository;
import com.avan.libraryapp1.services.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks_EmptyList() {
        // Mock the behavior of BookRepository.findAll() to return an empty list
        Mockito.when(bookRepository.findAll()).thenReturn(Collections.emptyList());

        // Call the getAllBooks() method on the BookService
        List<Book> books = bookService.getAllBooks();

        // Verify that the assertion fails because the list is empty
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBookById_InvalidID() {
        // Mock the behavior of BookRepository.findById() to return an empty Optional
        Mockito.when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        // Call the getBookById() method on the BookService with an invalid ID
        Optional<Book> book = bookService.getBookById(1L);

        // Verify that the assertion fails because the book is not found
        Assertions.assertTrue(book.isEmpty());
    }

    @Test
    public void testGetBookById_ValidID() {
        // Create a Book object with an ID of 1
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Book 1");
        book.setAuthor("Author 1");

        // Mock the behavior of BookRepository.findAll() to return a list containing the book
        List<Book> books = Arrays.asList(book);
        Mockito.when(bookRepository.findAll()).thenReturn(books);

        // Call the getBookById() method on the BookService with the valid ID
        Optional<Book> retrievedBook = bookService.getBookById(1L);

        // Verify that the assertion passes because the book is found and the Optional is not empty
        Assertions.assertTrue(retrievedBook.isPresent());
        Assertions.assertEquals(book, retrievedBook.get());
    }

    @Test
    public void testGetBookById_NotFoundBook() {
        // Mock the behavior of BookRepository.findById() to throw an RuntimeException
        Mockito.when(bookRepository.findById(1L)).thenThrow(new RuntimeException());

        // Call the getBookById() method on the BookService with the ID
        Optional<Book> book = bookService.getBookById(1L);

        // Verify that the assertion fails because an exception is thrown
        Assertions.assertTrue(book.isEmpty());
    }
}
