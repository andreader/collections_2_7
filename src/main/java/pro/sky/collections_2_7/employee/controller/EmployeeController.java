package pro.sky.collections_2_7.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections_2_7.employee.model.Employee;
import pro.sky.collections_2_7.employee.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController() {
        this(null);
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    private String generateMessage(Employee employee, String status) {
        return String.format("Сотрудник %s %s %s.",
                employee.getLastName(),
                employee.getFirstName(),
                status);
    }


    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        {
            Employee result = employeeService.add(firstName, lastName);
            return generateMessage(result, "успешно создан");
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam String firstName, @RequestParam String lastName) {
        Employee employee = employeeService.delete(firstName, lastName);
        return generateMessage(employee, "удалён");
    }

    @GetMapping("find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }


    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }

}



