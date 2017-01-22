package xyz.stg.bbs.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by tan on 16/4/27.
 */
public class EmailNotFoundException extends AuthenticationException {
    public EmailNotFoundException(String msg) {
        super(msg);
    }

    public EmailNotFoundException(String msg, Throwable t) {
        super(msg, t);
    }
}
