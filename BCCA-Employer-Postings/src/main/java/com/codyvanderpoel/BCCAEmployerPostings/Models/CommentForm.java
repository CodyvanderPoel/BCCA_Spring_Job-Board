package com.codyvanderpoel.BCCAEmployerPostings.Models;

import javax.validation.constraints.NotNull;

public class CommentForm {
    @NotNull
    public String title;

    @NotNull
    public String body;

    @NotNull
    public Integer jobId;

    public CommentForm(String title, String body, Integer jobId){
        this.title = title;
        this.body = body;
        this.jobId = jobId;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {return body; }
    public void setBody(String body) {
        this.body = body;
    }

    public Integer getJobId() {return jobId; }
    public void setJobId(Integer jobId) { this.jobId = jobId; }
}
