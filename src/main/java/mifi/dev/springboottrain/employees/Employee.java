package mifi.dev.springboottrain.employees;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="employee")
public class Employee {

    @Id
    @SequenceGenerator(
            name="employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, //стратегия того, как будем генерировать ID
            generator = "employee_sequence"
    )
    private Long ID;
    private String name;
    private String email;
    private LocalDate birthData;
    @Transient  //чтобы не сохранять поле в базу, а вычислять возраст отдельно, не будет создаваться отдельная колонка
    private Integer age;
    private Integer salary;

    public Employee() {

    }  //пустой конструктор нужен для Хайбернейта

    public Employee(Long ID, String name, String email, LocalDate birthData, Integer salary) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.birthData = birthData;
        this.age = Period.between(birthData, LocalDate.now()).getYears();  // - чтобы не отправлять в базу
        this.salary = salary;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthData() {
        return birthData;
    }

    public void setBirthData(LocalDate birthData) {
        this.birthData = birthData;
    }

    public Integer getAge() {
        if  (age==null)
            this.age = Period.between(birthData, LocalDate.now()).getYears();
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
