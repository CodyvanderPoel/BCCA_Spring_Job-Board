package com.codyvanderpoel.BCCAEmployerPostings.Repositories;
import com.codyvanderpoel.BCCAEmployerPostings.Models.Comment;
import com.codyvanderpoel.BCCAEmployerPostings.Models.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@ComponentScan(basePackages={"com.codyvanderpoel.BCCAEmployerPostings"})
public class PostgresJobRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresJobRepository(JdbcTemplate jdbcTemplate){
        jdbc = jdbcTemplate;
    }

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
                jdbc.queryForObject("SELECT * FROM jobs WHERE jobId= ?;", this::mapToPosting ,id));
    }

    public JobPosting mapToPosting(ResultSet rs, int rowNum) throws SQLException {
        return new JobPosting(
            rs.getInt("jobId"),
            rs.getString("company"),
            rs.getString("position"),
            rs.getString("location"),
            rs.getString("prereqs"),
            rs.getString("benefits")
        );
    }

    public List<JobPosting> findAll() {
        return jdbc.query("SELECT * FROM jobs;",this::mapToPosting);
    }

    public void deletePosting(int id){
        String sql = "DELETE FROM jobs WHERE jobId = ?;";
        jdbc.update(sql, id);
    }

    public void addComment(Comment comment){
        String sql = "INSERT INTO comments (jobId, title, body) VALUES (?, ?, ?);";
        jdbc.update(sql, comment.getJobId(), comment.getTitle(), comment.getBody());
    }

    public List<Comment> findPostComments(int id){
        String sql = "SELECT * FROM comments WHERE jobId = ?";
        return jdbc.query(sql, this::mapToComment, id);
    }

    public Comment mapToComment(ResultSet rs, int rowNum) throws SQLException {
        return new Comment(
                rs.getInt("id"),
                rs.getInt("jobId"),
                rs.getString("title"),
                rs.getString("body")
        );
    }
    public void deleteComment(int id){
        String sql = "DELETE FROM comments WHERE id = ?;";
        jdbc.update(sql, id);
    }
}
