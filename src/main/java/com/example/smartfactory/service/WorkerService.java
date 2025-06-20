package com.example.smartfactory.service;

import com.example.smartfactory.entity.ProductionLine;
import com.example.smartfactory.entity.Worker;
import com.example.smartfactory.model.WorkerModel;
import com.example.smartfactory.repository.ProductionLineRepository;
import com.example.smartfactory.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ProductionLineRepository lineRepository;

    public List<WorkerModel> getAll() {
        return workerRepository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    public WorkerModel getById(Long id) {
        return workerRepository.findById(id).map(this::toModel).orElse(null);
    }

    public WorkerModel create(WorkerModel model) {
        Worker worker = new Worker();
        worker.setName(model.getName());
        worker.setShift(model.getShift());
        ProductionLine line = lineRepository.findById(model.getLineId()).orElse(null);
        worker.setProductionLine(line);
        return toModel(workerRepository.save(worker));
    }

    public WorkerModel update(Long id, WorkerModel model) {
        Optional<Worker> optional = workerRepository.findById(id);
        if (optional.isPresent()) {
            Worker worker = optional.get();
            worker.setName(model.getName());
            worker.setShift(model.getShift());
            ProductionLine line = lineRepository.findById(model.getLineId()).orElse(null);
            worker.setProductionLine(line);
            return toModel(workerRepository.save(worker));
        }
        return null;
    }

    public void delete(Long id) {
        workerRepository.deleteById(id);
    }

    private WorkerModel toModel(Worker w) {
        WorkerModel m = new WorkerModel();
        m.setId(w.getId());
        m.setName(w.getName());
        m.setShift(w.getShift());
        m.setLineId(w.getProductionLine().getId());
        return m;
    }
}
