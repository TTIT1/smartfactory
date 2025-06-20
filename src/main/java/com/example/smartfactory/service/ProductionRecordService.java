package com.example.smartfactory.service;

import com.example.smartfactory.entity.Device;
import com.example.smartfactory.entity.ProductionRecord;
import com.example.smartfactory.model.ProductionRecordModel;
import com.example.smartfactory.repository.DeviceRepository;
import com.example.smartfactory.repository.ProductionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductionRecordService {
    @Autowired
    private ProductionRecordRepository recordRepository;

    @Autowired
    private DeviceRepository deviceRepository;

    public List<ProductionRecordModel> getAll() {
        return recordRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public ProductionRecordModel getById(Long id) {
        return recordRepository.findById(id).map(this::toModel).orElse(null);
    }

    public ProductionRecordModel create(ProductionRecordModel model) {
        ProductionRecord record = new ProductionRecord();
        record.setQuantity(model.getQuantity());
        record.setTimestamp(model.getTimestamp() != null ? model.getTimestamp() : LocalDateTime.now());
        Device device = deviceRepository.findById(model.getDeviceId()).orElse(null);
        record.setDevice(device);
        return toModel(recordRepository.save(record));
    }

    public ProductionRecordModel update(Long id, ProductionRecordModel model) {
        Optional<ProductionRecord> optional = recordRepository.findById(id);
        if (optional.isPresent()) {
            ProductionRecord record = optional.get();
            record.setQuantity(model.getQuantity());
            record.setTimestamp(model.getTimestamp());
            Device device = deviceRepository.findById(model.getDeviceId()).orElse(null);
            record.setDevice(device);
            return toModel(recordRepository.save(record));
        }
        return null;
    }

    public void delete(Long id) {
        recordRepository.deleteById(id);
    }

    private ProductionRecordModel toModel(ProductionRecord record) {
        ProductionRecordModel model = new ProductionRecordModel();
        model.setId(record.getId());
        model.setQuantity(record.getQuantity());
        model.setTimestamp(record.getTimestamp());
        model.setDeviceId(record.getDevice().getId());
        return model;
    }
}
