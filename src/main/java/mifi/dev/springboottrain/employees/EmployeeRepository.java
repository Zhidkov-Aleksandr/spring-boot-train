package mifi.dev.springboottrain.employees;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends
        JpaRepository<Employee, Long> {  //репозиторий, который приходит из спринга автоматически    //


    Optional<Employee> findByEmail(String email);


}
