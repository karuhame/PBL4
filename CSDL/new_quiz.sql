CREATE DATABASE new_quiz;
USE new_quiz;
CREATE TABLE Account (
  ID_Account INT PRIMARY KEY,
  username VARCHAR(255),
  password VARCHAR(255),
  role INT
);

-- Create Account Info table
CREATE TABLE Account_Info (
  ID_Info INT PRIMARY KEY,
  Name VARCHAR(255),
  Gender VARCHAR(10),
  Address VARCHAR(255),
  ID_Account INT,
  FOREIGN KEY (ID_Account) REFERENCES Account(ID_Account)
);

-- Create Result table
CREATE TABLE Result (
  ID_Result INT PRIMARY KEY,
  Marks INT,
  Number_Error INT,
  Detecting_Error VARCHAR(255),
  ID_Account INT,
  FOREIGN KEY (ID_Account) REFERENCES Account(ID_Account)
);

-- Create Question table
CREATE TABLE Question (
  ID_Question INT PRIMARY KEY,
  name VARCHAR(255),
  opt1 VARCHAR(255),
  opt2 VARCHAR(255),
  opt3 VARCHAR(255),
  opt4 VARCHAR(255),
  answer VARCHAR(255)
);