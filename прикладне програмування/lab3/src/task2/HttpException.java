package task2;

enum HttpStatus {
    OK(200), BAD_REQUEST(400), INTERNAL_SERVER_ERROR(500);

    private final int status;

    HttpStatus(int status) {
        this.status = status;
    }

    public int getStatusCode() {
        return this.status;
    }
}

public class HttpException extends RuntimeException {
    private final HttpStatus status;

    public HttpException(HttpStatus status, String errorMessage) {
        super(errorMessage);
        this.status = status;
    }

    public int getStatusCode() {
        return this.status.getStatusCode();
    }
}
