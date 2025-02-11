package uz.pdp.daily_plans_program_b.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.pdp.daily_plans_program_b.dto.ReminderDto;
import uz.pdp.daily_plans_program_b.dto.TaskDto;
import uz.pdp.daily_plans_program_b.entity.Reminder;
import uz.pdp.daily_plans_program_b.entity.Task;
import uz.pdp.daily_plans_program_b.entity.enums.TaskPriority;
import uz.pdp.daily_plans_program_b.entity.enums.TaskStatus;
import uz.pdp.daily_plans_program_b.mappers.TaskMapper;
import uz.pdp.daily_plans_program_b.repo.ReminderRepository;
import uz.pdp.daily_plans_program_b.repo.TaskRepository;
import uz.pdp.daily_plans_program_b.security.entity.User;
import uz.pdp.daily_plans_program_b.sms.SmsService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final ReminderRepository reminderRepository;
    private final SmsService smsService;

    ///CRUD START
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task saveTask(TaskDto taskDto, User user) {
        Task task = taskMapper.toEntity(taskDto);
        task.setUser(user);
        task.setTaskStatus(TaskStatus.NEW);
        Task saved = taskRepository.save(task);
        return saved;
    }

    public void delete(UUID taskId) {
        taskRepository.deleteById(taskId);

    }

    public Task update(TaskDto taskDto, UUID taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        Task taskMapperEntity = taskMapper.toEntity(taskDto);
        taskMapperEntity.setId(task.getId());
        taskMapperEntity.setUser(task.getUser());
      return   taskRepository.save(taskMapperEntity);

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

    public List<Task> getAllTasksNew() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.NEW).toList();
    }

    public List<Task> getAllTasksCancelled() {
        return taskRepository.findAll().stream().filter((task) -> task.getTaskStatus() == TaskStatus.CANCELLED).toList();
    }

    public List<Task> getAllTasksStatus() {
        return taskRepository.findAll();
    }


    //////TaskCheckStatusEnd


    ////TasksCheckPriorityStart

    public List<Task> getAllTasksPriorityDefault() {
        return taskRepository.findAll().stream().filter((task -> task.getPriority()== TaskPriority.DEFAULT)).toList();
    }

    public List<Task> getAllTasksPriorityLow() {
        return taskRepository.findAll().stream().filter((task -> task.getPriority()== TaskPriority.LOW)).toList();
    }

    public List<Task> getAllTasksPriorityMedium() {
        return taskRepository.findAll().stream().filter((task -> task.getPriority()== TaskPriority.MEDIUM)).toList();
    }

    public List<Task> getAllTasksPriorityHigh() {
        return taskRepository.findAll().stream().filter((task -> task.getPriority()== TaskPriority.HIGH)).toList();
    }
    public List<Task> getAllTasksPriorityAll() {
        return taskRepository.findAll();
    }

    public Task getTask(UUID taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    ////TasksCheckPriorityEnd

    public void addReminderTask(UUID taskId, User user, ReminderDto reminderDto) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        Reminder reminder = new Reminder();
        reminder.setTask(task);
        reminder.setReminderTime(reminderDto.getReminderTime());
        reminder.setReminderText(reminderDto.getReminderText());
        reminder.setSent(false);
        reminderRepository.save(reminder);

        if (reminder.getReminderTime().equals(LocalDateTime.now())) {
//            user.getPhone().send sms
            smsService.sendSMS(user,reminder.getReminderText());
            reminder.setSent(true);
        }
    }
}
