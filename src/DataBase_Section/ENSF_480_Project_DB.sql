CREATE DATABASE IF NOT EXISTS PROJECT_DB;
USE PROJECT_DB;

CREATE TABLE IF NOT EXISTS Theater (
    theater_id INT AUTO_INCREMENT PRIMARY KEY,
    theater_name VARCHAR(100) NOT NULL,
    location VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Movies (
    movie_id INT PRIMARY KEY,
    theater_id INT NOT NULL,
    m_name VARCHAR(100) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    duration INT NOT NULL, -- Duration in minutes 
    short_description TEXT,
    FOREIGN KEY (theater_id) REFERENCES Theater(theater_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS Screens (
    screen_id INT AUTO_INCREMENT PRIMARY KEY,
    theater_id INT NOT NULL,
    screen_name VARCHAR(50) NOT NULL,
    s_rows INT NOT NULL, -- Number of rows in the screen
    s_cols INT NOT NULL, -- Number of columns in the screen
    FOREIGN KEY (theater_id) REFERENCES Theater(theater_id) ON DELETE CASCADE
);


