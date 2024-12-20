package services;

import db.DatabaseConnection;
import utils.InputUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DonationService {

    public static void donate() {
        String donorName = InputUtils.getString("Enter donor's name: ");
        double amount = InputUtils.getInt("Enter donation amount: ");
        LocalDate donationDate = LocalDate.now();

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO donations (donor_name, amount, donation_date) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, donorName);
            statement.setDouble(2, amount);
            statement.setDate(3, java.sql.Date.valueOf(donationDate));

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Donation registered successfully!");
            } else {
                System.out.println("Failed to register the donation.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}