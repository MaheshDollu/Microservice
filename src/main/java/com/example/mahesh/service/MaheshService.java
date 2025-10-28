package com.example.mahesh.service;

import com.example.mahesh.exception.ResourceNotFoundException;
import com.example.mahesh.exception.DuplicateResourceException;
import com.example.mahesh.model.Mahesh;
import com.example.mahesh.repository.MaheshRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MaheshService {
    
    @Autowired
    private MaheshRepository maheshRepository;
    
    public List<Mahesh> getAllRecords() {
        return maheshRepository.findAll();
    }
    
    public Mahesh getRecordById(Long id) {
        return maheshRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Record not found with id: " + id));
    }
    
    public Mahesh createRecord(Mahesh mahesh) {
        if (maheshRepository.existsByEmail(mahesh.getEmail())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + mahesh.getEmail());
        }
        return maheshRepository.save(mahesh);
    }
    
    public Mahesh updateRecord(Long id, Mahesh maheshDetails) {
        Mahesh existingRecord = getRecordById(id);
        
        if (!existingRecord.getEmail().equals(maheshDetails.getEmail()) 
                && maheshRepository.existsByEmail(maheshDetails.getEmail())) {
            throw new DuplicateResourceException(
                    "Email already exists: " + maheshDetails.getEmail());
        }
        
        existingRecord.setName(maheshDetails.getName());
        existingRecord.setEmail(maheshDetails.getEmail());
        existingRecord.setPhone(maheshDetails.getPhone());
        existingRecord.setAddress(maheshDetails.getAddress());
        
        return maheshRepository.save(existingRecord);
    }
    
    public void deleteRecord(Long id) {
        Mahesh record = getRecordById(id);
        maheshRepository.delete(record);
    }
    
    // ✅ FIXED: Changed method name to match repository
    public List<Mahesh> findByNameContaining(String name) {
        return maheshRepository.findByNameContainingIgnoreCase(name);
    }
    
    public Mahesh getByEmail(String email) {
        return maheshRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Record not found with email: " + email));
    }
}