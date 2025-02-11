package uz.pdp.daily_plans_program_b.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByPhone(String phone);
}