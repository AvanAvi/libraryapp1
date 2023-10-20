package com.avan.libraryapp1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) 
public class UserNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UserNotFoundException(Long id) {
    super("User not found with id: " + id);
  }

  public UserNotFoundException(String message) {
    super(message);
  }

}