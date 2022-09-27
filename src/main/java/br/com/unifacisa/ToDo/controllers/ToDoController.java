package br.com.unifacisa.ToDo.controllers;

import br.com.unifacisa.ToDo.models.ToDo;
import br.com.unifacisa.ToDo.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ToDo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping
    public ResponseEntity<List<ToDo>> getAllToDo () {
        return new ResponseEntity<List<ToDo>>(toDoService.getAllToDo(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ToDo>> getOneToDo (@PathVariable int id) {
        Optional<ToDo> toDo = toDoService.getOneToDo(id);
        if (toDo.isPresent()) {
            return new ResponseEntity<Optional<ToDo>>(toDo, HttpStatus.OK);
        }
        return new ResponseEntity<Optional<ToDo>>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<ToDo>> getToDoByName (@PathVariable String name) {
        return new ResponseEntity<List<ToDo>>(toDoService.getToDoByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ToDo> createToDo (@RequestBody ToDo toDo) {
        return new ResponseEntity<ToDo>(toDoService.createToDo(toDo), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Optional<ToDo>> updateToDo (@RequestBody ToDo toDo) {
        Optional<ToDo> toDoOptional = toDoService.updateToDo(toDo);
        if (toDoOptional.isPresent()) {
            return new ResponseEntity<Optional<ToDo>>(toDoOptional, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteToDoById (@PathVariable int id) {
        if (toDoService.deleteById(id)) {
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        }
        return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

}
