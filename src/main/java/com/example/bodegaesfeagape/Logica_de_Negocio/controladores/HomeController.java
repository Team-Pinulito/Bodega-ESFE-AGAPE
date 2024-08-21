package com.example.bodegaesfeagape.Logica_de_Negocio.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    // llamar a la vista index
    @GetMapping("/")
    public String index() {
        return "home/index";
    }
}
