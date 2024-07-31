package uz.pdp.daily_plans_program_b.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import uz.pdp.daily_plans_program_b.entity.enums.SharedPermission;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "shared_task")
public class SharedTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "shared_with_user_id", nullable = false)
    private User sharedWithUser;

    @Enumerated(EnumType.STRING)
    private SharedPermission permission;


}