package com.example.listview;

public class Student {
    private int photoResourceId;
    private String name;
    private int rollNumber;
    private String details;

    public Student(String name, int rollNumber, String details) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.details = details;
        this.photoResourceId = photoResourceId;

    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getDetails() {
        return details;
    }
    public int getPhotoResourceId() {
        return photoResourceId;
    }
    public void setPhotoResourceId(int photoResourceId) {
        this.photoResourceId = photoResourceId;
    }
}
