package mifi.dev.springboottrain.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

@Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> helloWorld(){
    return employeeService.getAllEmployees();
    }



@PostMapping
public Employee createEmployee(@RequestBody Employee employee){  //пост метод принимает в себя в качестве риквэст тела и возвращает созданного в системе


    return employeeService.createEmployee(employee);

}
}