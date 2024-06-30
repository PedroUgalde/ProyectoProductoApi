package com.ipn.mx.integracion;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("message", "Hola desde el controlador");
        return "index.html";  
    }
}
