package id.ekky.myanimelist.dtos.anime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnimeListDTO {
    private final Integer id;
    private final String title;
    private final Double score;
    private final String synopsis;
    private final Integer episodes;
    private final String type;
    private final String studios;
    private final String imageUrl;
    private final Boolean isHentai;

    public String getIsHentai(){
        if(isHentai) return "Yes";
        else return "No";
    }
}
