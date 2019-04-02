package com.codyvanderpoel.BCCAEmployerPostings.Models;


import javax.validation.constraints.NotNull;

public class JobPosting {


    public Integer id;

    @NotNull
    public String company;

    @NotNull
    public String position;

    @NotNull
    public String location;

    @NotNull
    public String prereqs;

    @NotNull
    public String benefits;

    public JobPosting(Integer id, String company, String position, String location, String prereqs, String benefits){
        this.id = id;
        this.company = company;
        this.position = position;
        this.location = location;
        this.prereqs = prereqs;
        this.benefits = benefits;
    }

    public JobPosting(String company, String position, String location, String prereqs, String benefits){
        this.company = company;
        this.position = position;
        this.location = location;
        this.prereqs = prereqs;
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

    public String getLocation(){
        return location.trim();
    }
    public void setLocation() { this.location = location; }

    public String getPrereqs(){return prereqs; }
    public void setPrereqs() { this.prereqs = prereqs; }

    public String getBenefits(){
        return benefits;
    }
    public void setBenefits() {
        this.benefits = benefits;
    }
}
