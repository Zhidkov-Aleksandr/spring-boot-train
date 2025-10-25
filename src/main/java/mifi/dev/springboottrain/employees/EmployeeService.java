package mifi.dev.springboottrain.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {

    //добавляем репозиторий
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees(){


        return employeeRepository.findAll(); //метод findAll() будет автоматически сгенерирован
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getID()!=null){
            throw new IllegalArgumentException("Employee ID must be null"); //айдишник должен быть нулл
        }
        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()){  //проверка на совпадение мэйла
            throw new IllegalArgumentException("Email already taken");
        }
        if (employee.getSalary() <=5000){
            throw new IllegalArgumentException("Salary must be bigger then 5000"); //проверка ЗП
        }

        return employeeRepository.save(employee);//валидация бизнес логики - уникальный мэйл и зп больше 5000
    }
}
