# SQL Queries to create and run a database, tables for PupilSpace project

CREATE DATABASE pupilspace; -- This query is used to create pupilspace database

USE pupilspace; -- Query for using the pupilspace database

CREATE TABLE information( -- Query for creating a table named "information" to store student data
	id INT PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    email VARCHAR(200) NOT NULL,
    phoneNumber VARCHAR(15) NOT NULL,
    address TEXT NOT NULL
);