package com.urfu.project.dto;

import lombok.Data;
import java.util.List;

@Data
public class TodoListRequest {
    private String name;
    private List<String> events;
}
