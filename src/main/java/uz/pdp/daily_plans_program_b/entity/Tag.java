package uz.pdp.daily_plans_program_b.entity;

import jakarta.persistence.*;
import lombok.*;
import uz.pdp.daily_plans_program_b.security.entity.User;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}