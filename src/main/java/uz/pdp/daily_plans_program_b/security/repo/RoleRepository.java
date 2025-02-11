package uz.pdp.daily_plans_program_b.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.daily_plans_program_b.security.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}