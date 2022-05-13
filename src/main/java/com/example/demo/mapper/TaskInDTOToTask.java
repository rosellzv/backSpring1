package com.example.demo.mapper;

import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.Taskstatus;
import com.example.demo.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{
    @Override
    public  Task map(TaskInDTO in){
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskstatus(Taskstatus.ON_TIME);
        return task;
    }
}
