package br.com.unifacisa.ToDo.services;

import br.com.unifacisa.ToDo.models.ToDo;
import br.com.unifacisa.ToDo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDo() {
        return toDoRepository.findAll();
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public Optional<ToDo> getOneToDo(int id) {
        return toDoRepository.findById(id);
    }

    public List<ToDo> getToDoByName(String name) {
        return toDoRepository.findByName(name);
    }

    public Optional<ToDo> updateToDo(ToDo toDo) {
        Optional<ToDo> toDoOptional = this.getOneToDo(toDo.getId());
        if (toDoOptional.isPresent()) {
            toDoOptional.get().setName(toDo.getName());
            toDoOptional.get().setComplete(toDo.isComplete());
            toDoRepository.save(toDoOptional.get());
        } return toDoOptional;
    }

    public boolean deleteById(int id) {
        Optional<ToDo> toDoOptional = this.getOneToDo(id);
        boolean found = false;
        if (toDoOptional.isPresent()) {
            toDoRepository.deleteById(id);
            found = true;
        }
        return found;
    }

}
