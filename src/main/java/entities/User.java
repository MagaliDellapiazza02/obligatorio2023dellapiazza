package entities;

import uy.edu.um.prog2.adt.linkedlist.LinkedList;

public class User {
    private long id;
    private String name;

    private double userFavourites;
    private boolean userVerified;
    private double amountOfTweets;
    private LinkedList<Tweet> tweets;

    public User() {
        this.tweets = new LinkedList<>();
    }

    public User(String name, double userFavourites, boolean userVerified) {
        this.name = name;
        this.userFavourites = userFavourites;
        this.userVerified = userVerified;
        this.tweets = new LinkedList<>();
        this.amountOfTweets = tweets.size();

    }

    public void setTweets(Tweet tweet) {
        this.tweets.add(tweet);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUserFavourites() {
        return userFavourites;
    }

    public void setUserFavourites(double userFavourites) {
        this.userFavourites = userFavourites;
    }

    public boolean isUserVerified() {
        return userVerified;
    }

    public void setUserVerified(boolean userVerified) {
        this.userVerified = userVerified;
    }

    public LinkedList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(LinkedList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public double getAmountOfTweets() {
        return amountOfTweets;
    }

    public void setAmountOfTweets(double amountOfTweets) {
        this.amountOfTweets = amountOfTweets;
    }

    public void incrementAmountOfTweets(){
        this.amountOfTweets++;
    }



}
