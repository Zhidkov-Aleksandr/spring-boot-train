package mifi.dev.springboottrain.employees;

import java.time.LocalDate;

public class Employee {

    private Long ID;
    private String name;
    private String email;
    private LocalDate birthData;
    private Integer age;
    private Integer salary;


    public Employee(Long ID, String name, String email, LocalDate birthData, Integer age, Integer salary) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.birthData = birthData;
        this.age = age;
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
