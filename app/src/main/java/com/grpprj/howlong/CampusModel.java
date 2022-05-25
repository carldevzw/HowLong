package com.grpprj.howlong;

public class CampusModel {

    private String Name, Faculty, Services;

    public CampusModel() {

    }

    public CampusModel(String Name, String Faculty, String Services) {
        this.Name = Name;
        this.Faculty = Faculty;
        this.Services = Services;
    }

    public String getName() {
        return Name;
    }

    public String getFaculty() {
        return Faculty;
    }

    public String getServices() {
        return Services;
    }
}
