package id.ekky.myanimelist.controllers;

import id.ekky.myanimelist.dtos.anime.AnimeDetailDTO;
import id.ekky.myanimelist.dtos.anime.AnimeFilterDTO;
import id.ekky.myanimelist.dtos.anime.AnimeListDTO;
import id.ekky.myanimelist.services.AnimeService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("anime")
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("")
    public ResponseEntity<List<AnimeListDTO>> getAll(AnimeFilterDTO dto){
        return new ResponseEntity<>(animeService.getAll(dto), HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimeDetailDTO> getDetail(@PathVariable Integer id){
        return new ResponseEntity<>(animeService.getDetail(id), HttpStatusCode.valueOf(200));
    }


}
