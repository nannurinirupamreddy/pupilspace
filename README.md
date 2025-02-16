# PupilSpace - Student Management
This project is a command-line interface student management system that allows users to perform CRUD (Create, Retrieve, Update, Delete) operations on student data. The data is stored in a MySQL database.

## Features

- Add new student data
- Retrieve existing student data
- Update existing student data
- Delete existing student data

## Classes

### Main

The `Main` class provides a command-line interface for managing student data. Users can add, retrieve, update, and delete student records.

### Student

The `Student` class represents a student with various attributes and provides methods to perform CRUD operations on student data in a database.

### IdInvalidException

The `IdInvalidException` class is a custom exception that is thrown when an invalid student ID is encountered

### InvalidAgeException

The `InvalidAgeException` class is a custom exception that is thrown when an invalid student age is encountered.

## Database Configuration

The database connection details are specified in the `Student` class. Make sure to update the following variables with your own database configuration:

```java
String url = "jdbc:mysql://localhost:3306/pupilspace";
String user = "root";
String password = "[YOUR_ROOT_PASSWORD]";
```

# How to Run

- Make sure you have MySQL installed and running.
- Create a database named pupilspace and a table named information with the following schema:

```SQL:

CREATE DATABASE pupilspace;

USE pupilspace;

CREATE TABLE information (
	id INT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	age INT NOT NULL,
	gender VARCHAR(10) NOT NULL,
	email VARCHAR(200) NOT NULL,
	phoneNumber VARCHAR(15) NOT NULL,
	address TEXT NOT NULL
);

You can find the SQL queries in PupilSpace\src\SQL Queries.sql
```
- Update the database configuration in the `Student` class.
- Compile and run the `Main` class.

# Exception Handling

The project includes custom exceptions to handle invalid student IDs and ages:

## IdInvalidException

Throw when an invalid student ID is encountered.

## InvalidAgeException

Thrown when an invalid student age is encountered.

# License

This project is licensed under MIT License.
