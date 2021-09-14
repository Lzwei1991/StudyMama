package sg.com.studymama.exceptions;

import org.springframework.security.core.AuthenticationException;

public class UserEmailVerificationException extends AuthenticationException {
    public UserEmailVerificationException(final String msg) {
        super(msg);
    }

}