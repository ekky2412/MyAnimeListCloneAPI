package id.ekky.myanimelist.dtos.useranime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAnimeDTO {
    private final Integer userId;
    private final String username;
    private final Integer animeId;
    private final String animeName;
    private final Integer rating;
}
