package io.proton.protonorders.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class ProtonException extends Exception {
    private HttpStatus httpStatus;
    private String message;
}
