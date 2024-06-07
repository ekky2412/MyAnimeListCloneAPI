package id.ekky.myanimelist.services;

import id.ekky.myanimelist.dtos.anime.AnimeDetailDTO;
import id.ekky.myanimelist.dtos.anime.AnimeFilterDTO;
import id.ekky.myanimelist.dtos.anime.AnimeListDTO;
import id.ekky.myanimelist.exceptions.EntityNotFoundException;
import id.ekky.myanimelist.repositories.AnimeRepository;
import id.ekky.myanimelist.utility.FormatHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Service
public class AnimeService {
    private AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public List<AnimeListDTO> getAll(AnimeFilterDTO dto) {
        String name = dto.getName() == null || dto.getName().isBlank() ? null : dto.getName();
        String genre = dto.getGenre() == null || dto.getGenre().isBlank() ? null : dto.getGenre();
        Integer year = dto.getYear() == null ? null : dto.getYear();
        Boolean adultContent = dto.getAdultContent() == null ? null : dto.getAdultContent();

        int pageSize;
        if (dto.getPage() != null &&
                !FormatHelper.isNumeric(dto.getPage()) &&
                dto.getPage().equals("all")) {
            pageSize = (int) animeRepository.count();
        } else {
            pageSize = dto.getPageSize() == null ? 10 : dto.getPageSize();
        }

        int pageNumber = !FormatHelper.isNumeric(dto.getPage()) ? 0 : FormatHelper.toInt(dto.getPage()) - 1;


        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return animeRepository.findAll(pageable, name, genre, year, adultContent).map(
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
    }

    public AnimeDetailDTO getDetail(Integer id) {
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

    public byte[] getImageFromId(Integer id) throws IOException {
        var imageLink = animeRepository.findImageUrlFromId(id).orElseThrow(
                () -> new EntityNotFoundException("Anime Id not found!")
        );
        URL url = new URL(imageLink);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        try (InputStream inputStream = connection.getInputStream()) {
            return readBytesFromInputStream(inputStream);
        }
    }

    private byte[] readBytesFromInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }
}
