package com.example.app.model;

/**
 * Created by lgvalle on 05/04/14.
 */
public class NewsElement {

    private int id;
    private CharSequence title;
    private CharSequence description;


    public NewsElement(int id, CharSequence title, CharSequence description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;
    }

    public CharSequence getDescription() {
        return description;
    }

    public void setDescription(CharSequence description) {
        this.description = description;
    }
}
