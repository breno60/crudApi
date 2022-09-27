package br.com.unifacisa.ToDo.repositories;

import br.com.unifacisa.ToDo.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    List<ToDo> findByName(String name);
}
