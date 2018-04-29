package com.codecool;

public class Donor extends Person {

    private int yearOfBirth;
    private int bloodInBody;
    private int id ;
    private String email;

    Donor(String name, int yearOfBirth, int bloodInBody, int id, String email) {
        super(name);
        this.yearOfBirth = yearOfBirth;
        this.bloodInBody = bloodInBody;
        this.id = id;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public int getBloodInBody() {
        return bloodInBody;
    }

    public void decreaseDonorBloodQuantity(int num) {
        bloodInBody -= num;
    }

    public int getID() {
        return id;
    }

    public void showInfo(){
        System.out.println(name + ", Year of Birth: " + yearOfBirth + ", ID: " + id + ", Current blood: " + bloodInBody + ", Email: " + email);
    }
}