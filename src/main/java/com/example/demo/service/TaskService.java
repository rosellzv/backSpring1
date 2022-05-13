package com.example.demo.service;

import com.example.demo.exception.todoExceptions;
import com.example.demo.mapper.TaskInDTOToTask;
import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.Taskstatus;
import com.example.demo.persistence.repository.TaskRepository;
import com.example.demo.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }
    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll(){
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(Taskstatus status){
        return this.repository.findAllByTaskstatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new todoExceptions( "dsbsdjbfsdj",HttpStatus.NOT_FOUND);
        }
        this.repository.markTaskAsFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()){
            throw new todoExceptions( "dsbsdjbfsdj",HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }

}
