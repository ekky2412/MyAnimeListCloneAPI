package id.ekky.myanimelist.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "UserAnimes")
public class UserAnime {
    @EmbeddedId
    private UserAnimeId id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "anime_id", nullable = false)
    private Anime anime;
    private Integer rating;
}
