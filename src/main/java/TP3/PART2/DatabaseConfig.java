package TP3.PART2;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "TP3.PART2.repository")
public class DatabaseConfig {
}