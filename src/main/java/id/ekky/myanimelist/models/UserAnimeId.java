package id.ekky.myanimelist.models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;


@Embeddable
public class UserAnimeId implements Serializable {
    private Integer userId;
    private Integer animeId;

    public UserAnimeId(Integer userId, Integer animeId) {
        this.userId = userId;
        this.animeId = animeId;
    }
}
