package xyz.stg.bbs.exception;

/**
 * Created by tan on 16-2-1.
 */
public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException() {
        super(404);
    }

    public ResourceNotFoundException(String message) {
        super(404, message);
    }
}
