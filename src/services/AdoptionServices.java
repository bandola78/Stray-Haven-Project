package services;

import db.DatabaseConnection;
import models.AdoptionRecord;
import models.StrayAnimal;
import utils.InputUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class AdoptionServices {

    public static void adoptAnimal() {
        String adopterName = InputUtils.getString("Enter adopter's name: ");
        String animalName = InputUtils.getString("Enter the animal's name to adopt: ");

        StrayAnimal adoptedAnimal = getAnimalByName(animalName);

        if (adoptedAnimal != null) {
            LocalDate adoptionDate = LocalDate.now();
            AdoptionRecord adoptionRecord = new AdoptionRecord(adopterName, adoptedAnimal, adoptionDate);
            
            try (Connection connection = DatabaseConnection.getConnection()) {
                String sql = "INSERT INTO adoption_records (adopter_name, animal_id, adoption_date) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, adoptionRecord.getAdopterName());
                statement.setInt(2, adoptedAnimal.getId());  // Assume getId() is a method to fetch animal's ID
                statement.setDate(3, java.sql.Date.valueOf(adoptionRecord.getAdoptionDate()));

                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Adoption registered successfully!");
                } else {
                    System.out.println("Failed to register the adoption.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        } else {
            System.out.println("Animal not found for adoption.");
        }
    }

    private static StrayAnimal getAnimalByName(String animalName) {
        StrayAnimal animal = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM animals WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, animalName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                animal = new StrayAnimal(resultSet.getString("name"), 
                                         AnimalAttributes.Gender.valueOf(resultSet.getString("gender")),
                                         AnimalAttributes.Species.valueOf(resultSet.getString("species")),
                                         resultSet.getString("color"),
                                         resultSet.getInt("approx_age"),
                                         AnimalAttributes.Size.valueOf(resultSet.getString("size")),
                                         resultSet.getBoolean("vaccinated"),
                                         resultSet.getString("health_status"),
                                         resultSet.getString("location_found"),
                                         resultSet.getDate("date_rescued").toLocalDate(),
                                         resultSet.getString("rescuer_name"),
                                         resultSet.getString("rescuer_contact"));
                animal.setId(resultSet.getInt("id"));  
            }
        } catch (SQLException e) {
            System.out.println("Error fetching animal: " + e.getMessage());
        }
        return animal;
    }
}
