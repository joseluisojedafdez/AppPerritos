package com.i4bchile.appperritos.model;

import java.util.List;

public class BreedImage {
    
    private List<String> images;

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "BreedImage{" +
                "images=" + images +
                '}';
    }
}
