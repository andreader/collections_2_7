package pro.sky.collections_2_7.employee.service;

import pro.sky.collections_2_7.employee.model.Employee;
import pro.sky.collections_2_7.employee.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee delete(String firstName, String lastName);
    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();
}
