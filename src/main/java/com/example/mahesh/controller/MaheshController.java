package com.example.mahesh.controller;

import com.example.mahesh.model.Mahesh;
import com.example.mahesh.service.MaheshService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mahesh")
public class MaheshController {
    
    @Autowired
    private MaheshService maheshService;
    
    @GetMapping
    public ResponseEntity<List<Mahesh>> getAllRecords() {
        List<Mahesh> records = maheshService.getAllRecords();
        return ResponseEntity.ok(records);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Mahesh> getRecordById(@PathVariable Long id) {
        Mahesh record = maheshService.getRecordById(id);
        return ResponseEntity.ok(record);
    }
    
    @PostMapping
    public ResponseEntity<Mahesh> createRecord(@RequestBody Mahesh mahesh) {
        Mahesh created = maheshService.createRecord(mahesh);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Mahesh> updateRecord(
            @PathVariable Long id, 
            @RequestBody Mahesh mahesh) {
        Mahesh updated = maheshService.updateRecord(id, mahesh);
        return ResponseEntity.ok(updated);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long id) {
        maheshService.deleteRecord(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Mahesh>> searchByName(@RequestParam String name) {
        List<Mahesh> records = maheshService.findByNameContaining(name);
        return ResponseEntity.ok(records);
    }
}