package com.codyvanderpoel.BCCAEmployerPostings.Models;

import javax.validation.constraints.NotNull;

public class JobPostingForm {

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

    public JobPostingForm(String company, String position, String location, String prereqs, String benefits){
        this.company = company;
        this.position = position;
        this.location = location;
        this.prereqs = prereqs;
        this.benefits = benefits;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(String prereqs) {
        this.prereqs = prereqs;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }
}
