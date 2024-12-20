package services;

import db.DatabaseConnection;
import utils.InputUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VolunteerServices {

    public static void volunteer() {
        String name = InputUtils.getString("Enter your name: ");
        String contactInfo = InputUtils.getString("Enter your contact information: ");

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO volunteers (name, contact_info) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, contactInfo);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Thank you for volunteering!");
            } else {
                System.out.println("Failed to register volunteer.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
