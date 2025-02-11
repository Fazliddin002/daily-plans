package uz.pdp.daily_plans_program_b.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.daily_plans_program_b.dto.TaskDto;
import uz.pdp.daily_plans_program_b.entity.Reminder;
import uz.pdp.daily_plans_program_b.dto.ReminderDto;
import uz.pdp.daily_plans_program_b.entity.Task;
import uz.pdp.daily_plans_program_b.mappers.ReminderMapper;
import uz.pdp.daily_plans_program_b.mappers.TaskMapper;
import uz.pdp.daily_plans_program_b.repo.ReminderRepository;
import uz.pdp.daily_plans_program_b.repo.TaskRepository;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.util.List;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class ReminderTaskService {
    private final ReminderRepository reminderRepository;
    private final ReminderMapper reminderMapper;
    private final TaskMapper taskMapper;

    public List<Reminder> getAll() {
        return reminderRepository.findAll();
    }


    public Reminder getTaskReminder(UUID reminderTaskId) {
        Reminder reminderTask = reminderRepository.findById(reminderTaskId).orElseThrow(() -> new RuntimeException("Reminder Task Not Found"));
        return reminderTask;
    }

    public Reminder saveTaskReminder(TaskDto taskDto, ReminderDto reminderDto, User user) {
        Task task = taskMapper.toEntity(taskDto);
        Reminder reminder = reminderMapper.toEntity(reminderDto);
        reminder.setTask(task);
        Reminder saved = reminderRepository.save(reminder);
        return saved;
    }

    public void delete(UUID reminderTaskId) {
        reminderRepository.deleteById(reminderTaskId);
    }

    public Reminder update(ReminderDto reminderDto, UUID reminderTaskId) {
        reminderRepository.findById(reminderTaskId).orElseThrow(() -> new RuntimeException("Reminder Task Not Found"));
        Reminder reminder = reminderMapper.toEntity(reminderDto);
        reminder.setId(reminderTaskId);
        return   reminderRepository.save(reminder);

    }
}
