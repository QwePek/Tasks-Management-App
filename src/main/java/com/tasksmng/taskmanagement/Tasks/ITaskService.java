package com.tasksmng.taskmanagement.Tasks;

import java.util.List;

public interface ITaskService {
    List<Task> getAll();
    public void addTasks();
}
