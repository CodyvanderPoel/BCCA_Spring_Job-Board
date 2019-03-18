package com.codyvanderpoel.BCCAEmployerPostings.Repositories;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;

import java.util.List;
import java.util.Optional;


public interface Repository<T> {
    public void addPosting(JobPosting post);

    List<JobPosting> findAll();

    Optional<T> findById(int id);
}