package br.com.dojo.todo.repositories;

import br.com.dojo.todo.domains.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long> {
    Page<Todo> findByUser(Pageable pageable, String userId);
    int countTodoByUser(String userId);
}
