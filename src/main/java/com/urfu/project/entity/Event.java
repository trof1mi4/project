package com.urfu.project.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "event")
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "todo_list_id")
    private TodoList todoList;
}
