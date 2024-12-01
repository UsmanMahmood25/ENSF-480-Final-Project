
-- This model below will reset the DB everytime the program is run

-- Create the database if it doesn't already exist
DROP DATABASE IF EXISTS PROJECT_DB;
CREATE DATABASE PROJECT_DB;

-- Select the database
USE PROJECT_DB;

-- Create the Users table
DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
    email VARCHAR(255) UNIQUE PRIMARY KEY,
    u_password VARCHAR(100),
    credit_card_number VARCHAR(16),
    cvc VARCHAR(3),
    expiry_date VARCHAR(20)
);

-- Create the RegisteredUsers table
DROP TABLE IF EXISTS RegisteredUsers;
CREATE TABLE RegisteredUsers (
    email VARCHAR(255),
    ru_name VARCHAR(255),
    ru_address VARCHAR(255),
    date_of_registration DATE,
    FOREIGN KEY (email) REFERENCES Users(email) ON DELETE CASCADE
);

-- Create the Theater table
DROP TABLE IF EXISTS Theater;
CREATE TABLE Theater (
    theater_id INT AUTO_INCREMENT PRIMARY KEY,
    theater_name VARCHAR(100) NOT NULL,
    location VARCHAR(255) NOT NULL
);

-- Create the Movies table
DROP TABLE IF EXISTS Movies;
CREATE TABLE Movies (
    movie_id INT PRIMARY KEY,
    m_name VARCHAR(100) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    duration INT NOT NULL, -- Duration in minutes
    short_description TEXT
);

-- Create the Screens table
DROP TABLE IF EXISTS Screens;
CREATE TABLE Screens (
    screen_id INT AUTO_INCREMENT PRIMARY KEY,
    theater_id INT NOT NULL,
    screen_name VARCHAR(50) NOT NULL,
    s_rows INT NOT NULL, -- Number of rows in the screen
    s_cols INT NOT NULL, -- Number of columns in the screen
    FOREIGN KEY (theater_id) REFERENCES Theater(theater_id) ON DELETE CASCADE
);

