package uz.pdp.daily_plans_program_b.security.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import uz.pdp.daily_plans_program_b.security.entity.enums.RoleName;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "roles")
@Builder
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;


    @Override
    public String getAuthority() {
        return roleName.name();
    }

}