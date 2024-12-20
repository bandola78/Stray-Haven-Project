![logo](https://github.com/bandola78/Stray-Haven-Project/blob/main/logos/logo.png)

**Stray Haven** is a Java-based application that helps manage the adoption process for stray animals, volunteer registration, and donation tracking. The application integrates with a MySQL database to store and manage essential data such as animal information, adoptions, volunteers, and donations.

## Features

- **Register Animals**: Add new animals to the database with details like name, color, age, and type.
- **Adopt Animals**: Register the adoption of animals by linking adopters to the animal they choose.
- **Volunteer Registration**: Allow users to sign up as volunteers by providing their contact details.
- **Donations**: Users can make donations, and the amount is recorded in the database.

## Technologies Used

- **Java**: Programming language for the application.
- **MySQL**: Database to store and manage data.
- **JDBC**: Used for connecting Java to MySQL.

## Folder Structure
```
StrayHaven/
|-- src/
|    |-- main/
|    |    |-- Main.java
|    |-- db/
|    |    |-- DatabaseConnection.java
|    |-- models/
|    |    |-- Animal.java
|    |    |-- Volunteer.java
|    |    |-- Donation.java
|    |    |-- Adoption.java
|    |-- services/
|    |    |-- AnimalService.java
|    |    |-- VolunteerService.java
|    |    |-- DonationService.java
|    |    |-- AdoptionService.java
|    |-- utils/
|    |    |-- InputUtils.java
|    |-- lib/
|    |    |-- .jar

```
## Database Design

The application uses four tables in the MySQL database:

1. **animals**: Stores information about the animals (name, color, age, type).
2. **adoptions**: Tracks which adopter has adopted which animal.
3. **volunteers**: Stores volunteer information, including name and contact.
4. **donations**: Stores donor information and the donation amount.

### Table Definitions:

```sql
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
```

##Installation & Setup
1. Clone the Repository:

git clone https://github.com/your-username/stray-haven.git

2. Set up the MySQL Database:

Create a database named strayhaven in MySQL.
Run the SQL schema to create the necessary tables.

3. Configure Database Connection:

Ensure MySQL is running.
Update the DatabaseConnection.java file with your MySQL credentials if needed.

4. Run the Application:

Use any IDE (e.g., IntelliJ IDEA, Eclipse) to run the Main.java file.

## Example Usage
Register an Animal

1. Register Animal
Enter animal name: Maddie
Enter animal color: brown
Enter animal age: 2
Enter animal type (dog/cat): dog
Animal registered successfully!
Animal Name: Maddie, Type: dog, Color: brown, Age: 2
Adopt an Animal

2. Adopt Animal
Enter adopter's name: John Doe
Enter animal name to adopt: Maddie
Animal adopted successfully by John Doe!
Volunteer Registration

3. Volunteer
Enter your name: Jane Smith
Enter your contact: janesmith@example.com
Volunteer registered successfully!
Make a Donation

4. Donate
Enter your name: Sarah Lee
Enter donation amount: $50
Donation of $50 made successfully!

## About the Developer 👋 👩‍💻
Hi, I'm Jobelyn Bandola, the developer of Stray Connect. This project was created as part of my Database Management Systems (DBMS) final project, adhering to database design principles while contributing to Sustainable Development Goal (SDG) 15: Life on Land. Developing Stray Connect has been a rewarding experience, allowing me to refine my programming skills and explore concepts like database management, SQL queries, and logic building.

Thank you for exploring my project! Stray Connect represents not just an academic milestone but also a step toward meaningful community service. I hope to continue improving and expanding this project in the future.
