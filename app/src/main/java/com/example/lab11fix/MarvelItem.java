

package com.example.lab11fix;
public class MarvelItem {
    private final String name;
    private final String resourceURI;
    private String thumbnailUrl;

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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
