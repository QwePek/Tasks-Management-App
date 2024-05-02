package com.tasksmng.taskmanagement.Tasks;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public class TaskService  {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String getString() {
        return "elo srako";
    }
//
//    public List<Task> getAll() {
//        return (List<Task>)taskRepository.findAll();
//    }

    public void addTasks() {
        for (int i = 0; i < 50; i++) {
            Task task = new Task();
            task.setTitle("Title " + i);
            task.setCreationDate(LocalDate.now());
            task.setDueDate(LocalDate.now().plusDays(i));
            task.setDescription("Description " + i);
//            taskRepository.save(task);
        }
    }
}
