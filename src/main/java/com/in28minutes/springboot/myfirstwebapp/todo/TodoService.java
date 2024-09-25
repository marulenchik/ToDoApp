package com.in28minutes.springboot.myfirstwebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;
import java.util.function.Predicate;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();

    private static int todosCount = 3;
    static {
        todos.add(new Todo(1, "m", "Learn Spring", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(2, "Marlen", "Learn Figma", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(3, "Marlen", "Learn Shopify", LocalDate.now().plusYears(1),false));
    }

    public List<Todo> findByUsername(String username){
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate target, boolean done){
        Todo todo = new Todo(++todosCount, username, description, target, done);
        todos.add(todo);
    }

    public void removeTodoById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id){
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }


    public void updateTodo(Todo todo) {
        removeTodoById(todo.getId());
        todos.add(todo);
    }
}
