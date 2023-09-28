package com.avan.libraryapp1.repository;

import com.avan.libraryapp1.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    // Additional custom queries can be added here if needed
}
