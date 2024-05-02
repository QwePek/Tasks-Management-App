package com.tasksmng.taskmanagement.Tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

public class TaskController {

    private final ITaskService taskService;

    public TaskController(ITaskService taskService) {
        this.taskService = taskService;
    }

    public ModelAndView GetAll() {
        List<Task> tasks = taskService.getAll();
        HashMap<String, Object> params = new HashMap<String,Object>();
        params.put("tasks", tasks);
        System.out.println(tasks.toString());

        return new ModelAndView("getAllTasks", params);
    }

    public String addTasks() {
        taskService.addTasks();
        return "Tasks added successfully...";
    }
}
