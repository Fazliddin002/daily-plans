package uz.pdp.daily_plans_program_b.dto;

import lombok.Value;
import uz.pdp.daily_plans_program_b.entity.Task;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link uz.pdp.daily_plans_program_b.entity.Reminder}
 */
@Value
public class ReminderDto implements Serializable {
    TaskDto taskDto;
    LocalDateTime reminderTime;
    String reminderText;
    boolean isSent;
}