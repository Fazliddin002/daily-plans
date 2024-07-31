package uz.pdp.daily_plans_program_b.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.daily_plans_program_b.entity.TaskTag;

import java.util.UUID;

public interface TaskTagRepository extends JpaRepository<TaskTag, UUID> {
}