package com.example.demo;

public class CvRecord {

    private final int id;
    private final CurriculumVitae cv;

    public CvRecord(int id, CurriculumVitae cv) {
        this.id = id;
        this.cv = cv;
    }

    public int getId() {
        return id;
    }

    public CurriculumVitae getCv() {
        return cv;
    }

    @Override
    public String toString() {
        if (cv.getEm() == null || cv.getEm().isBlank()) {
            return cv.getFn();
        }
        return cv.getFn() + " (" + cv.getEm() + ")";
    }
}