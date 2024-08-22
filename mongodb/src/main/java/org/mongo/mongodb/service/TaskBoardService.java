package org.mongo.mongodb.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.mongo.mongodb.TaskBoard;
import org.mongo.mongodb.TaskBoardRepo;
import org.mongo.mongodb.exception.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TaskBoardService {
	
	@Autowired
    private TaskBoardRepo taskBoardRepo;
	
	@Autowired
	AtomicInteger atomicInteger=new AtomicInteger();
	
    public TaskBoard addTask(TaskBoard taskBoard) {
    	taskBoard.setDate(LocalDate.now());
    	taskBoard.setActualTime(LocalDateTime.now());
    	taskBoard.setEstimationTime(LocalDateTime.now().plusDays(2));
        return taskBoardRepo.save(taskBoard);
    }

    public TaskBoard getTaskById(String id) {
    	TaskBoard task = taskBoardRepo.findById(id).orElse(null);
    	if(task==null) {
    		throw new TaskNotFoundException("task "+id+" not found");
    	}
        return task;
    }

    public void deleteTaskById(String id) {
    	if(getTaskById(id)!=null){
    	taskBoardRepo.deleteById(id);
    	} else {
    		throw new TaskNotFoundException("task "+id+" not found");
    	}
    	
    }

    public TaskBoard updateTask(String id, TaskBoard taskBoard) {
        if (taskBoardRepo.existsById(id)) {
            taskBoard.setId(id);
            return taskBoardRepo.save(taskBoard);
        }else {
        	throw new TaskNotFoundException("task "+id+" task not found");
        }
    }
}
