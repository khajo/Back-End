package at.nacs.example;


import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RunConfiguration {

    @Bean
    ApplicationRunner runner(PersonRepository repository) {
        return args -> {
            repository.deleteAll();
            Person person = new Person();
            person.setName("khajoa");
            repository.save(person);
            System.out.println("saved: " + person.getName());


        };
    }
}
