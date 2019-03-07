package com.codyvanderpoel.BCCAEmployerPostings.Models;


import javax.validation.constraints.NotNull;

public class JobPosting {

    public Integer id;

    @NotNull
    public String company;

    @NotNull
    public String position;

    @NotNull
    public String benefits;

    public JobPosting(Integer id, String company, String position, String benefits){
        this.id = id;
        this.company = company;
        this.position = position;
        this.benefits = benefits;
    }

    public int getId(){
        return id;
    }
    public String getCompany(){
        return company.trim();
    }
    public void setCompany() {
        this.company = company;
    }
    public String getPosition(){
        return position.trim();
    }
    public void setPosition() {
        this.position = position;
    }
    public String getBenefits(){
        return benefits.trim();
    }
    public void setBenefits() {
        this.benefits = benefits;
    }
}
