package com.example.smartfactory.service;

import com.example.smartfactory.entity.ProductionLine;
import com.example.smartfactory.model.ProductionLineModel;
import com.example.smartfactory.repository.ProductionLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionLineService {
    @Autowired
    private ProductionLineRepository lineRepository;

    public List<ProductionLineModel> getAll() {
        return lineRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public ProductionLineModel getById(Long id) {
        return lineRepository.findById(id).map(this::toModel).orElse(null);
    }

    public ProductionLineModel create(ProductionLineModel model) {
        ProductionLine line = new ProductionLine();
        line.setName(model.getName());
        line.setDescription(model.getDescription());
        return toModel(lineRepository.save(line));
    }

    public ProductionLineModel update(Long id, ProductionLineModel model) {
        Optional<ProductionLine> optional = lineRepository.findById(id);
        if (optional.isPresent()) {
            ProductionLine line = optional.get();
            line.setName(model.getName());
            line.setDescription(model.getDescription());
            return toModel(lineRepository.save(line));
        }
        return null;
    }

    public void delete(Long id) {
        lineRepository.deleteById(id);
    }

    private ProductionLineModel toModel(ProductionLine line) {
        ProductionLineModel model = new ProductionLineModel();
        model.setId(line.getId());
        model.setName(line.getName());
        model.setDescription(line.getDescription());
        return model;
    }
}
