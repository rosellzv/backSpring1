package com.example.demo.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter
    private Long id;
    @Setter @Getter
    private String title;
    @Setter @Getter
    private String description;
    @Setter @Getter
    private LocalDateTime createdDate;
    @Setter @Getter
    private LocalDateTime eta;
    @Setter @Getter
    private boolean finished;
    @Setter @Getter
    private Taskstatus taskstatus;


}
