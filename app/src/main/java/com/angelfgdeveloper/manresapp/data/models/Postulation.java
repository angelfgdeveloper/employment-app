package com.angelfgdeveloper.manresapp.data.models;

public class Postulation {
    private int id;
    private String postulation;
    private String company;
    private String testToCompany;
    private String objections;

    public Postulation(int id, String postulation, String company, String testToCompany, String objections) {
        this.id = id;
        this.postulation = postulation;
        this.company = company;
        this.testToCompany = testToCompany;
        this.objections = objections;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPostulation() {
        return postulation;
    }

    public void setPostulation(String postulation) {
        this.postulation = postulation;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTestToCompany() {
        return testToCompany;
    }

    public void setTestToCompany(String testToCompany) {
        this.testToCompany = testToCompany;
    }

    public String getObjections() {
        return objections;
    }

    public void setObjections(String objections) {
        this.objections = objections;
    }
}
