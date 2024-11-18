package com.example.lab11fix;





import com.google.gson.annotations.SerializedName;
import java.util.List;

class Event {
    @SerializedName("id")
    private int id;
    public int getId() { return id; }


    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("resourceURI")
    private String resourceURI;

    @SerializedName("urls")
    private List<Url> urls;

    @SerializedName("modified")
    private String modified;

    @SerializedName("start")
    private String start;

    @SerializedName("end")
    private String end;

    @SerializedName("thumbnail")
    private Thumbnail thumbnail;

    @SerializedName("creators")
    private Creators creators;

    @SerializedName("characters")
    private Characters characters;

    @SerializedName("stories")
    private Stories stories;

    @SerializedName("comics")
    private Comics comics;

    @SerializedName("series")
    private Series series;

    @SerializedName("next")
    private Resource next;

    @SerializedName("previous")
    private Resource previous;


    public static class Url {
        @SerializedName("type")
        private String type;

        @SerializedName("url")
        private String url;

        public String getType() { return type; }
        public void setType(String type) { this.type = type; }

        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }

    public static class Thumbnail {
        @SerializedName("path")
        private String path;

        @SerializedName("extension")
        private String extension;

        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }

        public String getExtension() { return extension; }
        public void setExtension(String extension) { this.extension = extension; }
    }

    public static class Creators {
        @SerializedName("available")
        private int available;

        @SerializedName("collectionURI")
        private String collectionURI;

        @SerializedName("items")
        private List<CreatorItem> items;

        @SerializedName("returned")
        private int returned;

        public static class CreatorItem {
            @SerializedName("resourceURI")
            private String resourceURI;

            @SerializedName("name")
            private String name;

            @SerializedName("role")
            private String role;

            public String getResourceURI() { return resourceURI; }
            public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public String getRole() { return role; }
            public void setRole(String role) { this.role = role; }
        }
    }

    public static class Characters {
        @SerializedName("available")
        private int available;

        @SerializedName("collectionURI")
        private String collectionURI;

        @SerializedName("items")
        private List<CharacterItem> items;

        @SerializedName("returned")
        private int returned;

        public static class CharacterItem {
            @SerializedName("resourceURI")
            private String resourceURI;

            @SerializedName("name")
            private String name;

            public String getResourceURI() { return resourceURI; }
            public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }
    }

    public static class Stories {
        @SerializedName("available")
        private int available;

        @SerializedName("collectionURI")
        private String collectionURI;

        @SerializedName("items")
        private List<StoryItem> items;

        @SerializedName("returned")
        private int returned;

        public static class StoryItem {
            @SerializedName("resourceURI")
            private String resourceURI;

            @SerializedName("name")
            private String name;

            @SerializedName("type")
            private String type;

            public String getResourceURI() { return resourceURI; }
            public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }

            public String getType() { return type; }
            public void setType(String type) { this.type = type; }
        }
    }

    public static class Comics {
        @SerializedName("available")
        private int available;

        @SerializedName("collectionURI")
        private String collectionURI;

        @SerializedName("items")
        private List<ComicItem> items;

        @SerializedName("returned")
        private int returned;

        public static class ComicItem {
            @SerializedName("resourceURI")
            private String resourceURI;

            @SerializedName("name")
            private String name;

            public String getResourceURI() { return resourceURI; }
            public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }
    }

    public static class Series {
        @SerializedName("available")
        private int available;

        @SerializedName("collectionURI")
        private String collectionURI;

        @SerializedName("items")
        private List<SeriesItem> items;

        @SerializedName("returned")
        private int returned;

        public static class SeriesItem {
            @SerializedName("resourceURI")
            private String resourceURI;

            @SerializedName("name")
            private String name;

            public String getResourceURI() { return resourceURI; }
            public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

            public String getName() { return name; }
            public void setName(String name) { this.name = name; }
        }
    }

    public static class Resource {
        @SerializedName("resourceURI")
        private String resourceURI;

        @SerializedName("name")
        private String name;

        public String getResourceURI() { return resourceURI; }
        public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }


  //  public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getResourceURI() { return resourceURI; }
    public void setResourceURI(String resourceURI) { this.resourceURI = resourceURI; }

    public List<Url> getUrls() { return urls; }
    public void setUrls(List<Url> urls) { this.urls = urls; }

    public String getModified() { return modified; }
    public void setModified(String modified) { this.modified = modified; }

    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }

    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }

    public Thumbnail getThumbnail() { return thumbnail; }
    public void setThumbnail(Thumbnail thumbnail) { this.thumbnail = thumbnail; }

    public Creators getCreators() { return creators; }
    public void setCreators(Creators creators) { this.creators = creators; }

    public Characters getCharacters() { return characters; }
    public void setCharacters(Characters characters) { this.characters = characters; }

    public Stories getStories() { return stories; }
    public void setStories(Stories stories) { this.stories = stories; }

    public Comics getComics() { return comics; }
    public void setComics(Comics comics) { this.comics = comics; }

    public Series getSeries() { return series; }
    public void setSeries(Series series) { this.series = series; }

    public Resource getNext() { return next; }
    public void setNext(Resource next) { this.next = next; }

    public Resource getPrevious() { return previous; }
    public void setPrevious(Resource previous) { this.previous = previous; }
}