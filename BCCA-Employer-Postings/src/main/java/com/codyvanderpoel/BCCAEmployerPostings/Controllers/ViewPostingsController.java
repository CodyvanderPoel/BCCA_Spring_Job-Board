package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewPostingsController {
    @GetMapping("/view_postings")
    public String index() {
        return "view_postings";
    }
}