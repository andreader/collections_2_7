package pro.sky.collections_2_7.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.collections_2_7.employee.exceptions.ArrayIsFullException;
import pro.sky.collections_2_7.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections_2_7.employee.exceptions.EmployeeNotFoundException;
import pro.sky.collections_2_7.employee.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceMapImpl implements EmployeeService {

    private static final int COUNT_EMPLOYEE = 3;
    private final Map<String, Employee> employees = new HashMap<>(COUNT_EMPLOYEE);

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() == COUNT_EMPLOYEE) {
            throw new ArrayIsFullException("Array is full!");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("Employee already added!");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee delete(String firstName, String lastName) {
        Employee remove =  employees.remove(firstName + lastName);

        if (remove != null) {
            return remove;
        }
        throw new EmployeeNotFoundException("Такого сотрудника нет" + firstName + lastName);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = employees.get(firstName + lastName);
            if (employee != null) {
                return employee;
            }
        throw new EmployeeNotFoundException("Employee not found");
        }


    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
