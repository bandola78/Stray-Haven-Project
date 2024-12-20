package services;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Donation;
import utils.InputUtils;

public class DonationService {

    public static void donate() {
        String donorName = InputUtils.getString("Enter your name: ");
        double amount = InputUtils.getDouble("Enter donation amount: $");

        Donation donation = new Donation(donorName, amount);
        
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO donations (donor_name, amount) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, donation.getDonorName());
            preparedStatement.setDouble(2, donation.getAmount());

            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Thank you for your donation!");
                donation.donationInfo(); 
            } else {
                System.out.println("Donation failed, please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while processing the donation.");
        }
    }
}
