package pro.sky.collections_2_7.employee.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
