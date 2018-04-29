package com.company;

public class Main {

    public static void main(String[] args) {

        BloodDonationEvent even1 = new BloodDonationEvent("Miskolc",1);

        Doctor doc1 = new Doctor("Dr. Dolittle");
        Doctor doc2 = new Doctor("Dr. Who");
        Doctor doc3 = new Doctor("Dr. Bones");
        Doctor doc4 = new Doctor("Dr. John");
        even1.addPersonToEvent(doc1);
        even1.addPersonToEvent(doc2);
        even1.addPersonToEvent(doc3);
//        even1.addPersonToEvent(doc4);

        Donor d1 = new Donor("Ági",1980,6, 1001, "agi@valami.hu");
        Donor d2 = new Donor("Béla",2010,5 ,1002, "bela@valami.hu");
        Donor d3 = new Donor("Cecilia",1990,4, 1003, "cecilia@valami.hu");
        Donor d4 = new Donor("Dávid",2000,3, 1004, "david@valami.hu");
        Donor d5 = new Donor("Emilia",1982, 2,1005, "emilia@valami.hu");
        Donor d6 = new Donor("Ferenc",1985, 1,1006, "ferenc@valami.hu");

        System.out.println("\nREGISTRATION PROCESS:\n");
        even1.addPersonToEvent(d1);
        even1.addPersonToEvent(d2);
        even1.addPersonToEvent(d3);
        even1.addPersonToEvent(d4);
        even1.addPersonToEvent(d5);
        even1.addPersonToEvent(d6);

        System.out.println("\n******************************\n");
        doc1.takeBlood(even1, d1);
        doc1.takeBlood(even1, d1);
        doc1.takeBlood(even1, d2);
        doc1.takeBlood(even1, d3);
        doc1.takeBlood(even1, d4);
        doc1.takeBlood(even1, d5);
        doc1.takeBlood(even1, d6);

        System.out.println("\n******************************\n");
        even1.showInfo();

        System.out.println("\n******************************\n");
        d1.showInfo();
        d2.showInfo();
        d3.showInfo();
        d4.showInfo();
        d5.showInfo();
        d6.showInfo();
    }
}