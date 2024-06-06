package id.ekky.myanimelist.services;

import id.ekky.myanimelist.dtos.anime.AnimeDetailDTO;
import id.ekky.myanimelist.dtos.anime.AnimeFilterDTO;
import id.ekky.myanimelist.dtos.anime.AnimeListDTO;
import id.ekky.myanimelist.exceptions.EntityNotFoundException;
import id.ekky.myanimelist.repositories.AnimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeService {
    private AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<AnimeListDTO> getAll(AnimeFilterDTO dto){
        String checkedName = dto.getName() == null || dto.getName().isBlank() ? null : dto.getName();
        int pageNumber = dto.getPageNumber() == null ? 0 : dto.getPageNumber()-1;
        int pageSize = dto.getPageSize() == null ? 10 : dto.getPageSize();

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        var animes = animeRepository.findAll(pageable, checkedName).map(
                anime -> AnimeListDTO.builder()
                        .id(anime.getId())
                        .title(anime.getTitle())
                        .score(anime.getScore())
                        .synopsis(anime.getSynopsis())
                        .episodes(anime.getEpisodes())
                        .type(anime.getType())
                        .studios(anime.getStudios())
                        .imageUrl(anime.getImageUrl())
                        .isHentai(anime.getIsHentai())
                        .build()).toList();
        return animes;
    }

    public AnimeDetailDTO getDetail(Integer id){
//        TODO ADD EXCEPTION
        var anime = animeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Anime Id Not Found!")
        );

        return AnimeDetailDTO.builder()
                .id(anime.getId())
                .title(anime.getTitle())
                .score(anime.getScore())
                .genres(anime.getGenres())
                .synopsis(anime.getSynopsis())
                .type(anime.getType())
                .episodes(anime.getEpisodes())
                .status(anime.getStatus())
                .producers(anime.getProducers().split(", "))
                .licensors(anime.getLicensors().split(", "))
                .studios(anime.getStudios().split(", "))
                .source(anime.getSource())
                .duration(anime.getDuration())
                .rating(anime.getRating())
                .rank(anime.getRank())
                .popularity(anime.getPopularity())
                .favorites(anime.getFavorites())
                .imageUrl(anime.getImageUrl())
                .build();
    }
}
