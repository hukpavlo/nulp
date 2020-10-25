package lab4.cinema;

import org.springframework.http.HttpStatus;

public class HttpException extends RuntimeException {
    private final HttpStatus status;

    public HttpException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}
