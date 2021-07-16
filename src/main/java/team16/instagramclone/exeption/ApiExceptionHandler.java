package team16.instagramclone.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = { ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException ex) {
        com.sparta.mungmung.exception.ApiException apiException = new com.sparta.mungmung.exception.ApiException(
                ex.getMessage(),
                // HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(
                apiException,
                // HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(value = { BadCredentialsException.class})
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex) {
        com.sparta.mungmung.exception.ApiException apiException = new com.sparta.mungmung.exception.ApiException(

                // HTTP 400 -> Client Error
                ex.getMessage(),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(
                apiException,
                // HTTP 400 -> Client Error
                HttpStatus.BAD_REQUEST
        );
    }
}