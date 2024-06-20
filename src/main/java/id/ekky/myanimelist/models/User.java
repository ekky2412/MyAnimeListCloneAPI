package id.ekky.myanimelist.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    private Integer id;
    @Column(unique = true)
    private String username;
    private String gender;
    private LocalDate birthday;
    private String location;
    private LocalDate joined;
    private Double daysWatched;
    private Double meanScore;
    private Double watching;
    private Double completed;
    private Double onHold;
    private Double dropped;
    private Double planToWatch;
    private Double totalEntries;
    private Double rewatched;
    private Double episodesWatched;

    @OneToMany(mappedBy = "user")
    private List<UserAnime> userAnimeList;
}
