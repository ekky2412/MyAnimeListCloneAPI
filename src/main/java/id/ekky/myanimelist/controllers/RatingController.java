package id.ekky.myanimelist.controllers;

import id.ekky.myanimelist.dtos.useranime.UserAnimeDTO;
import id.ekky.myanimelist.dtos.useranime.UserAnimePageDTO;
import id.ekky.myanimelist.services.UserAnimeService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rating")
public class RatingController {
    private final UserAnimeService userAnimeService;

    public RatingController(UserAnimeService userAnimeService) {
        this.userAnimeService = userAnimeService;
    }

    @GetMapping("{userId}")
    public ResponseEntity<UserAnimePageDTO> getByUserId(@PathVariable Integer userId, String page, Integer pageSize){
        return new ResponseEntity<>(userAnimeService.getByUserId(userId, page, pageSize), HttpStatusCode.valueOf(200));
    }

//    @GetMapping("/anime/{animeId}")
//    public ResponseEntity<UserAnimePageDTO> getByAnimeId(@PathVariable Integer animeId, Integer pageNumber, Integer pageSize){
//        return new ResponseEntity<>(userAnimeService.getByAnimeId(animeId, pageNumber, pageSize), HttpStatusCode.valueOf(200));
//    }
}
