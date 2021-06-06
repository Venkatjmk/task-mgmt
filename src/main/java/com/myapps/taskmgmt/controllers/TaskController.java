package com.myapps.taskmgmt.controllers;

import com.myapps.taskmgmt.domains.Task;
import com.myapps.taskmgmt.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/tasks/listAll/{userId}", method = RequestMethod.GET)
    public List<Task> getAllTasksForGivenUser(@PathVariable String userId) {
        if (!StringUtils.isEmpty(userId)) {
            return taskService.getTasks(userId);
        }

        return null;
    }

    @RequestMapping(value = "/tasks/taskById/{taskId}")
    public Task getTaskById(@PathVariable long taskId) {
        return taskService.getTaskByTaskId(taskId);
    }

    @RequestMapping(value = "/tasks/addTask", method = RequestMethod.POST)
    public boolean addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return true;
    }

    @RequestMapping(value = "/tasks/updateTask", method = RequestMethod.PUT)
    public boolean updateTask(@RequestBody Task task) {
        taskService.updateTask(task);
        return true;
    }

    @RequestMapping(value = "/tasks/deleteById", method = RequestMethod.DELETE)
    public boolean removeTask(@PathVariable long taskId) {
        taskService.removeTask(taskId);
        return true;
    }

    @RequestMapping(value = "/tasks/listAllTaskTypes")
    public List<Boolean> getAllTaskTypes() {
        return taskService.getAllTaskTypes();
    }
}
