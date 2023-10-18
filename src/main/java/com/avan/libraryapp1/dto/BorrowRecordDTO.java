package com.avan.libraryapp1.dto;

import java.util.Date;

import com.avan.libraryapp1.utils.ValidationUtils;

public class BorrowRecordDTO {

  private Long id;

  private Long userId;

  private Long bookId;

  private Date borrowDate;

  private Date returnDate;

  public Long getId() {
    return id;
  }

  
  public Long getBookId() {
	    return bookId;
	  }

	  public Date getBorrowDate() {
	    return borrowDate;
	  }

	  public Date getReturnDate() {
	    return returnDate;
	  }
	  
  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }
  
  public void setUserId(Long userId) {
      ValidationUtils.validateNotNull(userId, "User ID");  // Added field name
      this.userId = userId;
  }

  public void setBookId(Long bookId) {
      ValidationUtils.validateNotNull(bookId, "Book ID");  // Added field name
      this.bookId = bookId;
  }

  public void setBorrowDate(Date borrowDate) {
      ValidationUtils.validatePastOrPresent(borrowDate, "Borrow date");  // Updated method name and added field name
      this.borrowDate = borrowDate;
  }

  public void setReturnDate(Date returnDate) {
      ValidationUtils.validatePastOrPresent(returnDate, "Return date");  // Updated method name and added field name
      this.returnDate = returnDate;
  }
}