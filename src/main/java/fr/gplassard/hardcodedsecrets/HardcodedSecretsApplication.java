package fr.gplassard.hardcodedsecrets;

import fr.gplassard.hardcodedsecrets.users.User;
import fr.gplassard.hardcodedsecrets.users.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class HardcodedSecretsApplication {
    private final UserRepository userRepository;

    public HardcodedSecretsApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(HardcodedSecretsApplication.class, args);
    }

    @Bean
    public CommandLineRunner setup() {
        return (args) -> {
            this.userRepository.saveAll(Arrays.asList(
               new User("user1", "First", "User"),
               new User("user2", "Second", "User"),
               new User("user3", "Third", "User"),
               new User("user4", "Forth", "User")
            ));
        };
    }

}
