package uz.pdp.daily_plans_program_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DailyPlansProgramBApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyPlansProgramBApplication.class, args);
    }

}
