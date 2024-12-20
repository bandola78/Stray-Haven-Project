package services;

import db.DatabaseConnection;
import models.StrayAnimal;
import models.AnimalAttributes;
import utils.InputUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalServices {

    public static void registerAnimal() {
        String name = InputUtils.getString("Enter animal name: ");
        String species = InputUtils.getString("Enter species (e.g., Dog, Cat): ");
        String genderInput = InputUtils.getString("Enter gender (Male/Female): ");
        AnimalAttributes.Gender gender = AnimalAttributes.Gender.valueOf(genderInput.toUpperCase());
        String color = InputUtils.getString("Enter color: ");
        int approxAge = InputUtils.getInt("Enter approximate age: ");
        String sizeInput = InputUtils.getString("Enter size (Small, Medium, Large): ");
        AnimalAttributes.Size size = AnimalAttributes.Size.valueOf(sizeInput.toUpperCase());
        boolean isVaccinated = InputUtils.getInt("Is the animal vaccinated? (1 for Yes, 0 for No): ") == 1;
        String healthStatus = InputUtils.getString("Enter health status: ");
        String locationFound = InputUtils.getString("Enter location where the animal was found: ");
        String rescuerName = InputUtils.getString("Enter rescuer's name: ");
        String rescuerContact = InputUtils.getString("Enter rescuer's contact: ");

        StrayAnimal newAnimal = new StrayAnimal(name, gender, AnimalAttributes.Species.valueOf(species.toUpperCase()), 
                                                color, approxAge, size, isVaccinated, healthStatus, 
                                                locationFound, null, rescuerName, rescuerContact);

        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO animals (name, species, gender, color, approx_age, size, vaccinated, health_status, " +
                         "location_found, rescuer_name, rescuer_contact) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newAnimal.getName());
            statement.setString(2, newAnimal.getSpecies().toString());
            statement.setString(3, newAnimal.getGender().toString());
            statement.setString(4, newAnimal.getColor());
            statement.setInt(5, newAnimal.getApproxAge());
            statement.setString(6, newAnimal.getSize().toString());
            statement.setBoolean(7, newAnimal.isVaccinated());
            statement.setString(8, newAnimal.getHealthStatus());
            statement.setString(9, newAnimal.getLocationFound());
            statement.setString(10, newAnimal.getRescuerName());
            statement.setString(11, newAnimal.getRescuerContact());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Animal registered successfully!");
            } else {
                System.out.println("Failed to register the animal.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}