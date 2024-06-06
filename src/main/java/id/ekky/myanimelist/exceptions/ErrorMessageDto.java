package id.ekky.myanimelist.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Data
@Builder
public class ErrorMessageDto {
    private final Integer statusCode;
    private final String message;
    private final ZonedDateTime timestamp = ZonedDateTime.now(ZoneId.of("Z"));
}
