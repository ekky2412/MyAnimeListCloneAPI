package id.ekky.myanimelist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String redirectToSwaggerDoc(){
        return "redirect:/swagger-ui.html";
    }

}
