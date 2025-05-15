package com.urfu.project.controller;

import com.urfu.project.dto.TodoListRequest;
import com.urfu.project.dto.TodoListResponse;
import com.urfu.project.service.TodoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/todolist")
@RequiredArgsConstructor
@Log4j2
public class TodoListController {
    private final TodoListService todoListService;

    @PostMapping
    public void saveTodoList(@RequestBody TodoListRequest request) {
        log.info("Запрос на сохранение: {}", request.getName());
        todoListService.saveTodoList(request);
    }

    @GetMapping
    public List<TodoListResponse> getAllTodoLists() {
        log.info("Запрос на извлечение");
        return todoListService.getAllTodoLists();
    }
}
