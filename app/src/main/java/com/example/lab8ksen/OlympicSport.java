package com.example.lab8ksen;

// package com.example.lab8ksen;

import java.util.ArrayList;
import java.util.List;

public class OlympicSport {

    private String name;
    private int logo;
    private boolean isSummer;
    private boolean isTeam;
    private int recognitionYear;

    public OlympicSport(String name, int logo, boolean isSummer, boolean isTeam, int recognitionYear) {
        this.name = name;
        this.logo = logo;
        this.isSummer = isSummer;
        this.isTeam = isTeam;
        this.recognitionYear = recognitionYear;
    }

    public String getName() {
        return name;
    }

    public int getLogo() {
        return logo;
    }

    public boolean isSummer() {
        return isSummer;
    }

    public boolean isTeam() {
        return isTeam;
    }

    public int getRecognitionYear() {
        return recognitionYear;
    }

    private static List<OlympicSport> sports = new ArrayList<>();

    public static List<OlympicSport> getSports() {
        if (sports.isEmpty()) {
            sports.add(new OlympicSport("Football", R.drawable.ic_launcher_background, true, true, 1900));
            sports.add(new OlympicSport("Skiing", R.drawable.ic_launcher_background, false, false, 1924));
            sports.add(new OlympicSport("Basketball", R.drawable.ic_launcher_background, true, true, 1936));
        }
        return sports;
    }
}
