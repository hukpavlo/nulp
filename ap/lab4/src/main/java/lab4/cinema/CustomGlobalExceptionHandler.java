package lab4.cinema;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ HttpException.class })
    public ResponseEntity<String> handleHttpError(HttpException e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), e.getStatus());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleError(Exception e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}