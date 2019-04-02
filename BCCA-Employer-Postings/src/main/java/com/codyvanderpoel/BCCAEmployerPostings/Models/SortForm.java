package com.codyvanderpoel.BCCAEmployerPostings.Models;


import javax.validation.constraints.NotNull;

public class SortForm{

    @NotNull
    public String sort;

    public String getSort() {
        return sort;
    }

    public void setSortBy(String sort) {
        this.sort = sort;
    }
}
