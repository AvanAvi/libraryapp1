package com.avan.libraryapp1.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int copiesAvailable;

    @ManyToOne
    @JoinColumn(name = "borrowed_by_user_id")
    private User borrowedBy;

    // Constructors
    public Book() {}

    public Book(String title, String author, String isbn, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.copiesAvailable = copiesAvailable;
    }

    // Getters and Setters
    // ... [All the existing getters and setters] ...

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    // Override toString for better readability
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", copiesAvailable=" + copiesAvailable + "]";
    }
}
