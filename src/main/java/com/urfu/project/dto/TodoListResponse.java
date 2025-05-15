package com.urfu.project.dto;

import lombok.Data;
import java.util.List;

@Data
public class TodoListResponse {
    private String name;
    private List<String> events;
}
