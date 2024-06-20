package id.ekky.myanimelist.controllers;

import id.ekky.myanimelist.dtos.anime.AnimeDetailDTO;
import id.ekky.myanimelist.dtos.anime.AnimeFilterDTO;
import id.ekky.myanimelist.dtos.anime.AnimeListDTO;
import id.ekky.myanimelist.dtos.user.UserDetailDTO;
import id.ekky.myanimelist.dtos.user.UserFilterDTO;
import id.ekky.myanimelist.dtos.user.UserListDTO;
import id.ekky.myanimelist.services.UserService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserListDTO>> getAll(UserFilterDTO params){
        return new ResponseEntity<>(userService.getAll(params), HttpStatusCode.valueOf(200));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDetailDTO> getDetail(@PathVariable Integer id){
        return new ResponseEntity<>(userService.getDetail(id), HttpStatusCode.valueOf(200));
    }
}
