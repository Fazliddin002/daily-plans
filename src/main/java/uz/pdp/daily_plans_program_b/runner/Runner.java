package uz.pdp.daily_plans_program_b.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.daily_plans_program_b.repo.TaskRepository;
import uz.pdp.daily_plans_program_b.security.repo.RoleRepository;
import uz.pdp.daily_plans_program_b.security.repo.UserRepository;
import uz.pdp.daily_plans_program_b.security.entity.Role;
import uz.pdp.daily_plans_program_b.security.entity.User;
import uz.pdp.daily_plans_program_b.security.entity.enums.RoleName;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {
    private final TaskRepository taskRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public void run(String... args) throws Exception {
//        for (int i = 1; i <= 5; i++) {
//            Task task = new Task();
//            task.setId(UUID.randomUUID());
//            task.setTitle("Task " + i);
//            task.setDescription("Description for task " + i);
//            task.setTaskStatus(TaskStatus.DELETED);
//            task.setPriority(TaskPriority.LOW);
//            task.setCreatedAt(LocalDateTime.now());
//            task.setUpdatedAt(LocalDateTime.now());
//            task.setUser(null);
//            taskRepository.save(task);
//        }



//        Role adminRole =  Role.builder().roleName(RoleName.ROLE_ADMIN).build();
//        Role userRole =   Role.builder().roleName(RoleName.ROLE_USER).build();
//        roleRepository.saveAll(List.of(adminRole,userRole));
//
//
        // Creating default users
//        User admin1 = new User();
//        admin1.setId(UUID.randomUUID());
//        admin1.setPhone("999");
//        admin1.setPassword(passwordEncoder.encode("root123"));
//        admin1.setFirstName("Admin");
//        admin1.setLastName("User");
//        admin1.setRoles(Arrays.asList(adminRole));

//        User user = new User();
//        user.setId(UUID.randomUUID());
//        user.setPhone("user_phone");
//        user.setPassword(passwordEncoder.encode("user_password"));
//        user.setFirstName("Regular");
//        user.setLastName("User");
//        user.setRoles(Arrays.asList(userRole));
//
//        // Save users to the repository
//        userRepository.save(admin);
//        userRepository.save(user);
//        userRepository.save(admin1);

    }
}
