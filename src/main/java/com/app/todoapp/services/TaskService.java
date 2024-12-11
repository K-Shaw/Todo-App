package com.app.todoapp.services;

import com.app.todoapp.data.Task;
import com.app.todoapp.data.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        Iterable<Task> tasks = this.taskRepository.findAll();
        List<Task> res = new ArrayList<>();
        tasks.forEach(task ->{res.add(task);});
        return res;
    }

//    public void addTask(Task task){
//        taskRepository.save(task);
//    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setComplete(false);
        this.taskRepository.save(task);
    }

    public void deleteTask(long id){
        this.taskRepository.deleteById(id);
    }

    public void toggleTask(long id){
        Task temp = this.taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Id"));
        temp.setComplete(!temp.isComplete());
        taskRepository.save(temp);
    }
}
