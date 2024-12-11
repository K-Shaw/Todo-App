package com.app.todoapp.controller;

import com.app.todoapp.data.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = this.taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public void setTask(@RequestBody Task task){
//        this.taskService.addTask(task);
//    }

    @PostMapping
    public String createTask(@RequestParam String title){
        this.taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTasks(@PathVariable long id){
        this.taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTasks(@PathVariable long id){
        this.taskService.toggleTask(id);
        return "redirect:/";
    }
}
