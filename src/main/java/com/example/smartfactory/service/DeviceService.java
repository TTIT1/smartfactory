
// DeviceService.java
package com.example.smartfactory.service;


import com.example.smartfactory.entity.Device;
import com.example.smartfactory.model.DeviceModel;
import com.example.smartfactory.repository.DeviceRepository;
import com.example.smartfactory.repository.ProductionLineRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private ProductionLineRepository lineRepository;

    public List<DeviceModel> getAllDevices() {
        return deviceRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public DeviceModel getDeviceById(Long id) {
        Optional<Device> device = deviceRepository.findById(id);
        return device.map(this::toModel).orElse(null);
    }

    public DeviceModel createDevice(DeviceModel model) {
        Device device = new Device();
        device.setName(model.getName());
        device.setStatus(model.getStatus());
        device.setLastUpdated(LocalDateTime.now());
        device.setProductionLine(lineRepository.findById(model.getLineId()).orElse(null));
        return toModel(deviceRepository.save(device));
    }

    public DeviceModel updateDevice(Long id, DeviceModel model) {
        Optional<Device> optional = deviceRepository.findById(id);
        if (optional.isPresent()) {
            Device device = optional.get();
            device.setName(model.getName());
            device.setStatus(model.getStatus());
            device.setLastUpdated(LocalDateTime.now());
            device.setProductionLine(lineRepository.findById(model.getLineId()).orElse(null));
            return toModel(deviceRepository.save(device));
        }
        return null;
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    private DeviceModel toModel(Device device) {
        DeviceModel model = new DeviceModel();
        model.setId(device.getId());
        model.setName(device.getName());
        model.setStatus(device.getStatus());
        model.setLastUpdated(device.getLastUpdated());
        model.setLineId(device.getProductionLine().getId());
        return model;
    }
}