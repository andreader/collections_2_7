package pro.sky.collections_2_7.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArrayIsFullException extends RuntimeException {
    public ArrayIsFullException(String message) {
        super(message);
    }
}
