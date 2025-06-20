package com.example.smartfactory.controller;

import com.example.smartfactory.model.ProductionLineModel;
import com.example.smartfactory.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lines")
@CrossOrigin(origins = "*")
public class ProductionLineController {

    @Autowired
    private ProductionLineService lineService;

    @GetMapping
    public List<ProductionLineModel> getAll() {
        return lineService.getAll();
    }

    @GetMapping("/{id}")
    public ProductionLineModel getById(@PathVariable Long id) {
        return lineService.getById(id);
    }

    @PostMapping
    public ProductionLineModel create(@RequestBody ProductionLineModel model) {
        return lineService.create(model);
    }

    @PutMapping("/{id}")
    public ProductionLineModel update(@PathVariable Long id, @RequestBody ProductionLineModel model) {
        return lineService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lineService.delete(id);
    }
}
