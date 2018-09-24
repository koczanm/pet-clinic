package pl.mateuszkoczan.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerController {

    @GetMapping("/owners")
    public String showOwners() {

        return "owners/index";
    }
}
