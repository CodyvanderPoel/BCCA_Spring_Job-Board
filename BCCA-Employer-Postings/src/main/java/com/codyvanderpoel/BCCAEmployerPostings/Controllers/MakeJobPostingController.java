package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPostingForm;
import com.codyvanderpoel.BCCAEmployerPostings.Repositories.PostgresJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MakeJobPostingController {

    public PostgresJobRepository jobRepository;

    @Autowired
    public MakeJobPostingController(PostgresJobRepository repo){
        jobRepository = repo;
    }

    @GetMapping("/employer_home")
    public String getEmployerHome(){
        return "employer_home";
    }

    @GetMapping("/employer_home/make_posting")
    public String getForm() {
        return "make_post";
    }

    @PostMapping("/employer_home/make_posting")
    public String index (JobPostingForm post) {
        JobPosting job = new JobPosting(post.getCompany(),post.getPosition(),post.getLocation(),post.getBenefits(),post.getPrereqs());
        jobRepository.addPosting(job);
        return "redirect:/";
    }
}