package com.codyvanderpoel.BCCAEmployerPostings.Models;

import javax.validation.constraints.NotNull;

public class CommentForm {
    @NotNull
    public String title;

    @NotNull
    public String body;

    public CommentForm(String title, String body, Integer jobId){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {return body; }
    public void setBody(String body) {
        this.body = body;
    }
}
