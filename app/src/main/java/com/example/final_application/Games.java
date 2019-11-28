package com.example.final_application;


import androidx.appcompat.app.AppCompatActivity;

public class Games {
//https://www.giantbomb.com/api/franchises/?api_key=81ddcc9bf59c3f432f7a1dfa1827e28ee6fbc005&format=json&field_list=image,name,concepts,date_added,date_last_updated,id,deck

//    image,name,date_added,date_last_updated,id,deck
    private String image;
    private String name;
    private String date_added;
    private String date_last_updated;
    private String deck;

    public Games(){


    }

    public Games(String image, String name, String date_added, String date_last_updated, String deck) {
        this.image = image;
        this.name = name;
        this.date_added = date_added;
        this.date_last_updated = date_last_updated;
        this.deck = deck;
    }

    public  String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_added() {
        return date_added;
    }

    public void setDate_added(String date_added) {
        this.date_added = date_added;
    }

    public String getDate_last_updated() {
        return date_last_updated;
    }

    public void setDate_last_updated(String date_last_updated) {
        this.date_last_updated = date_last_updated;
    }

    public String getDeck() {
        return deck;
    }

    public void setDeck(String deck) {
        this.deck = deck;
    }
}
