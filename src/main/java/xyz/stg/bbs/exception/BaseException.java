package xyz.stg.bbs.exception;

/**
 * Created by tan on 16-1-11.
 *
 *
 */
public class BaseException extends RuntimeException {
    private int httpStatus;

    public BaseException(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public BaseException(int httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
