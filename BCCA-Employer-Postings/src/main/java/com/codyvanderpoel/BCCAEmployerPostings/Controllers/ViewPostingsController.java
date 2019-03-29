package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;
import com.codyvanderpoel.BCCAEmployerPostings.Repositories.PostgresJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ViewPostingsController {

    public PostgresJobRepository jobRepository;

    @Autowired
    public ViewPostingsController(PostgresJobRepository repo){
        jobRepository = repo;
    }

    @GetMapping("/admin_home")
    public String getAdminHome(Model model){
        List<JobPosting> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "view_postings";
    }

    @GetMapping("/admin_view_jobs/{jobId}")
    public String getAdminJobDetails(Model model, @PathVariable(value="jobId") String jobId){
        var job = jobRepository.findById(Integer.parseInt(jobId));
        if ((job).isPresent()){
            model.addAttribute("job", job.get());
            return "view_post";
        }else{
            return "404";
        }
    }
    @GetMapping("/admin_view_jobs/{jobId}/delete")
    public String deleteJobDetails(Model model, @PathVariable(value="jobId") String jobId){
        var job = jobRepository.findById(Integer.parseInt(jobId));
        if ((job).isPresent()){
            jobRepository.deletePosting(Integer.parseInt(jobId));
            return "redirect:http://localhost:8080/admin_home";
        }else{
            return "404";
        }
    }
}