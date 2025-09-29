package am.vector.payroll.exception;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private Logger log = Logger.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, "Incorrect argument values provided",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(value = DuplicateKeyException.class )
    protected ResponseEntity<Object> duplicateKey(DuplicateKeyException ex, WebRequest request) {
        String bodyOfResponse = ex.getCause().getMessage();
        log.warn(ex.getMessage());
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = EmptyResultDataAccessException.class )
    protected ResponseEntity<Object> emptyGetResult(EmptyResultDataAccessException ex, WebRequest request) {
        return handleExceptionInternal(ex, "{}",
                new HttpHeaders(), HttpStatus.OK, request);
    }

    @ExceptionHandler(value = AuthenticationException.class )
    protected ResponseEntity<Object> authenticationFaild(AuthenticationException ex, WebRequest request) {
        log.warn(ex.getMessage());
        return handleExceptionInternal(ex, "You are not authorised",
                new HttpHeaders(), HttpStatus.UNAUTHORIZED, request);
    }

    @ExceptionHandler({ RepositoryConstraintViolationException.class })
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        RepositoryConstraintViolationException nevEx = (RepositoryConstraintViolationException) ex;

        String errors = nevEx.getErrors().getAllErrors().stream()
                .map(p -> p.toString()).collect(Collectors.joining("\n"));

        return new ResponseEntity<Object>(errors, new HttpHeaders(),
                HttpStatus.PARTIAL_CONTENT);
    }
}