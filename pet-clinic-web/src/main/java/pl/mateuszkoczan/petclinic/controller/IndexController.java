package pl.mateuszkoczan.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping({"", "/", "index", "index.html"})
    public String showIndexPage() {
        return "index";
    }

    @GetMapping({"/oups", "oups.html"})
    public String oupsHandle() {
        return "notimpl";
    }
}
