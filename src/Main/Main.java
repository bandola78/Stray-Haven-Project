package main;

import services.*;
import utils.InputUtils;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Stray Haven");
        boolean running = true;

        while (running) {
            System.out.println("\n1. Register Animal");
            System.out.println("2. Adopt Animal");
            System.out.println("3. Volunteer");
            System.out.println("4. Donate");
            System.out.println("5. Exit");
            
            int choice = InputUtils.getInt("Choose an option: ");

            switch (choice) {
                case 1:
                    AnimalService.registerAnimal();
                    break;
                case 2:
                    AdoptionService.adoptAnimal();
                    break;
                case 3:
                    VolunteerService.volunteer();
                    break;
                case 4:
                    DonationService.donate();
                    break;
                case 5:
                    running = false;  
                    System.out.println("Thank you for using Stray Haven!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}