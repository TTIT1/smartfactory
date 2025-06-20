package com.example.smartfactory.repository;

import com.example.smartfactory.entity.ProductionLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionLineRepository extends JpaRepository<ProductionLine, Long> {
}