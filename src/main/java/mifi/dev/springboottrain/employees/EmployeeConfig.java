package mifi.dev.springboottrain.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean                              //сохранить в БД добавить в зависимость commandLineRunner(EmployeeRepository)
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){  //это интерфейс и все его наследники вызовутся перед стартом приложения
        return (args)  -> {
             var employeeList = List.of ( new Employee(
                        null,   //база сама присвоит айдишники пишем нулл
                        "Vasya",
                        "vasya@mail.com",
                        LocalDate.of(2000, 1, 12),
                        10000
                ),
                new Employee(
                        null,
                        "Vanya",
                        "vanya@mail.com",
                        LocalDate.of(2002, 1, 12),
                        10500
                )
        );

            employeeRepository.saveAll(employeeList);

        };
    }
}
