package lab4.lab4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ HttpError.class })
    public ResponseEntity<String> handleHttpError(HttpError e) {
        return new ResponseEntity<>("Http error: " + e.getMessage(), e.getStatus());
    }

    @ExceptionHandler({ Exception.class })
    public ResponseEntity<String> handleSimpleError(Exception e) {
        return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}