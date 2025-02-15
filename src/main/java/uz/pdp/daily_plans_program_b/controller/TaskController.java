package uz.pdp.daily_plans_program_b.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.daily_plans_program_b.dto.ReminderDto;
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
    public HttpEntity<?> getAllTask() {
        return ResponseEntity.ok(taskService.getAll());
    }

    @GetMapping("{taskId}")
    public HttpEntity<?> getTask(@PathVariable UUID taskId) {
        return ResponseEntity.ok(taskService.getTask(taskId));
    }


    @PostMapping
    public HttpEntity<?> addTask(@RequestBody TaskDto taskDto, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(taskService.saveTask(taskDto, user));
    }

    @DeleteMapping({"{taskId}"})
    public HttpEntity<?> deleteTask(@PathVariable UUID taskId) {
        taskService.delete(taskId);
        return ResponseEntity.ok("Successfully deleted task");
    }

    @PutMapping("{taskId}")
    public HttpEntity<?> updateTask(@RequestBody TaskDto taskDto, @PathVariable UUID taskId) {
        taskService.update(taskDto, taskId);
        return ResponseEntity.ok("Successfully updated task");
    }


    ////TasksCheckStatus
    @GetMapping("/completed")
    public HttpEntity<?> getAllTaskCompleted() {
        return ResponseEntity.ok(taskService.getAllTasksCompleted());
    }

    @GetMapping("/inProgress")
    public HttpEntity<?> getAllTaskInProgress() {
        return ResponseEntity.ok(taskService.getAllTasksInProgressing());
    }

    @GetMapping("/archived")
    public HttpEntity<?> getAllTaskArchived() {
        return ResponseEntity.ok(taskService.getAllTasksInArchived());
    }

    @GetMapping("/failed")
    public HttpEntity<?> getAllTaskFailed() {
        return ResponseEntity.ok(taskService.getAllTasksFailed());
    }

    @GetMapping("/deleted")
    public HttpEntity<?> getAllTaskDeleted() {
        return ResponseEntity.ok(taskService.getAllTasksDeleted());
    }

    @GetMapping("/new")
    public HttpEntity<?> getAllTaskNew() {
        return ResponseEntity.ok(taskService.getAllTasksNew());
    }

    @GetMapping("/cancelled")
    public HttpEntity<?> getAllTaskCancelled() {
        return ResponseEntity.ok(taskService.getAllTasksCancelled());
    }

    @GetMapping("all")
    public HttpEntity<?> getAllTaskAll() {
        return ResponseEntity.ok(taskService.getAllTasksStatus());
    }
    ////TasksCheckStatusEnd

//    TasksCheckPriorityStart

    @GetMapping("default")
    public HttpEntity<?> getAllTaskPriorityDefault() {
        return ResponseEntity.ok(taskService.getAllTasksPriorityDefault());
    }

    @GetMapping("high")
    public HttpEntity<?> getAllTaskPriorityHigh() {
        return ResponseEntity.ok(taskService.getAllTasksPriorityHigh());
    }

    @GetMapping("allPriority")
    public HttpEntity<?> getAllTaskPriorityAll() {
        return ResponseEntity.ok(taskService.getAllTasksPriorityAll());
    }

    @GetMapping("medium")
    public HttpEntity<?> getAllTaskPriorityMedium() {
        return ResponseEntity.ok(taskService.getAllTasksPriorityMedium());
    }

    @GetMapping("low")
    public HttpEntity<?> getAllTaskPriorityLow() {
        return ResponseEntity.ok(taskService.getAllTasksPriorityLow());
    }

//    TasksCheckPriorityEnd

    @PostMapping("reminder/{taskId}")
    public HttpEntity<Void> reminderTask(@PathVariable UUID taskId, @AuthenticationPrincipal User user, @RequestBody ReminderDto reminderDto) {
        taskService.addReminderTask(taskId,user,reminderDto);
        return ResponseEntity.noContent().build();
    }


}
