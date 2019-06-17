package com.iniesta.darshan.models;

public class HotelModel {

    private int imageId;
    private String title;
    private String address;
    private int price;
    private Double rating;
    private String roomSize;
    private boolean tv,sofa,ac;

    public HotelModel(int imageId, String title, String address, int price, Double rating, String roomSize, boolean tv, boolean sofa, boolean ac) {
        this.imageId = imageId;
        this.title = title;
        this.address = address;
        this.price = price;
        this.rating = rating;
        this.roomSize = roomSize;
        this.tv = tv;
        this.sofa = sofa;
        this.ac = ac;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public int getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public boolean hasTv() {
        return tv;
    }

    public boolean hasSofa() {
        return sofa;
    }

    public boolean hasAc() {
        return ac;
    }
}