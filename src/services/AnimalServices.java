package services;

import db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import models.Animal;
import utils.InputUtils;

public class AnimalService {

    public static void registerAnimal() {
        String name = InputUtils.getString("Enter animal name: ");
        String color = InputUtils.getString("Enter animal color: ");
        int age = InputUtils.getInt("Enter animal age: ");
        String type = InputUtils.getString("Enter animal type (dog/cat): ");

        Animal animal = new Animal(name, color, age, type) {
            @Override
            public void animalDetails() {
                System.out.println("Animal Name: " + getName() + ", Type: " + getType() + ", Color: " + getColor() + ", Age: " + getAge());
            }
        };

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO animals (name, color, age, type) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, animal.getName());
            preparedStatement.setString(2, animal.getColor());
            preparedStatement.setInt(3, animal.getAge());
            preparedStatement.setString(4, animal.getType());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Animal registered successfully in the database!");
                animal.animalDetails();
            } else {
                System.out.println("Failed to register the animal in the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("An error occurred while saving the animal to the database.");
        }
    }
}
