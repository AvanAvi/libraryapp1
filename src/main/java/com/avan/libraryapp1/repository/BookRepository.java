package com.avan.libraryapp1.repository;

import com.avan.libraryapp1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Additional custom queries can be added here if needed
}
