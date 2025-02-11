package uz.pdp.daily_plans_program_b.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.daily_plans_program_b.entity.enums.RecurringFrequency;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RecurringTask {
//    Takroriy vazifa

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    private Task task;

    @Enumerated(EnumType.STRING)
    private RecurringFrequency frequency;

    @Column(nullable = false)
    private LocalDateTime startDate;

    private LocalDateTime endDate;

}