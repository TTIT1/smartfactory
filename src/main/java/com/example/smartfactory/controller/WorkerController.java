package com.example.smartfactory.controller;

import com.example.smartfactory.model.WorkerModel;
import com.example.smartfactory.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workers")
@CrossOrigin(origins = "*")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping
    public List<WorkerModel> getAll() {
        return workerService.getAll();
    }

    @GetMapping("/{id}")
    public WorkerModel getById(@PathVariable Long id) {
        return workerService.getById(id);
    }

    @PostMapping
    public WorkerModel create(@RequestBody WorkerModel model) {
        return workerService.create(model);
    }

    @PutMapping("/{id}")
    public WorkerModel update(@PathVariable Long id, @RequestBody WorkerModel model) {
        return workerService.update(id, model);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        workerService.delete(id);
    }
}
