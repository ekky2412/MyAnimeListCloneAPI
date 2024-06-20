package id.ekky.myanimelist.dtos.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserFilterDTO {
    private final String page;
    private final Integer pageSize;
    private final String username;
    private final String gender;
    private final String location;
}
