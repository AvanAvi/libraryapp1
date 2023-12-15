package com.avan.libraryapp1.unittests;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avan.libraryapp1.model.Book;
import com.avan.libraryapp1.repository.BookRepository;
import com.avan.libraryapp1.services.BookService;

@ExtendWith(MockitoExtension.class)

public
 
class
 
BookServiceTests
 
{

    @Mock

    
private BookRepository bookRepository;

    @InjectMocks

    
private BookService bookService;

    @Test
    public void testGetAllBooks_EmptyList() {
        // Mock the behavior of BookRepository.findAll() to return an empty list
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());

        // Call the getAllBooks() method on the BookService
        List<Book> books = bookService.getAllBooks();

        // Verify that the assertion fails because the list is empty
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetBookById_ValidID() {
        // Create an Optional<Book> object
        Optional<Book> book = Optional.of(new Book());

        // Mock the behavior of BookRepository.findById() to return the Optional<Book>
        when(bookRepository.findById(1L)).thenReturn(book);

        // Call the getBookById() method on the BookService with the valid ID
        Optional<Book> retrievedBook = bookService.getBookById(1L);

        // Verify that the assertion succeeds because the book is found and the Optional is not empty
        Assertions.assertTrue(retrievedBook.isPresent());
        Assertions.assertEquals(book.get(), retrievedBook.get());
    }



    @Test
    public void testGetBookById_NotFoundBook() {
        // Mock the behavior of BookRepository.findById() to return an empty Optional
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        // Call the getBookById() method on the BookService with the ID
        Optional<Book> book = bookService.getBookById(1L);

        // Verify that the assertion succeeds because the book is not found and the Optional is empty
        Assertions.assertFalse(book.isPresent());
    }
}
