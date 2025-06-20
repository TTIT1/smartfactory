package com.example.smartfactory.model;

public class WorkerModel {
    private Long id;
    private String name;
    private String shift;
    private Long lineId;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public Long getLineId() { return lineId; }
    public void setLineId(Long lineId) { this.lineId = lineId; }
}