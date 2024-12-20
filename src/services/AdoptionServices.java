package services;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Adoption;
import models.Animal;

public class AdoptionService {

    // Modify adoptAnimal to accept adopterName and animalName as arguments
    public static void adoptAnimal(String adopterName, String animalName) {
        String query = "SELECT * FROM animals WHERE name = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, animalName);

            Animal animal = new Animal(animalName, "Unknown", 3, "Unknown") {
                @Override
                public void animalDetails() {
                    System.out.println("Animal Name: " + getName() + ", Type: " + getType() + ", Color: " + getColor() + ", Age: " + getAge());
                }
            };

            Adoption adoption = new Adoption(adopterName, animal);
            adoption.adoptionInfo();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
