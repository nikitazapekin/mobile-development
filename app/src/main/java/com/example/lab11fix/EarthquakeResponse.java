/*package com.example.lab11fix;

public class EarthquakeResponse {
    private String id;
    private Properties properties;

    public String getId() {
        return id;
    }

    public Properties getProperties() {
        return properties;
    }

    public static class Properties {
        private double mag;
        private String place;
        private long time;
        private String status;
        private String title;
        private String alert;
        private Double cdi;
        private Double mmi;

        // Геттеры
        public double getMag() {
            return mag;
        }

        public String getPlace() {
            return place;
        }

        public long getTime() {
            return time;
        }

        public String getStatus() {
            return status;
        }

        public String getTitle() {
            return title;
        }

        public String getAlert() {
            return alert;
        }

        public Double getCdi() {
            return cdi;
        }

        public Double getMmi() {
            return mmi;
        }
    }
}
*/

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
