package com.example.mahesh.service;

import com.example.mahesh.model.Mahesh;
import com.example.mahesh.repository.MaheshRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MaheshService {

    @Autowired
    private MaheshRepository repository;

    public List<Mahesh> getAllRecords() {
        return repository.findAll();
    }

    public Mahesh getRecordById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Record not found: " + id));
    }

    public Mahesh createRecord(Mahesh mahesh) {
        return repository.save(mahesh);
    }

    public Mahesh updateRecord(Long id, Mahesh mahesh) {
        Mahesh existing = getRecordById(id);
        existing.setName(mahesh.getName());
        existing.setEmail(mahesh.getEmail());
        existing.setPhone(mahesh.getPhone());
        existing.setAddress(mahesh.getAddress());
        return repository.save(existing);
    }

    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }

    public List<Mahesh> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }
}
