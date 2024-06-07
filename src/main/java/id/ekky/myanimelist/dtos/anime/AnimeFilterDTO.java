package id.ekky.myanimelist.dtos.anime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimeFilterDTO {
    private final String page;
    private final Integer pageSize;
    private final String name;
    private final String genre;
    private final Integer year;
    private final Boolean adultContent;
}
