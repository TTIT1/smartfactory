package com.example.smartfactory.repository;

import com.example.smartfactory.entity.ProductionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductionRecordRepository extends JpaRepository<ProductionRecord, Long> {
    List<ProductionRecord> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}