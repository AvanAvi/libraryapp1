package com.avan.libraryapp1.exceptions;

/**
 * Exception thrown when a borrow record is not found.
 */
public class BorrowRecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BorrowRecordNotFoundException(Long id) {
        super(String.format("Borrow record with ID %d not found.", id));
    }
}
