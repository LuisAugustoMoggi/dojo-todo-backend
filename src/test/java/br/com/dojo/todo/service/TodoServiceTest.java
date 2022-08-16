package br.com.dojo.todo.service;

import br.com.dojo.todo.domains.Todo;
import br.com.dojo.todo.domains.TodoFixture;
import br.com.dojo.todo.repositories.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TodoServiceTest {

    TodoRepository todoRepository = Mockito.mock(TodoRepository.class);

    TodoService todoService = new TodoService(todoRepository);

    @Test
    public void shouldGetPageableTodosEmpty() {
        Pageable pageable = PageRequest.of(0, 10);
        String userId = "user-1";

        Mockito.doReturn(Page.empty())
                .when(todoRepository)
                .findByUser(PageRequest.of(0, 10), userId);

        final Page<Todo> result = todoService.getPageableTodo(pageable, userId);

        Mockito.verify(todoRepository)
                .findByUser(PageRequest.of(0, 10), userId);

        Assertions.assertEquals(0, result.get().count());
    }

    @Test
    public void shouldGetPageableTodosNull() {
        Pageable pageable = PageRequest.of(0, 10);
        String userId = "user-1";

        Mockito.doReturn(null)
                .when(todoRepository)
                .findByUser(PageRequest.of(0, 10), userId);

        final Page<Todo> result = todoService.getPageableTodo(pageable, userId);

        Mockito.verify(todoRepository)
                .findByUser(PageRequest.of(0, 10), userId);

        Assertions.assertNull(result);
    }

    @Test
    public void shouldGetPageableTodos() {
        Pageable pageable = PageRequest.of(0, 10);
        String userId = "user-1";

        Mockito.doReturn(new PageImpl<Todo>(List.of(TodoFixture.todoComplete())))
                .when(todoRepository)
                .findByUser(PageRequest.of(0, 10), userId);

        final Page<Todo> result = todoService.getPageableTodo(pageable, userId);

        Mockito.verify(todoRepository)
                .findByUser(PageRequest.of(0, 10), userId);

        Assertions.assertEquals(1, result.getContent().size());
        Assertions.assertEquals(TodoFixture.todoComplete(), result.getContent().get(0));
    }

}