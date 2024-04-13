package pro.sky.collections_2_7.employee.service;

import org.springframework.stereotype.Service;
import pro.sky.collections_2_7.employee.exceptions.ArrayIsFullException;
import pro.sky.collections_2_7.employee.exceptions.EmployeeAlreadyAddedException;
import pro.sky.collections_2_7.employee.exceptions.EmployeeNotFoundException;
import pro.sky.collections_2_7.employee.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final int COUNT_EMPLOYEE = 3;
    private List<Employee> employees = new ArrayList<>(COUNT_EMPLOYEE);

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
        Employee newEmployee = new Employee(firstName, lastName);
        boolean deleted = false;
        Iterator<Employee> employeeIterator = employees.iterator();
        while (employeeIterator.hasNext()){
            Employee employee = employeeIterator.next();
            if (employee.equals(newEmployee)) {
                employeeIterator.remove();
                deleted = true;
            }
        }
        return newEmployee;
        /*
        метод фор лучше , но будут ошибки, форич хуже, так как по индексу быстрее, a лучший метод - через итератор- см выше

*/
/*        for (int i = 0; i < employees.size (); i++) {
            Employee employee = employees.get(i);
            if (employees.equals(newEmployee)) {
                employees.remove(i);
                return true;
            }
        }*/

    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        for (Employee employee : employees) {
            if (employee.equals(newEmployee)) {
                return employee;
            }
        }
/*        if (employees.contains(newEmployee)) {
            return newEmployee;
        }*/
/*        второй метод лучше , так как если мы новое поле добавим, расширяя класс Employee
        , contains автоматически добавит туда это поле */
        throw new EmployeeNotFoundException("Employee not found");
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
            /*    добавили такую сущность , чтобы нельзя было хакнуть систему
                добавив неизменяемый список чтобы не поддерживала метод add, а просто вернула копию листа*/
    }
}
