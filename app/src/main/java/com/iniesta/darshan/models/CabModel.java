package com.iniesta.darshan.models;

public class CabModel {
    private String carname;


    private int image_drawable,rating,seater,luggage,price;
    boolean ac;

    public String getName() {
        return carname;
    }

    public void setName(String carname) {
        this.carname = carname;
    }

    public int getprice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getImage_drawable() {
        return image_drawable;
    }

    public void setImage_drawable(int image_drawable) {
        this.image_drawable = image_drawable;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating= rating;
    }

    public int getSeater() {
        return seater;
    }

    public void setSeater(int seater) {
        this.seater = seater;
    }

    public boolean getAc() {
        return ac;
    }

    public void setAc(Boolean ac) {
        this.ac= ac;
    }
    public int getLuggage() {
        return luggage;
    }

    public void setLuggage(int luggage) {
        this.luggage= luggage;
    }





}

