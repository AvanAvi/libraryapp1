package com.avan.libraryapp1.services;

import com.avan.libraryapp1.model.Book;
import com.avan.libraryapp1.model.User;
import com.avan.libraryapp1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        try {
            return bookRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve books: " + e.getMessage());
        }
    }

    public Optional<Book> getBookById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid book ID.");
        }
        try {
            return bookRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve book: " + e.getMessage());
        }
    }

    public Book saveBook(Book book) {
        // Validate book details here if needed
        try {
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save book: " + e.getMessage());
        }
    }

    public void deleteBook(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid book ID.");
        }
        try {
            bookRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete book: " + e.getMessage());
        }
    }
    @Transactional
    public Book borrowBook(Long bookId, User student) {
        if (bookId == null || bookId <= 0 || student == null) {
            throw new IllegalArgumentException("Invalid book ID or student.");
        }
        try {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
            book.setBorrowedBy(student);
            book.setCopiesAvailable(book.getCopiesAvailable() - 1); // Decrement available copies
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Failed to borrow book: " + e.getMessage());
        }
    }
    @Transactional
    public Book returnBook(Long bookId) {
        if (bookId == null || bookId <= 0) {
            throw new IllegalArgumentException("Invalid book ID.");
        }
        try {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
            book.setBorrowedBy(null);
            book.setCopiesAvailable(book.getCopiesAvailable() + 1); // Increment available copies
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new RuntimeException("Failed to return book: " + e.getMessage());
        }
    }
}
