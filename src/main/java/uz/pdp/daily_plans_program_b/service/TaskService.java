package uz.pdp.daily_plans_program_b.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.daily_plans_program_b.dto.TaskDto;
import uz.pdp.daily_plans_program_b.entity.Task;
import uz.pdp.daily_plans_program_b.entity.enums.TaskStatus;
import uz.pdp.daily_plans_program_b.mappers.TaskMapper;
import uz.pdp.daily_plans_program_b.repo.TaskRepository;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
     ///CRUD START
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public HttpEntity<?> saveTask(TaskDto taskDto, User user) {
        Task task = taskMapper.toEntity(taskDto);
        task.setUser(user);
        task.setTaskStatus(TaskStatus.NEW);
        Task saved = taskRepository.save(task);
        return ResponseEntity.ok(saved);
    }

    public HttpEntity<?> delete(UUID taskId) {
        taskRepository.deleteById(taskId);
        return ResponseEntity.ok("Successfully deleted task");
    }

    public HttpEntity<?> update(TaskDto taskDto, UUID taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setDescription(taskDto.getDescription());
        task.setPriority(taskDto.getPriority());
        task.setTitle(taskDto.getTitle());
        task.setEndDate(taskDto.getEndDate());
        taskRepository.save(task);
        return ResponseEntity.ok("Successfully updated task");
    }

    ///CRUD END

    //////TaskCheckStatusStart

    public List<Task> getAllTasksCompleted() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.COMPLETED).toList();
    }

    public List<Task> getAllTasksInProgressing() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.IN_PROGRESS).toList();
    }

    public List<Task> getAllTasksInArchived() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.ARCHIVED).toList();
    }

    public List<Task> getAllTasksFailed() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.FAILED).toList();
    }

    public List<Task> getAllTasksDeleted() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.DELETED).toList();
    }

    public Object getAllTasksNew() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.NEW).toList();
    }


    //////TaskCheckStatusEnd

}
