package com.example.lab11fix;

public class MarvelItem {
    private String name;
    private String resourceURI;
    private String imageUrl;
    private Thumbnail thumbnail;
    private String imagePath;
    private String imageExtension;

    // Constructor
    public MarvelItem(String name, String resourceURI, Thumbnail thumbnail) {
        this.name = name;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    // Setter for imagePath
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setImageExtension(String imageExtension) {
        this.imageExtension = imageExtension;
    }


    public String getImageExtension() {
        return thumbnail != null ? thumbnail.getExtension() : null;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public static class Thumbnail {
        private String path;
        private String extension;

        public Thumbnail(String path, String extension) {
            this.path = path;
            this.extension = extension;
        }

        public String getPath() {
            return path;
        }

        public String getExtension() {
            return extension;
        }
    }
}
