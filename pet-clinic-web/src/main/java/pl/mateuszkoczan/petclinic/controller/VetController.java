package pl.mateuszkoczan.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.mateuszkoczan.petclinic.service.VetService;

@Controller
public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    @GetMapping("/vets")
    public String showVets(Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
