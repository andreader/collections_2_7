package pro.sky.collections_2_7.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.collections_2_7.employee.exceptions.ArrayIsFullException;
import pro.sky.collections_2_7.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections_2_7.employee.exceptions.EmployeeNotFoundException;
import pro.sky.collections_2_7.employee.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceSetImpl implements EmployeeService {

    private static final int COUNT_EMPLOYEE = 3;
    private final Set<Employee> employees = new HashSet<>(COUNT_EMPLOYEE);

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() == COUNT_EMPLOYEE) {
            throw new ArrayIsFullException("Array is full!");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Employee already added!");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee delete(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        Employee findEmployee = findEmployee(employee);
        if (findEmployee != null) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет" + firstName + lastName);
    }

    private Employee findEmployee (Employee employee) {
        Employee findEmployee = null;
        for (Employee emp : employees) {
            if (emp.equals(employee)) {
                findEmployee = emp;
                break;
            }
        }
        return findEmployee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = findEmployee(new Employee(firstName, lastName));
            if (employee != null) {
                return employee;
            }
        throw new EmployeeNotFoundException("Employee not found");
        }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees);
    }
}
