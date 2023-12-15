package com.avan.libraryapp1.unittests;

import java.util.List;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avan.libraryapp1.model.Book;
import com.avan.libraryapp1.model.User;
import com.avan.libraryapp1.repository.BookRepository;
import com.avan.libraryapp1.services.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetAllBooks_EmptyList() {
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());
        List<Book> books = bookService.getAllBooks();
        Assertions.assertEquals(0, books.size());
    }

    @Test
    public void testGetAllBooks_ExceptionHandling() {
        when(bookRepository.findAll()).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> bookService.getAllBooks());
    }

    @Test
    public void testGetBookById_ValidID() {
        Optional<Book> book = Optional.of(new Book());
        when(bookRepository.findById(1L)).thenReturn(book);
        Optional<Book> retrievedBook = bookService.getBookById(1L);
        Assertions.assertTrue(retrievedBook.isPresent());
        Assertions.assertEquals(book.get(), retrievedBook.get());
    }

    @Test
    public void testGetBookById_NotFoundBook() {
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());
        Optional<Book> book = bookService.getBookById(1L);
        Assertions.assertFalse(book.isPresent());
    }

    @Test
    void testSaveBook_Success() {
        Book bookToSave = new Book();
        when(bookRepository.save(bookToSave)).thenReturn(bookToSave);
        Assertions.assertNull(bookService.saveBook(bookToSave));
    }

    @Test
    void testDeleteBook_ValidID() {
        Long bookId = 1L;
        bookService.deleteBook(bookId);
        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    void testBorrowBook_Success() {
        Long bookId = 1L;
        User student = new User();
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));
        Book borrowedBook = bookService.borrowBook(bookId, student);
        Assertions.assertNull(borrowedBook.getBorrowedBy());
    }

    @Test
    void testReturnBook_Success() {
        Long bookId = 1L;
        when(bookRepository.findById(bookId)).thenReturn(Optional.of(new Book()));
        Book returnedBook = bookService.returnBook(bookId);
        Assertions.assertNotNull(returnedBook.getBorrowedBy());
    }
}
