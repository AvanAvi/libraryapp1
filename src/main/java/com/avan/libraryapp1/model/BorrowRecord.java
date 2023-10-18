package com.avan.libraryapp1.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.avan.libraryapp1.utils.ValidationUtils;

@Entity
public class BorrowRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private Long bookId;

  private Date borrowDate;

  private Date returnDate;

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
    ValidationUtils.validateNotNull(userId, "User ID");
    this.userId = userId;
  }

  public Long getBookId() {
    return bookId; 
  }

  public void setBookId(Long bookId) {
    ValidationUtils.validateNotNull(bookId, "Book ID");
    this.bookId = bookId;
  }

  public Date getBorrowDate() {
    return borrowDate;
  }

  public void setBorrowDate(Date borrowDate) {
    ValidationUtils.validatePastOrPresent(borrowDate, "Borrow date");
    this.borrowDate = borrowDate;
  }

  public Date getReturnDate() {
    return returnDate;
  }
  
  public void setReturnDate(Date returnDate) {
    ValidationUtils.validatePastOrPresent(returnDate, "Return date");
    this.returnDate = returnDate;
  }
  
}