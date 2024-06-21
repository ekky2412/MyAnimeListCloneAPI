package id.ekky.myanimelist.dtos.useranime;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class UserAnimePageDTO {
    private Integer page;
    private Integer totalPages;
    private Long totalElements;
    private List<UserAnimeDTO> content;
}
