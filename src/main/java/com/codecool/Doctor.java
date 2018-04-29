package com.codecool;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Doctor extends Person {

    private int getBloodQuantity = 3; // Default value

    Doctor(String name) {
        super(name);
    }

    public void takeBlood(BloodDonationEvent event, Donor donor) {
        if (event.checkNumOfDoctorsOnEvent() < 2) System.out.println("Not enough doctors to take blood.");
        else if (event.isDonorOnList(donor)) {
            if (!event.isDonatedMoreThanWeek(donor)) System.out.println("Sorry " + donor.getName() + ", you donated less than a week.");
            else {
                howMuchBlood(donor);
                if (hasEnoughBlood(donor)) {
                    event.putIntoDonatedList(donor);
                    event.increaseEventBloodQuantity(getBloodQuantity);
                    donor.decreaseDonorBloodQuantity(getBloodQuantity);
                    System.out.println("Blood taken from " + donor.getName());
                }
                else System.out.println("Sorry " + donor.getName() + ", but you don't have enough blood.");
            }
        }
        else System.out.println(donor.getName() + " is not on the donor list");
    }

    private void howMuchBlood(Donor d) {
        System.out.print("How much blood do you want to take from " + d.getName() + "?\n" +
                "Enter a number between 1 and 5: ");
        try {
            Scanner sc = new Scanner(System.in);
            int temp = sc.nextInt();
            if (temp < 1) throw new Exception("Number is too LOW");
            else if (temp > 5) throw new Exception("Number is too HIGH");
            else getBloodQuantity = temp;
        }
        catch (InputMismatchException e) {
            System.out.println("I was not an integer. Please try again.");
            howMuchBlood(d);
        }
        catch (Exception e) {
            System.out.println("Default value (" + getBloodQuantity + ") will be used. The reason is: " + e);
        }
    }

    private boolean hasEnoughBlood(Donor d) {
        return d.getBloodInBody() - getBloodQuantity > 1;
    }
}