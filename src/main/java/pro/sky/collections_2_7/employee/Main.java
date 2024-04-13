package pro.sky.collections_2_7.employee;

import pro.sky.employee.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Ivan", "Ivanov");
        Employee employee1 = new Employee("Ivan", "Ivanov");

        int d = 3;
        int b = 3;
        System.out.println(d == b);
        System.out.println(employee.equals(employee1));

        Map<String, Employee> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("123", employee);
        Employee employee2 = objectObjectHashMap.get("123");
        System.out.println(employee.equals(employee2));

        // массив (или бакет, корзинка) лежит в Мапе [] и туда мы складываем ключ K -значение V и в этой
        // корзинке будет лежать Node = узел, в котором будет значение, доступное по ключу
        // и так как для Java Employee это новая сущность - нужно показать ей по какой логике считать HashCode
    }
}
