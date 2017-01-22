package xyz.stg.bbs.exception;

/**
 * Created by tan on 16/4/25.
 */
public class ForbiddenException extends BaseException {
    public ForbiddenException() {
        super(403);
    }

    public ForbiddenException(String message) {
        super(403, message);
    }
}
