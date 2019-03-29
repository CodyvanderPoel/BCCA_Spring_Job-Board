package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import com.codyvanderpoel.BCCAEmployerPostings.Models.Comment;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPostingForm;
import com.codyvanderpoel.BCCAEmployerPostings.Repositories.PostgresJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployerController {

    public PostgresJobRepository jobRepository;

    @Autowired
    public EmployerController(PostgresJobRepository repo){
        jobRepository = repo;
    }

    @GetMapping("/employer_home")
    public String getEmployerHome(Model model){
        List<JobPosting> jobs = jobRepository.findAll();
        model.addAttribute("jobs", jobs);
        return "employer_home";
    }

    @GetMapping("/employer_view_jobs/{jobId}")
    public String getJobDetails(Model model, @PathVariable(value="jobId") String jobId){
        var job = jobRepository.findById(Integer.parseInt(jobId));
        if ((job).isPresent()){
            List<Comment> comments = jobRepository.findPostComments( Integer.parseInt(jobId));
            model.addAttribute("job", job.get());
            model.addAttribute("comments", comments);
            return "view_employer_post";
        }else{
            return "404";
        }
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