CREATE DATABASE FTT;
USE FTT;

CREATE TABLE FTT.Pokemon (
	Id INTEGER AUTO_INCREMENT PRIMARY KEY,
	Name VARCHAR(50),
    Number INTEGER,
    Type VARCHAR(50)
);

CREATE TABLE FTT.Type (
	Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Biggest_Weakness VARCHAR(50),
    Biggest_Advantage VARCHAR(50)
);

CREATE TABLE FTT.Moves (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Power INTEGER,
    Acuracy INTEGER,
    Type INTEGER
);

CREATE TABLE FTT.Berry (
	Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Growth_Time INTEGER
);

CREATE TABLE FTT.Item (
    Id INTEGER AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(50),
    Rarity INTEGER
);
