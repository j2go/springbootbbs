package xyz.stg.bbs.exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by tan on 16/4/27.
 */
public class InvalidOauthBindStatusException extends AuthenticationException {

    private Authentication authentication;

    public InvalidOauthBindStatusException(String msg) {
        super(msg);
    }

    public InvalidOauthBindStatusException(Authentication authentication, String msg, Throwable t) {
        super(msg, t);
        this.authentication = authentication;
    }

    public InvalidOauthBindStatusException(Authentication authentication, String msg) {
        super(msg);
        this.authentication = authentication;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
