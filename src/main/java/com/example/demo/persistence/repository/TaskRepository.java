package com.example.demo.persistence.repository;

import com.example.demo.persistence.entity.Task;
import com.example.demo.persistence.entity.Taskstatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskstatus(Taskstatus taskstatus);

    @Modifying
    @Query(value = "UPDATE task SET finished = true WHERE id = :id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
