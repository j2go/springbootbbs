package xyz.stg.bbs.exception;

/**
 * Created by tan on 16-1-11.
 */
public class BadRequestException extends BaseException {
    public BadRequestException() {
        super(400);
    }

    public BadRequestException(String message) {
        super(400, message);
    }

}
