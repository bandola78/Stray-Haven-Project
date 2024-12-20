

Stray Haven is a Java-based application that helps manage animal adoptions, donations, and volunteer registrations for a fictional animal shelter. The application connects to a MySQL database to store and manage data such as animal details, adoption information, donation records, and volunteer contact information.

## Features

1. **Register Animal**: Users can register animals (such as dogs and cats) into the system with details such as name, type, color, and age.
2. **Adopt Animal**: Users can adopt an animal by providing their name and selecting the animal they wish to adopt.
3. **Donate**: Users can donate money to the shelter by entering their name and donation amount.
4. **Volunteer**: Users can register as a volunteer by entering their name and contact details.

## Technology Stack

- **Programming Language**: Java
- **Database**: MySQL
- **JDBC**: Used to connect Java application to the MySQL database
- **IDE**: IntelliJ IDEA / Eclipse
- **Version Control**: Git & GitHub

## Project Setup

### Prerequisites

Before running the application, make sure you have the following:

- **Java**: JDK 8 or later
- **MySQL**: Version 8.0 or later
- **MySQL Workbench**: To interact with the MySQL database
- **Maven**: If you're using Maven for dependency management (optional)

### Step 1: Set up MySQL Database

1. **Create the database**:

   In MySQL Workbench, create the `strayhaven` database:

   ```sql
   CREATE DATABASE strayhaven;
