CREATE DATABASE strayhaven;

USE strayhaven;

CREATE TABLE animals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    color VARCHAR(100),
    age INT,
    type VARCHAR(50)
);

CREATE TABLE adoptions (
    id INT AUTO_INCREMENT PRIMARY KEY,
    adopter_name VARCHAR(255),
    animal_id INT,
    FOREIGN KEY (animal_id) REFERENCES animals(id)
);

CREATE TABLE volunteers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    contact VARCHAR(255)
);

CREATE TABLE donations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    donor_name VARCHAR(255),
    amount DECIMAL(10, 2)
); 

SELECT * FROM animals;
SELECT * FROM adoptions;
SELECT * FROM donations;
SELECT * FROM volunteers;