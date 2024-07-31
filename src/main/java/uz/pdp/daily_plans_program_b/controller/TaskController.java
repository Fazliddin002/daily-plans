package uz.pdp.daily_plans_program_b.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.daily_plans_program_b.dto.TaskDto;
import uz.pdp.daily_plans_program_b.security.entity.User;
import uz.pdp.daily_plans_program_b.service.TaskService;

import java.util.UUID;

@RequestMapping("/api/task")
@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public HttpEntity<?> getAllTask(){
        return ResponseEntity.ok(taskService.getAll());
    }


    @PostMapping
    public HttpEntity<?> addTask(@RequestBody TaskDto taskDto, @AuthenticationPrincipal User user){
        return taskService.saveTask(taskDto,user);
    }

    @DeleteMapping({"{taskId}"})
    public HttpEntity<?> deleteTask(@PathVariable UUID taskId){
        return taskService.delete(taskId);
    }

    @PutMapping("{taskId}")
    public HttpEntity<?> updateTask(@RequestBody TaskDto taskDto, @PathVariable UUID taskId){
        return taskService.update(taskDto,taskId);
    }


    ////TasksCheckStatus
    @GetMapping("/completed")
    public HttpEntity<?> getAllTaskCompleted(){
        return ResponseEntity.ok(taskService.getAllTasksCompleted());
    }

    @GetMapping("/inProgress")
    public HttpEntity<?> getAllTaskInProgress(){
        return ResponseEntity.ok(taskService.getAllTasksInProgressing());
    }

    @GetMapping("/archived")
    public HttpEntity<?> getAllTaskArchived(){
        return ResponseEntity.ok(taskService.getAllTasksInArchived());
    }

    @GetMapping("/failed")
    public HttpEntity<?> getAllTaskFailed(){
        return ResponseEntity.ok(taskService.getAllTasksFailed());
    }
    @GetMapping("/failed")
    public HttpEntity<?> getAllTaskDeleted(){
        return ResponseEntity.ok(taskService.getAllTasksDeleted());
    }
    @GetMapping("/new")
    public HttpEntity<?> getAllTaskNew(){
        return ResponseEntity.ok(taskService.getAllTasksNew());
    }
    ////TasksCheckStatusEnd


}
