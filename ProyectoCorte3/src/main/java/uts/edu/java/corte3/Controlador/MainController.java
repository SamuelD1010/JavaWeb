package uts.edu.java.corte3.Controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/dashboard")  
    public String dashboard() {
        return "dashboard";
    }
}