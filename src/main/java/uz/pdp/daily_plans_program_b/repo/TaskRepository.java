package uz.pdp.daily_plans_program_b.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.daily_plans_program_b.entity.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
      Optional<Task> findByTitle(String title);
}