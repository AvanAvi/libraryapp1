package com.avan.libraryapp1.controller;

import com.avan.libraryapp1.dto.BookDTO;
import com.avan.libraryapp1.model.Book;
import com.avan.libraryapp1.model.User;
import com.avan.libraryapp1.services.BookService;
import com.avan.libraryapp1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOs = bookService.getAllBooks().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(bookDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(book -> ResponseEntity.ok(convertEntityToDto(book)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = convertDtoToEntity(bookDTO);
        Book savedBook = bookService.saveBook(book);
        BookDTO savedBookDTO = convertEntityToDto(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO updatedBookDTO) {
        Book updatedBook = convertDtoToEntity(updatedBookDTO);
        updatedBook.setId(id);
        Book savedBook = bookService.saveBook(updatedBook);
        BookDTO savedBookDTO = convertEntityToDto(savedBook);
        return ResponseEntity.ok(savedBookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{bookId}/borrow/{userId}")
    public ResponseEntity<BookDTO> borrowBook(@PathVariable Long bookId, @PathVariable Long userId) {
        User student = userService.getUserById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book borrowedBook = bookService.borrowBook(bookId, student);
        BookDTO borrowedBookDTO = convertEntityToDto(borrowedBook);
        return ResponseEntity.ok(borrowedBookDTO);
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<BookDTO> returnBook(@PathVariable Long bookId) {
        Book returnedBook = bookService.returnBook(bookId);
        BookDTO returnedBookDTO = convertEntityToDto(returnedBook);
        return ResponseEntity.ok(returnedBookDTO);
    }

    private BookDTO convertEntityToDto(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        
        bookDTO.setCopiesAvailable(book.getCopiesAvailable());
        return bookDTO;
    }

    private Book convertDtoToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
      
        book.setCopiesAvailable(bookDTO.getCopiesAvailable());
        return book;
    }
}