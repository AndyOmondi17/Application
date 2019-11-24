
package com.example.final_application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("date_added")
    @Expose
    private String dateAdded;
    @SerializedName("date_last_updated")
    @Expose
    private String dateLastUpdated;
    @SerializedName("deck")
    @Expose
    private String deck;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Result() {
    }

    /**
     * 
     * @param image
     * @param dateLastUpdated
     * @param deck
     * @param name
     * @param dateAdded
     */
    public Result(String dateAdded, String dateLastUpdated, String deck, Image image, String name) {
        super();
        this.dateAdded = dateAdded;
        this.dateLastUpdated = dateLastUpdated;
        this.deck = deck;
        this.image = image;
        this.name = name;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(String dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
