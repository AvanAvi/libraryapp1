package com.avan.libraryapp1.services;

import com.avan.libraryapp1.model.BorrowRecord;
import com.avan.libraryapp1.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<BorrowRecord> getAllBorrowRecords() {
        try {
            return borrowRecordRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve borrow records: " + e.getMessage());
        }
    }

    public Optional<BorrowRecord> getBorrowRecordById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid borrow record ID.");
        }
        try {
            return borrowRecordRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to retrieve borrow record: " + e.getMessage());
        }
    }
    
    @Transactional
    public BorrowRecord saveBorrowRecord(BorrowRecord borrowRecord) {
        // Validate borrowRecord details here if needed
        try {
            return borrowRecordRepository.save(borrowRecord);
        } catch (Exception e) {
            throw new RuntimeException("Failed to save borrow record: " + e.getMessage());
        }
    }
    
    @Transactional
    public void deleteBorrowRecord(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid borrow record ID.");
        }
        try {
            borrowRecordRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete borrow record: " + e.getMessage());
        }
    }
}
