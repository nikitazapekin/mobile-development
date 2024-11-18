package com.example.lab11fix;
public class MarvelItem {
    private String name;
    private String resourceURI;

    public MarvelItem(String name, String resourceURI) {
        this.name = name;
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public String getResourceURI() {
        return resourceURI;
    }
}
