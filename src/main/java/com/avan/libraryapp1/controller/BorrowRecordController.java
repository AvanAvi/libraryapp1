package com.avan.libraryapp1.controller;

import com.avan.libraryapp1.model.BorrowRecord;
import com.avan.libraryapp1.services.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordService.getAllBorrowRecords();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRecord> getBorrowRecordById(@PathVariable Long id) {
        return borrowRecordService.getBorrowRecordById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BorrowRecord createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        // Check if the current user is a student before allowing borrowing
        // This will require integration with Spring Security or a similar framework

        return borrowRecordService.saveBorrowRecord(borrowRecord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRecord> updateBorrowRecord(@PathVariable Long id, @RequestBody BorrowRecord borrowRecord) {
        return borrowRecordService.getBorrowRecordById(id)
                .map(existingRecord -> {
                    borrowRecord.setId(id);
                    return ResponseEntity.ok().body(borrowRecordService.saveBorrowRecord(borrowRecord));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowRecord(@PathVariable Long id) {
        borrowRecordService.deleteBorrowRecord(id);
        return ResponseEntity.ok().build();
    }
}
