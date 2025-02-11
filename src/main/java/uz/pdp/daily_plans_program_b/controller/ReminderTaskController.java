package uz.pdp.daily_plans_program_b.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import uz.pdp.daily_plans_program_b.dto.ReminderDto;
import uz.pdp.daily_plans_program_b.security.entity.User;
import uz.pdp.daily_plans_program_b.service.ReminderTaskService;
import uz.pdp.daily_plans_program_b.service.TaskService;

import java.util.UUID;

@RestController
@RequestMapping("/api/reminder-task")
@RequiredArgsConstructor
public class ReminderTaskController {
    private final ReminderTaskService reminderTaskService;
    private final TaskService taskService;


    @GetMapping
    public HttpEntity<?> getAllTaskReminders() {
        return ResponseEntity.ok(reminderTaskService.getAll());
    }

    @GetMapping("{reminderTaskId}")
    public HttpEntity<?> getTaskReminder(@PathVariable UUID reminderTaskId) {
        return ResponseEntity.ok(reminderTaskService.getTaskReminder(reminderTaskId));
    }


    @PostMapping
    public HttpEntity<?> addTaskReminder(@RequestBody ReminderDto reminderDto, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(reminderTaskService.saveTaskReminder(reminderDto.getTaskDto(),reminderDto, user));
    }

    @DeleteMapping({"{reminderTaskId}"})
    public HttpEntity<?> deleteTaskReminder(@PathVariable UUID reminderTaskId) {
        reminderTaskService.delete(reminderTaskId);
        return ResponseEntity.ok("Deleted reminder task id: " + reminderTaskId);
    }

    @PutMapping("{reminderTaskId}")
    public HttpEntity<?> updateTaskReminder(@RequestBody ReminderDto reminderDto, @PathVariable UUID reminderTaskId) {
        return ResponseEntity.ok(reminderTaskService.update(reminderDto, reminderTaskId));
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
}
