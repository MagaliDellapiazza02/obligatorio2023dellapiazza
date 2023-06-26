package entities;

import uy.edu.um.prog2.adt.linkedlist.LinkedList;

public class Hashtag {
    private long id;
    private String text;
    // array de datos string

    public Hashtag() {
        this.id = id;
        this.text = text;
    }

    public Hashtag(String text) {
        this.text = text;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
