package id.ekky.myanimelist.dtos.user;

import lombok.Builder;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Locale;

@Data
@Builder
public class UserDetailDTO {
    private final Integer id;
    private final String username;
    private final String gender;
    private final String birthday;
    private final String location;
    private final String joined;
    private final Double daysWatched;
    private final Double meanScore;
    private final Double watching;
    private final Double completed;
    private final Double onHold;
    private final Double dropped;
    private final Double planToWatch;
    private final Double totalEntries;
    private final Double rewatched;
    private final Double episodesWatched;
}
