package com.tasklist.backendspringboot.service;

import org.springframework.stereotype.Service;
import com.tasklist.backendspringboot.entity.Priority;
import com.tasklist.backendspringboot.repo.PriorityRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PriorityService {

    private final PriorityRepository repository;

    public PriorityService(PriorityRepository repository) {
        this.repository = repository;
    }

    public List<Priority> findAll() {
        return repository.findAllByOrderByIdAsc();
    }

    public Priority add(Priority priority) {
        return repository.save(priority);
    }

    public void update(Priority priority){
        repository.save(priority);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }

    public Priority findById(Long id){
        return repository.findById(id).get();
    }

    public List<Priority> findByTitle(String text){
        return repository.findByTitle(text);
    }

}
