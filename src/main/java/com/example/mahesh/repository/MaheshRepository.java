package com.example.mahesh.repository;

import com.example.mahesh.model.Mahesh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MaheshRepository extends JpaRepository<Mahesh, Long> {
    
    Optional<Mahesh> findByEmail(String email);
    List<Mahesh> findByNameContainingIgnoreCase(String name);
    boolean existsByEmail(String email);
    Optional<Mahesh> findByPhone(String phone);
}