package br.com.dojo.todo.service;

import br.com.dojo.todo.domains.Todo;
import br.com.dojo.todo.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public Page<Todo> getPageableTodo(Pageable pageRequest, String userId) {
        return todoRepository.findByUser(pageRequest, userId);
    }

    public Todo createTodo(Todo todoComplete, String headerUser) {
        int count = todoRepository.countTodoByUser(headerUser);
        return null;
    }
}
