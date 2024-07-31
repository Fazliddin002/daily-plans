package uz.pdp.daily_plans_program_b.mappers;

import org.mapstruct.*;
import uz.pdp.daily_plans_program_b.dto.TaskDto;
import uz.pdp.daily_plans_program_b.entity.Task;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {
    Task toEntity(TaskDto taskDto);

    TaskDto toDto(Task task);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Task partialUpdate(TaskDto taskDto, @MappingTarget Task task);
}