-- Create the Theater_Movies table
DROP TABLE IF EXISTS Theater_Movies;
CREATE TABLE Theater_Movies (
    theater_id INT NOT NULL,
    movie_id INT NOT NULL,
    PRIMARY KEY (theater_id, movie_id),
    FOREIGN KEY (theater_id) REFERENCES Theater(theater_id) ON DELETE CASCADE,
    FOREIGN KEY (movie_id) REFERENCES Movies(movie_id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS Showtimes;
CREATE TABLE Showtimes (
    showtimeId INT AUTO_INCREMENT PRIMARY KEY,
    movie INT,
    theater INT,
    screen INT,
    showDate DATETIME,
    announceDate DATETIME,
    ticketPrice DECIMAL(5, 2),
    FOREIGN KEY (movie) REFERENCES Movies(movie_id),
    FOREIGN KEY (theater) REFERENCES Theater(theater_id),
    FOREIGN KEY (screen) REFERENCES Screens(screen_id)
);






-- This model below should allow for DB to be saved beyond program's life

-- -- Create the database if it doesn't already exist
-- CREATE DATABASE IF NOT EXISTS PROJECT_DB;

-- -- Select the database
-- USE PROJECT_DB;

-- -- Create the Theater table
-- CREATE TABLE IF NOT EXISTS Theater (
--     theater_id INT AUTO_INCREMENT PRIMARY KEY,
--     theater_name VARCHAR(100) NOT NULL,
--     location VARCHAR(255) NOT NULL
-- );

-- -- Create the Movies table
-- CREATE TABLE IF NOT EXISTS Movies (
--     movie_id INT PRIMARY KEY,
--     m_name VARCHAR(100) NOT NULL,
--     genre VARCHAR(50) NOT NULL,
--     duration INT NOT NULL, -- Duration in minutes
--     short_description TEXT
-- );

-- -- Create the Screens table
-- CREATE TABLE IF NOT EXISTS Screens (
--     screen_id INT AUTO_INCREMENT PRIMARY KEY,
--     theater_id INT NOT NULL,
--     screen_name VARCHAR(50) NOT NULL,
--     s_rows INT NOT NULL, -- Number of rows in the screen
--     s_cols INT NOT NULL, -- Number of columns in the screen
--     FOREIGN KEY (theater_id) REFERENCES Theater(theater_id) ON DELETE CASCADE
-- );

-- -- Create the Theater_Movies table
-- CREATE TABLE IF NOT EXISTS Theater_Movies (
--     theater_id INT NOT NULL,
--     movie_id INT NOT NULL,
--     PRIMARY KEY (theater_id, movie_id),
--     FOREIGN KEY (theater_id) REFERENCES Theater(theater_id) ON DELETE CASCADE,
--     FOREIGN KEY (movie_id) REFERENCES Movies(movie_id) ON DELETE CASCADE
-- );

-- -- Create the Users table
-- CREATE TABLE IF NOT EXISTS Users (
--     email VARCHAR(255) NOT NULL UNIQUE PRIMARY KEY,
--     u_password VARCHAR(100) NOT NULL,
--     credit_card_number VARCHAR(16),
--     cvc VARCHAR(3),
--     expiry_date DATE
-- );

-- -- Create the RegisteredUsers table
-- CREATE TABLE IF NOT EXISTS RegisteredUsers (
--     email VARCHAR(255) NOT NULL,
--     ru_name VARCHAR(255),
--     ru_address VARCHAR(255),
--     date_of_registration DATE NOT NULL,
--     FOREIGN KEY (email) REFERENCES Users(email) ON DELETE CASCADE
-- );



-- Some mock data in DB to be used for testing

-- Insert some mock data into the Theater table
INSERT IGNORE INTO Theater (theater_name, location) VALUES
('Cineplex Downtown', '123 Main St, City Center'),
('Grand Theater', '456 Grand Blvd, Uptown'),
('Cinema World', '789 Cinema Ave, Suburbia');

-- Insert some mock data into the Movies table
INSERT IGNORE INTO Movies (movie_id, m_name, genre, duration, short_description) VALUES
(1, 'The Matrix', 'Sci-Fi', 136, 'A hacker discovers a dystopian future controlled by machines.'),
(2, 'Titanic', 'Romance', 195, 'A young couple falls in love on the ill-fated ship Titanic.'),
(3, 'The Dark Knight', 'Action', 152, 'Batman faces the Joker, a criminal mastermind with a chaotic agenda.');

-- Insert some mock data into the Screens table
INSERT IGNORE INTO Screens (theater_id, screen_name, s_rows, s_cols) VALUES
(1, 'Screen 1', 20, 25),
(1, 'Screen 2', 15, 20),
(2, 'Screen 1', 25, 30);

-- Insert some mock data into the Theater_Movies table
INSERT IGNORE INTO Theater_Movies (theater_id, movie_id) VALUES
(1, 1),
(1, 2),
(2, 3);

INSERT IGNORE INTO Showtimes (movie, theater, screen, showDate, announceDate, ticketPrice) VALUES
(1, 1, 1, '2024-12-01 18:30:00', '2024-11-15 10:00:00', 12.99),
(2, 1, 2, '2024-12-01 19:00:00', '2024-11-16 11:30:00', 15.49),
(3, 2, 1, '2024-12-02 20:00:00', '2024-11-18 12:00:00', 18.00),
(1, 3, 1, '2024-12-02 21:00:00', '2024-11-20 14:00:00', 13.99),
(2, 1, 2, '2024-12-03 16:00:00', '2024-11-21 09:00:00', 16.49),
(3, 2, 1, '2024-12-03 17:00:00', '2024-11-22 10:30:00', 17.99);


-- Insert some mock data into the Users table
INSERT IGNORE INTO Users (email, u_password, credit_card_number, cvc, expiry_date) VALUES
('john.doe@example.com', 'password123', '1234567890123456', '123', '2025-12-01'),
('jane.smith@example.com', 'password456', '9876543210987654', '456', '2026-06-15'),
('alice.jones@example.com', 'password789', '5555555555555555', '789', '2027-03-20');

-- Insert some mock data into the RegisteredUsers table
INSERT IGNORE INTO RegisteredUsers (email, ru_name, ru_address, date_of_registration) VALUES
('john.doe@example.com', 'John Doe', '123 Main St, City Center', '2023-05-10'),
('alice.jones@example.com', 'Alice Jones', '789 Cinema Ave, Suburbia', '2023-07-22');
