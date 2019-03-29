package com.codyvanderpoel.BCCAEmployerPostings.Models;

import javax.validation.constraints.NotNull;

public class Comment {
    public Integer id;

    @NotNull
    public String title;

    @NotNull
    public String body;

    public Comment(Integer id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Comment(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() { return title.trim(); }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() { return body.trim();}
    public void setBody(String body) {
        this.body = body;
    }
}
