package xyz.stg.bbs.exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by tan on 16/5/3.
 */
public class FormLoginException extends AuthenticationException {

    private int code = -1;

    private Authentication authentication;

    public FormLoginException(String msg) {
        super(msg);
    }

    public FormLoginException(int code, String msg) {
        this(msg);
        this.code = code;
    }

    public FormLoginException(Authentication authentication, int code, String msg) {
        super(msg);
        this.code = code;
        this.authentication = authentication;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
}
