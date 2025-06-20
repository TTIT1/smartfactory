package com.example.smartfactory.controller;

import com.example.smartfactory.model.ProductionRecordModel;
import com.example.smartfactory.service.ProductionRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
@CrossOrigin(origins = "*")
public class ProductionRecordController {

    @Autowired
    private ProductionRecordService recordService;

    @GetMapping
    public List<ProductionRecordModel> getAll() {
        return recordService.getAll();
    }

    @GetMapping("/{id}")
    public ProductionRecordModel getById(@PathVariable Long id) {
        return recordService.getById(id);
    }

    @PostMapping
    public ProductionRecordModel create(@RequestBody ProductionRecordModel model) {
        return recordService.create(model);
    }

    @PutMapping("/{id}")
    public ProductionRecordModel update(@PathVariable Long id, @RequestBody ProductionRecordModel model) {
        return recordService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recordService.delete(id);
    }
}
