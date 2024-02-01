package io.proton.protonorders.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ProtonExceptionHandler {

    @ExceptionHandler(ProtonException.class)
    ProblemDetail handleProtonException(ProtonException e) {
        logger.error(e.getLogMessage());
        return ProblemDetail.forStatusAndDetail(e.getHttpStatus(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    ProblemDetail handleRunException(RuntimeException e) {
        logger.error(e.getMessage());
        return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    }
}
