package org.mongo.mongodb.controller;

import java.util.Optional;

import org.mongo.mongodb.TaskBoard;
import org.mongo.mongodb.service.TaskBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.messaging.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskBoardController {
	
	@Autowired
	private TaskBoardService taskBoardService;
	
	@PostMapping("/addtask")
	public 	ResponseEntity<TaskBoard> addTask(@RequestBody TaskBoard taskBoard){
		TaskBoard task = taskBoardService.addTask(taskBoard);
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}
	
	@DeleteMapping("/deletetask/{id}")
	public 	ResponseEntity<String> deleteTask(@PathVariable("id") String taskId){
		taskBoardService.deleteTaskById(taskId);
		return ResponseEntity.status(HttpStatus.OK).body("Sucessfully deleted "+taskId);
	}
	
	@GetMapping("/task/{id}")
	public 	ResponseEntity<TaskBoard> getTask(@PathVariable("id") String taskId){
		TaskBoard task = taskBoardService.getTaskById(taskId);
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}
	
	@PutMapping("/updatetask/{id}")
	public ResponseEntity<TaskBoard> updateTask(@PathVariable("id") String taskId, @RequestBody TaskBoard taskBoard){
		TaskBoard task = taskBoardService.updateTask(taskId, taskBoard);
		return ResponseEntity.status(HttpStatus.OK).body(task);
	}

}
