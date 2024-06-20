package id.ekky.myanimelist.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Anime")
public class Anime {
    @Id
    private Integer id;
    private String title;
    private String englishTitle;
    private String otherTitle;
    private Double score;
    private String genres;
    private String synopsis;
    private String type;
    private Integer episodes;
    private String aired;
    private String premiered;
    private String status;
    private String producers;
    private String licensors;
    private String studios;
    private String source;
    private String duration;
    private String rating;
    private Integer rank;
    private Integer popularity;
    private Integer favorites;
    private Integer scoredBy;
    private Integer members;
    private String imageUrl;
    private Boolean isHentai;

    @OneToMany(mappedBy = "anime")
    private List<UserAnime> userAnimeList;
}
