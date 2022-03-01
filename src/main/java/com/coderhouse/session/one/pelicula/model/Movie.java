package com.coderhouse.session.one.pelicula.model;

public class Movie {

    private int id;
    private String title;
    private String category;
    private String actor;

    public Movie(int id, String title, String category, String actor) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.actor = actor;
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getActor() {
        return actor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
