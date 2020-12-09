package com.i4bchile.appperritos.model;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class Breed {

    private Map<String, List<String>> message ;
    private String status;

    public Breed(Map<String, List<String>> message, String status) {
        this.message = message;
        this.status = status;
    }

    public Map<String, List<String>> getMessage() {
        return message;
    }



    @NotNull
    @Override
    public String toString() {
        return "BreedList{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}
