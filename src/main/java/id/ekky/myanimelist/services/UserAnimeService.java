package id.ekky.myanimelist.services;

import id.ekky.myanimelist.dtos.useranime.UserAnimeDTO;
import id.ekky.myanimelist.dtos.useranime.UserAnimePageDTO;
import id.ekky.myanimelist.models.UserAnime;
import id.ekky.myanimelist.models.UserAnimeId;
import id.ekky.myanimelist.repositories.UserAnimeRepository;
import id.ekky.myanimelist.utility.FormatHelper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnimeService {
    private final UserAnimeRepository userAnimeRepository;

    public UserAnimeService(UserAnimeRepository userAnimeRepository) {
        this.userAnimeRepository = userAnimeRepository;
    }

    public UserAnimePageDTO getByUserId(Integer userId, String page, Integer pageSize){
        int realPageSize;
        if (page != null &&
                !FormatHelper.isNumeric(page) &&
                page.equals("all")) {
            realPageSize = (int) userAnimeRepository.findById(new UserAnimeId(userId, null)).stream().count();
        } else {
            realPageSize = pageSize == null ? 10 : pageSize;
        }

        int realPageNumber = !FormatHelper.isNumeric(page) ? 0 : FormatHelper.toInt(page) - 1;


        Pageable pageable = PageRequest.of(realPageNumber, realPageSize);

        var userAnimes = userAnimeRepository.findAllByUserId(pageable, userId);
        return UserAnimePageDTO.builder()
                .page(realPageNumber+1)
                .totalPages(userAnimes.getTotalPages())
                .totalElements(userAnimes.getTotalElements())
                .content(userAnimes.map(
                        userAnime -> UserAnimeDTO.builder()
                                .userId(userAnime.getUser().getId())
                                .username(userAnime.getUser().getUsername())
                                .animeId(userAnime.getAnime().getId())
                                .animeName(userAnime.getAnime().getTitle())
                                .rating(userAnime.getRating())
                                .build()
                ).toList())
                .build();
    }
// TODO add getByAnimeId to pages
//    public List<UserAnimeDTO> getByAnimeId(Integer animeId, Integer pageNumber, Integer pageSize){
//        var userAnimes = userAnimeRepository.findAllByAnimeId(animeId);
//        return userAnimes.stream().map(
//                userAnime -> UserAnimeDTO.builder()
//                        .userId(userAnime.getUser().getId())
//                        .username(userAnime.getUser().getId())
//                        .animeId(userAnime.getAnime().getId())
//                        .animeName(userAnime.getAnime().getTitle())
//                        .rating(userAnime.getRating())
//                        .build()
//        ).toList();
//    }
}
