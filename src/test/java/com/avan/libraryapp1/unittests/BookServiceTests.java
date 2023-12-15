package com.avan.libraryapp1.unittests;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.avan.libraryapp1.model.Book;  
import com.avan.libraryapp1.repository.BookRepository;
import com.avan.libraryapp1.services.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {

    @Mock
    BookRepository bookRepository;

    @Test
    public void testGetAllBooks() {
        
        BookService bookService = new BookService();

        List<Book> books = bookService.getAllBooks();

        Assertions.assertEquals(1, books.size());
    }
}

