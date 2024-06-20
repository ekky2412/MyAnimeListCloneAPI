package id.ekky.myanimelist.dtos.user;

import lombok.Builder;
import lombok.Data;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

@Data
@Builder
public class UserListDTO {
    private final Integer id;
    private final String username;
    private final String gender;
    private final String birthday;
    private final String location;
    private final String joined;
}
