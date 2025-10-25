package mifi.dev.springboottrain.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)){
            throw new IllegalArgumentException("Employee id=s% does not exist");
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(
            Long id,
            String emil,
            Integer salary

    ) {
        var employee = employeeRepository.findById(id).orElse(null);
        if (employee == null){
            throw new IllegalArgumentException("Employee id=s% does not exist");
    }
       if (emil != null&&!emil.isEmpty()&&emil.equals(employee.getEmail())){
           Optional<Employee> optionalEmployee = employeeRepository.findByEmail(emil);
           if (optionalEmployee.isPresent()){
               throw new IllegalArgumentException("Employee id=s% already exists");
           }
           employee.setEmail(emil);



       }
       if (salary!=null){
           if (salary<=5000){
               throw new IllegalArgumentException("Salary mast be bigger than 5000");


           }
           employee.setSalary(salary);

       }

    }


}
