package br.com.dojo.todo.controller;

import br.com.dojo.todo.domains.Todo;
import br.com.dojo.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/todos")
@RequiredArgsConstructor
public class ToDoController {
    private final TodoService todoService;

    @GetMapping
    public Page<Todo> getTodoList(Pageable pageable, String headerUser) {
        return todoService.getPageableTodo(pageable, headerUser);
    }

    @PostMapping
    public Todo createTodo(Todo todo, String headerUser) {
        return todoService.createTodo(todo, headerUser);
    }

}