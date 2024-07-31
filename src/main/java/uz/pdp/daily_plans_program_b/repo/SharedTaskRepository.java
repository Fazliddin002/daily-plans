package uz.pdp.daily_plans_program_b.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.daily_plans_program_b.entity.SharedTask;

import java.util.UUID;

public interface SharedTaskRepository extends JpaRepository<SharedTask, UUID> {
}