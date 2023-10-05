package com.avan.libraryapp1.exceptions;

/**
 * Exception thrown when a book is not found.
 */
public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BookNotFoundException(Long id) {
        super(String.format("Book with ID %d not found.", id));
    }
}
