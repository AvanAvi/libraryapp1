package com.avan.libraryapp1.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import java.util.Date;

public class BorrowRecordDTO {

  private Long id;

  @NotNull(message = "User ID cannot be null")
  private Long userId;

  @NotNull(message = "Book ID cannot be null") 
  private Long bookId;

  @NotNull(message = "Borrow date cannot be null")
  @PastOrPresent(message = "Borrow date should be in the past or present")
  private Date borrowDate;

  @NotNull
  @PastOrPresent(message = "Return date should be in the past or present")
  private Date returnDate;

  // standard getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}