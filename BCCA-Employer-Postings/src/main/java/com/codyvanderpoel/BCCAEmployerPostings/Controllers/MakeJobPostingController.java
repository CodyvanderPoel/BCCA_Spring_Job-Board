package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MakeJobPostingController {
    @GetMapping("/make_posting")
    public String index() {
        return "make_post";
    }

    @PostMapping("/make_posting")
    public String index(Model model) {

        return "redirect:/";
    }
}