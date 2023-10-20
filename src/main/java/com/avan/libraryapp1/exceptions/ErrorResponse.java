package com.avan.libraryapp1.exceptions;
import org.springframework.http.HttpStatus;



public class ErrorResponse {

  private final String message;

  private final HttpStatus status;
  
  private final long timestamp;

  public ErrorResponse(String message, HttpStatus status) {
    this.message = message;
    this.status = status;
    this.timestamp = System.currentTimeMillis();
  }

  public String getMessage() {
    return message;
  }
  
  public HttpStatus getStatus() { 
    return status;
  }

  public long getTimestamp() {
    return timestamp;
  }

}