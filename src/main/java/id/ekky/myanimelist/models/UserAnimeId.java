package id.ekky.myanimelist.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAnimeId implements Serializable {
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "anime_id")
    private Integer animeId;
}
