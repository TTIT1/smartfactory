package com.example.smartfactory.controller;

import com.example.smartfactory.model.ProductionLineModel;
import com.example.smartfactory.service.ProductionLineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/lines")
@CrossOrigin(origins = "*")
@Tag(name = "Production Lines", description = "Quản lý dây chuyền sản xuất")
public class ProductionLineController {

    @Autowired
    private ProductionLineService lineService;

    @Operation(summary = "Lấy danh sách tất cả dây chuyền")
    @GetMapping
    public List<ProductionLineModel> getAll() {
        return lineService.getAll();
    }

    @Operation(summary = "Lấy dây chuyền theo ID")
    @GetMapping("/{id}")
    public ProductionLineModel getById(@PathVariable Long id) {
        return lineService.getById(id);
    }

    @Operation(summary = "Tạo mới một dây chuyền")
    @PostMapping
    public ProductionLineModel create(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Thông tin dây chuyền") 
        @RequestBody ProductionLineModel model) {
        return lineService.create(model);
    }

    @Operation(summary = "Cập nhật dây chuyền theo ID")
    @PutMapping("/{id}")
    public ProductionLineModel update(
        @PathVariable Long id,
        @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Thông tin cập nhật") 
        @RequestBody ProductionLineModel model) {
        return lineService.update(id, model);
    }

    @Operation(summary = "Xóa dây chuyền theo ID")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lineService.delete(id);
    }
}
