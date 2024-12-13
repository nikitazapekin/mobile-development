package com.example.lab11fix;



import java.util.List;

public class EarthquakeResponse {
    private List<Feature> features;

    public List<Feature> getFeatures() {
        return features;
    }

    public static class Feature {
        private Properties properties;
        private String id;
        public Properties getProperties() {
            return properties;
        }
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class Properties {
            private String place;
            private double mag;
            private long time;

            public String getPlace() {
                return place;
            }

            public double getMag() {
                return mag;
            }

            public long getTime() {
                return time;
            }
        }
    }
}
