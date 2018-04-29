package com.example.jiteshnarula.techfusionapp.Workshop;

public class Workshop {

   private  int id;
    private String name;
    private  Double price;
    private  String photo;


    public Workshop(int id, String name, Double price, String photo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.photo = photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getPhoto() {
        return photo;
    }
}
