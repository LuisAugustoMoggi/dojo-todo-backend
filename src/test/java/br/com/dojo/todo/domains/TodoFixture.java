package br.com.dojo.todo.domains;

import java.time.LocalDateTime;

public class TodoFixture {


    public static Todo todoComplete() {
        return Todo.builder()
                .todoId(1L)
                .title("Teste")
                .description("description test")
                .dueDate(LocalDateTime.of(2022, 1, 1, 12, 0))
                .user("user-1")
                .status(TodoStatus.TODO)
                .build();
    }

}
