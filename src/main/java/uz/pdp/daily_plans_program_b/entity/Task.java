package uz.pdp.daily_plans_program_b.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GeneratedColumn;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import uz.pdp.daily_plans_program_b.entity.enums.TaskPriority;
import uz.pdp.daily_plans_program_b.entity.enums.TaskStatus;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;


    @Enumerated(EnumType.STRING)
    private TaskPriority priority;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private LocalDateTime completedAt;

    @ManyToOne
    private User user;

}