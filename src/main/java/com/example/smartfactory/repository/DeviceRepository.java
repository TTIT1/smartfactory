package com.example.smartfactory.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.smartfactory.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
