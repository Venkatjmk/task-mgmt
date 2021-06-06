package com.myapps.taskmgmt.services;

import com.myapps.taskmgmt.domains.Task;
import com.myapps.taskmgmt.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks(String userId) {
        List<Task> tasks = new ArrayList<>();

        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    public Task getTaskByTaskId(long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        return task.orElse(null);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void updateTask(Task task) {
        taskRepository.save(task);
    }

    public void removeTask(long taskId) {
        taskRepository.deleteById(taskId);
    }

    /*public List<String> getAllCategories() {
        List<String> result = new ArrayList<>();
        List<Task> distinctCategories = taskRepository.findAllDistinctTaskCategory();
        distinctCategories.forEach((task) -> result.add(task.getTaskCategory()));
        return result;
    }*/

    public List<Boolean> getAllTaskTypes() {
//        List<String> result = new ArrayList<>();
        return taskRepository.findDistinctByTaskTypes();
        /*distinctTaskTypes.forEach((task) -> result.add(task.getTaskType()));
        return result;*/
    }
}
