package com.angelfgdeveloper.manresapp.data.models;

public class Work {

    private int id = 0;
    private String company = "";
    private String workstation = "";
    private String released = "";
    private String title = "";
    private String description = "";
    private String location = "";
    private String category = "";
    private String payments = "";
    private int salary = 0;

    public Work() {}

    public Work(int id, String company, String workstation, String released, String title, String description, String location, String category, String payments, int salary) {
        this.id = id;
        this.company = company;
        this.workstation = workstation;
        this.released = released;
        this.title = title;
        this.description = description;
        this.location = location;
        this.category = category;
        this.payments = payments;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getWorkstation() {
        return workstation;
    }

    public void setWorkstation(String workstation) {
        this.workstation = workstation;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
