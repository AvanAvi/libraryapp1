package com.avan.libraryapp1.repository;

import com.avan.libraryapp1.model.BorrowRecord;
import com.avan.libraryapp1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {
    List<BorrowRecord> findByUser(User user);
}
