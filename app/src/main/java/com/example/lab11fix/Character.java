package com.example.lab11fix;
import java.util.List;

public class Character {
    private int id;
    private String name;
    private String description;
    private String modified;
    private Thumbnail thumbnail;
    private String resourceURI;
    private Comics comics;
    private Series series;
    private Stories stories;
    private Events events;
    private List<Url> urls;

    public Thumbnail getThumbnail() {
        return thumbnail;
    }


    public static class Thumbnail {
        private String path;
        private String extension;


        public Object getExtension() {
            return extension;
        }

        public String getPath() {
            return  path;
        }


    }

    public static class Comics {
        private int available;
        private String collectionURI;
        private List<ComicItem> items;



        public static class ComicItem {
            private String resourceURI;
            private String name;


        }
    }

    public static class Series {
        private int available;
        private String collectionURI;
        private List<SeriesItem> items;



        public static class SeriesItem {
            private String resourceURI;
            private String name;

        }
    }

    public static class Stories {
        private int available;
        private String collectionURI;
        private List<StoryItem> items;



        public static class StoryItem {
            private String resourceURI;
            private String name;
            private String type;


        }
    }

    public static class Events {
        private int available;
        private String collectionURI;
        private List<EventItem> items;

        // Getters and setters

        public static class EventItem {
            private String resourceURI;
            private String name;

            // Getters and setters
        }
    }

    public static class Url {
        private String type;
        private String url;

        // Getters and setters
    }
}
