package mifi.dev.springboottrain.employees;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    public List<Employee> getAllEmployees(){
        return List.of ( new Employee(
                        1L,
                        "Vasya",
                        "vasya@mail.com",
                        LocalDate.of(2000, 1, 12),
                        24,
                        10000
                ),
                new Employee(
                        2L,
                        "Vanya",
                        "vanya@mail.com",
                        LocalDate.of(2002, 1, 12),
                        22,
                        10500
                )


        );
    }

}
