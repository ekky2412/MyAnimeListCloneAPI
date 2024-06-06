package id.ekky.myanimelist.dtos.anime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimeDetailDTO {
    private final Integer id;
    private final String title;
    private Double score;
    private String genres;
    private String synopsis;
    private String type;
    private Integer episodes;
    private String status;
    private String[] producers;
    private String[] licensors;
    private String[] studios;
    private String source;
    private String duration;
    private String rating;
    private Integer rank;
    private Integer popularity;
    private Integer favorites;
    private String imageUrl;
}
