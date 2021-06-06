package com.myapps.taskmgmt.repositories;

import com.myapps.taskmgmt.domains.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

//    @Query("select distinct t.taskCategory from Task " )
//    List<Task> findTasksByTaskCategory(String taskCategory);

    @Query("select distinct recurrence from Task" )
    List<Boolean> findDistinctByTaskTypes();


}
