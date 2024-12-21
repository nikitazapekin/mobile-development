package com.example.lab11new;


public class SunriseResponse {
    private Results results;

    public Results getResults() {
        return results;
    }

    public static class Results {
        private String sunrise;
        private String sunset;

        public String getSunrise() {
            return sunrise;
        }

        public String getSunset() {
            return sunset;
        }
    }
}
