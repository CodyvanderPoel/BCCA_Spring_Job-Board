package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewPostingController {
    @GetMapping("/view_posting")
    public String index() {
        return "view_post";
    }
}