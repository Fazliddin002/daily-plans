package uz.pdp.daily_plans_program_b.service;

import lombok.Value;
import uz.pdp.daily_plans_program_b.entity.enums.TaskPriority;
import uz.pdp.daily_plans_program_b.entity.enums.TaskStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.pdp.daily_plans_program_b.entity.Task}
 */
@Value
public class TaskDto implements Serializable {
    String title;
    String description;
    TaskStatus taskStatus;
    TaskPriority priority;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime startDate;
    LocalDateTime endDate;
    LocalDateTime completedAt;
}