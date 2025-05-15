package com.urfu.project.service;

import com.urfu.project.dto.TodoListRequest;
import com.urfu.project.dto.TodoListResponse;
import com.urfu.project.entity.Event;
import com.urfu.project.entity.TodoList;
import com.urfu.project.repository.TodoListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoListService {
    private final TodoListRepository todoListRepository;

    @Transactional
    public void saveTodoList(TodoListRequest request) {
        log.info("Сохранение нового todolist: {}", request.getName());

        TodoList todoList = new TodoList();
        todoList.setName(request.getName());

        List<Event> events = request.getEvents().stream()
                .map(description -> {
                    Event event = new Event();
                    event.setDescription(description);
                    event.setTodoList(todoList);
                    return event;
                })
                .collect(Collectors.toList());

        todoList.setEvents(events);
        todoListRepository.save(todoList);
        log.info("Todolist сохранен");
    }

    @Transactional(readOnly = true)
    public List<TodoListResponse> getAllTodoLists() {
        log.info("Извлечение всех todolists");
        return todoListRepository.findAll().stream()
                .map(todoList -> {
                    TodoListResponse response = new TodoListResponse();
                    response.setName(todoList.getName());
                    response.setEvents(todoList.getEvents().stream()
                            .map(Event::getDescription)
                            .collect(Collectors.toList()));
                    return response;
                })
                .collect(Collectors.toList());
    }
}
