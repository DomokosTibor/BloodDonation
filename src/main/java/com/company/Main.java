package com.company;

import com.company.CustomException.ExceptionEventFull;
import com.company.CustomException.ExceptionTooYoung;
import com.company.CustomException.ExceptionUnexpectedClass;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BloodDonationEvent even1 = new BloodDonationEvent("Miskolc",1);

        Doctor doc1 = new Doctor("Dr. Dolittle");
        Doctor doc2 = new Doctor("Dr. Who");
        Doctor doc3 = new Doctor("Dr. Bones");
        Doctor doc4 = new Doctor("Dr. John");

        Donor d1 = new Donor("Ági",1980,6, 1001, "agi@valami.hu");
        Donor d2 = new Donor("Béla",2010,5 ,1002, "bela@valami.hu");
        Donor d3 = new Donor("Cecilia",1990,4, 1003, "cecilia@valami.hu");
        Donor d4 = new Donor("Dávid",2000,3, 1004, "david@valami.hu");
        Donor d5 = new Donor("Emilia",1982, 2,1005, "emilia@valami.hu");
        Donor d6 = new Donor("Ferenc",1985, 1,1006, "ferenc@valami.hu");

        List<Person> justForTheLoop = new ArrayList<>();
        justForTheLoop.add(doc1);
        justForTheLoop.add(doc2);
        justForTheLoop.add(doc3);
        justForTheLoop.add(d1);
        justForTheLoop.add(d2);
        justForTheLoop.add(d3);
        justForTheLoop.add(d4);
        justForTheLoop.add(d5);
        justForTheLoop.add(d6);

        System.out.println("\nREGISTRATION PROCESS:\n");
        for (int i=0; i<justForTheLoop.size(); i++) {
            try {
                even1.addPersonToEvent(justForTheLoop.get(i));
            } catch (ExceptionTooYoung | ExceptionEventFull | ExceptionUnexpectedClass e) {
                System.out.println(e);
            }
        }

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