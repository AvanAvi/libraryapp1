package com.avan.libraryapp1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(BookNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleBookNotFound(BookNotFoundException ex) {
    ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex) {
    ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }  

  @ExceptionHandler(BorrowRecordNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleBorrowRecordNotFound(BorrowRecordNotFoundException ex) {
    ErrorResponse response = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
  }

  // Generic exception handler

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleGeneralError(Exception ex) {
    ErrorResponse response = new ErrorResponse("Unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR); 
    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}