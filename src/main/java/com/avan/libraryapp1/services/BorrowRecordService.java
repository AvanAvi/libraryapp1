package com.avan.libraryapp1.services;

import com.avan.libraryapp1.model.BorrowRecord;
import com.avan.libraryapp1.repository.BorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowRecordService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    public Optional<BorrowRecord> getBorrowRecordById(Long id) {
        return borrowRecordRepository.findById(id);
    }

    public BorrowRecord saveBorrowRecord(BorrowRecord borrowRecord) {
        // Logic to decrement the copiesAvailable of the Book entity when a book is borrowed
        // and increment when a book is returned.
        // This will require additional methods in the BookService to handle these operations.

        // For now, just saving the record:
        return borrowRecordRepository.save(borrowRecord);
    }

    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.deleteById(id);
    }
}
