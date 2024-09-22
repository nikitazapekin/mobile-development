package com.example.lab_3;

public class UserData {
    private static UserData instance;
    private String firstName;
    private String lastName;
    private String phone;


    private  String fromName;
    private  String fromAdress;
    private  String toName;
    private  String toAdress;

    private UserData() { }

    public static synchronized UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  String getFromName() {
        return this.fromName;
    }
    public  String getFromAdress() {
        return this.fromAdress;
    }
    public  String getToName() {
        return this.toName;
    }
    public  String getToAdress() {
        return this.toAdress;
    }

    public  void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public  void setFromAdress(String fromAdress) {
        this.fromAdress = fromAdress;
    }

    public  void setToName(String toName) {
        this.toName = toName;
    }

    public  void setToAdress(String toAdress) {
        this.toAdress = toAdress;
    }

}
