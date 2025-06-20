package com.example.smartfactory.controller;

import com.example.smartfactory.model.DeviceModel;
import com.example.smartfactory.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
@CrossOrigin(origins = "*")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<DeviceModel> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public DeviceModel getDeviceById(@PathVariable Long id) {
        return deviceService.getDeviceById(id);
    }

    @PostMapping
    public DeviceModel createDevice(@RequestBody DeviceModel model) {
        return deviceService.createDevice(model);
    }

    @PutMapping("/{id}")
    public DeviceModel updateDevice(@PathVariable Long id, @RequestBody DeviceModel model) {
        return deviceService.updateDevice(id, model);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
    }
}
