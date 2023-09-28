package com.avan.libraryapp1.exceptions;

public class BorrowRecordNotFoundException extends RuntimeException {
    public BorrowRecordNotFoundException(Long id) {
        super("Borrow record with ID " + id + " not found.");
    }
}
