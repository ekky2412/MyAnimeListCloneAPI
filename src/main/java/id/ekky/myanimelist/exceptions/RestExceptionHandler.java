package id.ekky.myanimelist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessageDto> handleEntityNotFoundException(EntityNotFoundException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        ErrorMessageDto dto = ErrorMessageDto
                .builder()
                .statusCode(httpStatus.value())
                .message(e.getMessage())
                .build();

        return new ResponseEntity<>(dto, httpStatus);
    }
}
