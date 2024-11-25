package com.example.lab14zadanie2;
public class Player {
    private int number;
    private String surname;
    private String imageUrl;
    private String filePath;

    public Player(int number, String surname, String imageUrl) {
        this.number = number;
        this.surname = surname;
        this.imageUrl = imageUrl;
        this.filePath = null;
    }

    public int getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
