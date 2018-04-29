package com.codecool;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BloodDonationEvent {

    private String place;
    private int duration; //  in hours
    private int bloodQuantity = 0;
    private List<Person> personListOnEvent = new ArrayList<>();
    private HashMap<Integer,Integer> donatedDonors= new HashMap<>();
    private int currentDate = 28;

    BloodDonationEvent(String place, int duration) {
        this.place = place;
        this.duration = duration;
    }

    public void addPersonToEvent(Person p) {
        if (p instanceof Doctor) personListOnEvent.add(p);
        else if (p instanceof Donor) {
            if (isThereFreePlaces()) {
                if (canDonorReg((Donor) p)) {
                    personListOnEvent.add(p);
                    System.out.println(((Donor) p).getName() + " registered as a donor");
                }
                else System.out.println("Sorry " + ((Donor) p).getName() + ", you are under 14.");
            }
            else System.out.println("Sorry " + ((Donor) p).getName() + ", no more free places available.");
        }
        else System.out.println("Unexpected person class");
    }

    private boolean canDonorReg(Donor p) {
        int currentYear = 2018;
        return currentYear - p.getYearOfBirth() >= 14;
    }

    public int checkNumOfDoctorsOnEvent() {
        int doctorsOnList = 0;
        for (Person person : personListOnEvent) {
            if (person instanceof Doctor) doctorsOnList++;
        }
        return doctorsOnList;
    }

    private int checkNumOfDonorsOnEvent() {
        int donorsOnList = 0;
        for (Person person : personListOnEvent) {
            if (person instanceof Donor) donorsOnList++;
        }
        return  donorsOnList;
    }

    private boolean isThereFreePlaces() {
        if (checkNumOfDoctorsOnEvent() < 2) return false;
        else if (checkNumOfDoctorsOnEvent() % 2 == 0) return checkNumOfDoctorsOnEvent() * duration > checkNumOfDonorsOnEvent();
        else return (checkNumOfDoctorsOnEvent()-1) * duration > checkNumOfDonorsOnEvent();
    }

    public boolean isDonorOnList(Donor d) {
        for (Person p : personListOnEvent) {
            if (p.name.equals(d.getName())) return true;
        }
        return false;
    }

    private int lastDonation(Donor d) {
        int date = 0;
        for (Integer key : donatedDonors.keySet()) {
            if (key == d.getID()) {
                date = donatedDonors.get(key);
            }
        }
        return date;
    }

    public boolean isDonatedMoreThanWeek(Donor d) {
        return currentDate - lastDonation(d) > 7;
    }

    public void putIntoDonatedList(Donor d) {
        donatedDonors.put(d.getID(), currentDate);
    }

    public void increaseEventBloodQuantity(int num) {
        bloodQuantity += num;
    }

    public void showInfo() {
        System.out.println("EVENT INFO:" +
                "\nPlace: " + place +
                "\nDuration: " + duration + " hour" +
                "\nCurrent: " +
                "\n  Blood quantity: " + bloodQuantity +
                "\n  Num of doctors: " + checkNumOfDoctorsOnEvent() +
                "\n  Num of donors: " + checkNumOfDonorsOnEvent() +
                "\n  Donations: " + donatedDonors.size() );
    }

}