package uz.pdp.daily_plans_program_b.dto;

import lombok.Value;
import uz.pdp.daily_plans_program_b.entity.enums.TaskPriority;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.pdp.daily_plans_program_b.entity.Task}
 */
@Value
public class TaskDto implements Serializable {
    String title;
    String description;
    TaskPriority priority;
    LocalDateTime endDate;
}