package id.ekky.myanimelist.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
    private Double score;
    private String genres;
    private String synopsis;
    private String type;
    private Integer episodes;
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
    @Column(name = "scored_by")
    private Integer scoredBy;
    private Integer members;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "is_hentai")
    private Boolean isHentai;
}
