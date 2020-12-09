package com.i4bchile.appperritos.model;

import org.jetbrains.annotations.NotNull;

public class Favorites {

    private String breed;
    private String urlImage;
    private String timeStamp;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @NotNull
    @Override
    public String toString() {
        return "Favorites{" +
                "breed='" + breed + '\'' +
                ", urlImage='" + urlImage + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
