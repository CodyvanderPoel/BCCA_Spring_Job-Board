package com.codyvanderpoel.BCCAEmployerPostings.Repositories;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresJobRepository implements com.codyvanderpoel.BCCAEmployerPostings.Repositories.Repository<JobPosting> {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresJobRepository(JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }

    @Override
    public void addPosting(JobPosting posting){
        String columns = "company, position, location, prereqs ,benefits";
        jdbc.update(
                "INSERT INTO jobs (" + columns + ") VALUES (?, ?, ?, ?, ?);" ,
                posting.getCompany(),
                posting.getPosition(),
                posting.getLocation(),
                posting.getPrereqs(),
                posting.getBenefits()
        );
    }

    public Optional<JobPosting> findById(int id) {

        return Optional.ofNullable(
                jdbc.queryForObject("SELECT * FROM applications WHERE id= ?;", this::mapToPosting ,id));
    }

    public JobPosting mapToPosting(ResultSet rs, int rowNum) throws SQLException {
        return new JobPosting(
            rs.getInt("id"),
            rs.getString("company"),
            rs.getString("position"),
            rs.getString("location"),
            rs.getString("prereqs"),
            rs.getString("benefits")
        );
    }


    @Override
    public List<JobPosting> findAll() {
        return null;
    }
}
