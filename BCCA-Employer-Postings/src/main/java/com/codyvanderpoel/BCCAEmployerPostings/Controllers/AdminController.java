package com.codyvanderpoel.BCCAEmployerPostings.Controllers;

import com.codyvanderpoel.BCCAEmployerPostings.Models.Comment;
import com.codyvanderpoel.BCCAEmployerPostings.Models.CommentForm;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;
import com.codyvanderpoel.BCCAEmployerPostings.Repositories.PostgresJobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminController {

    public PostgresJobRepository jobRepository;

    @Autowired
    public AdminController(PostgresJobRepository repo){
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
            List<Comment> comments = jobRepository.findPostComments( Integer.parseInt(jobId));
            model.addAttribute("job", job.get());
            model.addAttribute("comments", comments);
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

    @PostMapping("/admin_view_jobs/{jobId}")
    public String postComment(CommentForm form, Model model, @PathVariable(value = "jobId") String jobId) {
        Comment comment = new Comment(Integer.parseInt(jobId), form.getTitle(), form.getBody());
        jobRepository.addComment(comment);
        return "redirect:/admin_view_jobs/" + jobId;
    }

    @GetMapping("/admin_view_jobs/{jobId}/{id}/delete-comment")
    public String deleteJobComment(Model model, @PathVariable(value="jobId") String jobId, @PathVariable(value="id") String id){
            jobRepository.deleteComment(Integer.parseInt(id));
            return "redirect:/admin_view_jobs/" + jobId;
    }
}