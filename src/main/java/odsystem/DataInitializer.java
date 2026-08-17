package odsystem;

import odsystem.entity.User;
import odsystem.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository repository) {

        return args -> {

            if (repository.findByEmail("student@gmail.com") == null) {

                User student = new User();
                student.setName("Student");
                student.setEmail("student@gmail.com");
                student.setPassword("1234");
                student.setRole("STUDENT");

                repository.save(student);
            }

            if (repository.findByEmail("proctor@gmail.com") == null) {

                User proctor = new User();
                proctor.setName("Proctor");
                proctor.setEmail("proctor@gmail.com");
                proctor.setPassword("1234");
                proctor.setRole("PROCTOR");

                repository.save(proctor);
            }

            if (repository.findByEmail("ac@gmail.com") == null) {

                User ac = new User();
                ac.setName("Academic Coordinator");
                ac.setEmail("ac@gmail.com");
                ac.setPassword("1234");
                ac.setRole("AC");

                repository.save(ac);
            }

            if (repository.findByEmail("hod@gmail.com") == null) {

                User hod = new User();
                hod.setName("HOD");
                hod.setEmail("hod@gmail.com");
                hod.setPassword("1234");
                hod.setRole("HOD");

                repository.save(hod);
            }
        };
    }
}
