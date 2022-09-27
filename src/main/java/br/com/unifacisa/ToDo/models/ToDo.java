package br.com.unifacisa.ToDo.models;

import lombok.Data;

import javax.persistence.*;

@Entity @Data
@Table(name = "toDo")
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "isComplete")
    private boolean isComplete;

}
