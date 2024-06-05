package org.example;

public class Movie {
    private int id;
    private String title;
    private double rating;
    private String type;

    public Movie(int id, String title, double rating, String type) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

