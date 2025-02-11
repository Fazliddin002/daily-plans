package uz.pdp.daily_plans_program_b.mappers;

import org.mapstruct.*;
import uz.pdp.daily_plans_program_b.dto.ReminderDto;
import uz.pdp.daily_plans_program_b.entity.Reminder;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ReminderMapper {
    Reminder toEntity(ReminderDto reminderDto);

    ReminderDto toDto(Reminder reminder);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Reminder partialUpdate(ReminderDto reminderDto, @MappingTarget Reminder reminder);
}