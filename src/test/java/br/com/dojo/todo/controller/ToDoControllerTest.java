package  br.com.dojo.todo.controller;

import br.com.dojo.todo.domains.Todo;
import br.com.dojo.todo.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static br.com.dojo.todo.domains.TodoFixture.todoComplete;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ToDoControllerTest {
    TodoService service = Mockito.mock(TodoService.class);
    ToDoController controller = new ToDoController(service);

    @Test
    public void shouldGetTodoListEmpty() {
        Pageable pageable = PageRequest.of(0, 10);
        String headerUser = "user-1";

        doReturn(Page.empty())
                .when(service)
                .getPageableTodo(PageRequest.of(0, 10), "user-1");

        Page<Todo> result = controller.getTodoList(pageable, headerUser);

        verify(service)
                .getPageableTodo(PageRequest.of(0, 10), "user-1");

        Assertions.assertEquals(0,result.get().count());
    }

    @Test
    public void shouldGetTodoListNull() {
        Pageable pageable = PageRequest.of(0, 10);
        String headerUser = "user-1";

        doReturn(null)
                .when(service)
                .getPageableTodo(PageRequest.of(0, 10), "user-1");

        Page<Todo> result = controller.getTodoList(pageable, headerUser);

        verify(service)
                .getPageableTodo(PageRequest.of(0, 10), "user-1");

        Assertions.assertNull(result);
    }

    @Test
    public void shouldGetTodoList() {
        Pageable pageable = PageRequest.of(0, 10);
        String headerUser = "user-1";

        doReturn(new PageImpl<Todo>(List.of(todoComplete())))
                .when(service)
                .getPageableTodo(PageRequest.of(0, 10), "user-1");

        Page<Todo> result = controller.getTodoList(pageable, headerUser);

        verify(service)
                .getPageableTodo(PageRequest.of(0, 10), "user-1");

        Assertions.assertEquals(1, result.getContent().size());
        Assertions.assertEquals(todoComplete(), result.getContent().get(0));
    }

    @Test
    public void shouldCreateTodo() {
        Todo todo = todoComplete();
        controller.createTodo(todo);


    }


}