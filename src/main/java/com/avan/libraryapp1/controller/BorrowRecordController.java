package com.avan.libraryapp1.controller;

import com.avan.libraryapp1.dto.BorrowRecordDTO;
import com.avan.libraryapp1.model.BorrowRecord;
import com.avan.libraryapp1.services.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/borrow-records")
public class BorrowRecordController {

    @Autowired
    private BorrowRecordService borrowRecordService;

    @GetMapping
    public List<BorrowRecordDTO> getAllBorrowRecords() {
      return borrowRecordService.getAllBorrowRecords().stream()
              .map(this::convertEntityToDto)
              .toList();
    
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowRecordDTO> getBorrowRecordById(@PathVariable Long id) {
        return borrowRecordService.getBorrowRecordById(id)
                .map(borrowRecord -> ResponseEntity.ok(convertEntityToDto(borrowRecord)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BorrowRecordDTO> createBorrowRecord(@RequestBody BorrowRecordDTO borrowRecordDTO) {
        BorrowRecord borrowRecord = convertDtoToEntity(borrowRecordDTO);
        return new ResponseEntity<>(convertEntityToDto(borrowRecordService.saveBorrowRecord(borrowRecord)), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowRecordDTO> updateBorrowRecord(@PathVariable Long id, @RequestBody BorrowRecordDTO borrowRecordDTO) {
        return borrowRecordService.getBorrowRecordById(id)
                .map(existingRecord -> {
                    BorrowRecord borrowRecord = convertDtoToEntity(borrowRecordDTO);
                    borrowRecord.setId(id);
                    return ResponseEntity.ok(convertEntityToDto(borrowRecordService.saveBorrowRecord(borrowRecord)));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowRecord(@PathVariable Long id) {
        borrowRecordService.deleteBorrowRecord(id);
        return ResponseEntity.ok().build();
    }

    private BorrowRecord convertDtoToEntity(BorrowRecordDTO borrowRecordDTO) {
        BorrowRecord borrowRecord = new BorrowRecord();
        borrowRecord.setId(borrowRecordDTO.getId());
        borrowRecord.setUserId(borrowRecordDTO.getUserId());
        borrowRecord.setBookId(borrowRecordDTO.getBookId());
        borrowRecord.setBorrowDate(borrowRecordDTO.getBorrowDate());
        borrowRecord.setReturnDate(borrowRecordDTO.getReturnDate());
        return borrowRecord;
    }

    private BorrowRecordDTO convertEntityToDto(BorrowRecord borrowRecord) {
        BorrowRecordDTO borrowRecordDTO = new BorrowRecordDTO();
        borrowRecordDTO.setId(borrowRecord.getId());
        borrowRecordDTO.setUserId(borrowRecord.getUserId());
        borrowRecordDTO.setBookId(borrowRecord.getBookId());
        borrowRecordDTO.setBorrowDate(borrowRecord.getBorrowDate());
        borrowRecordDTO.setReturnDate(borrowRecord.getReturnDate());
        return borrowRecordDTO;
    }
}