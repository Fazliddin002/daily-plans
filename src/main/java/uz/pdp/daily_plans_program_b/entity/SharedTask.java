package uz.pdp.daily_plans_program_b.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.daily_plans_program_b.entity.enums.SharedPermission;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

//Umumiy vazifa
public class SharedTask {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sharedWithUser;

    @Enumerated(EnumType.STRING)
    private SharedPermission permission;


}