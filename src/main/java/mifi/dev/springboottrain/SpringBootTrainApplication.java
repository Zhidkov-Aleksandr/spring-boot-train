package mifi.dev.springboottrain;

import mifi.dev.springboottrain.employees.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;


@SpringBootApplication
public class SpringBootTrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTrainApplication.class, args);
    }


}
