package services;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Volunteer;
import utils.InputUtils;

public class VolunteerService {

    public static void volunteer() {
        String name = InputUtils.getString("Enter your name: ");
        String contact = InputUtils.getString("Enter your contact: ");
        
        Volunteer volunteer = new Volunteer(name, contact);
        
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO volunteers (name, contact) VALUES (?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, volunteer.getName());
            preparedStatement.setString(2, volunteer.getContact());

            int rowsAffected = preparedStatement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Thank you for volunteering!");
                volunteer.volunteerInfo();  
            } else {
                System.out.println("Volunteer registration failed, please try again.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while registering as a volunteer.");
        }
    }
}
