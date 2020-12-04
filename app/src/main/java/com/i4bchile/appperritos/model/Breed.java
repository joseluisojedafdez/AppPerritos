package com.i4bchile.appperritos.model;

import java.util.List;
import java.util.Map;

public class Breed {

    private Map<String, List<String>> message ;
    private String status;

    public Map<String, List<String>> getMessage() {
        return message;
    }

    public void setMessage(Map<String, List<String>> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BreedList{" +
                "message=" + message +
                ", status='" + status + '\'' +
                '}';
    }
}
