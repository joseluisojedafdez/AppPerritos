package com.i4bchile.appperritos.model;

import java.util.List;

public class BreedImage {
    
    private List<String> imageURLs;

    public List<String> getImages() {
        return imageURLs;
    }

    public void setImages(List<String> images) {
        this.imageURLs = images;
    }

    @Override
    public String toString() {
        return "BreedImage{" +
                "images=" + imageURLs +
                '}';
    }
}
