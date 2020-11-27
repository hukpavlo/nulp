package lab4.lab4;

import org.springframework.http.HttpStatus;

public class HttpError extends RuntimeException {
    private final HttpStatus status;

    public HttpError(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
