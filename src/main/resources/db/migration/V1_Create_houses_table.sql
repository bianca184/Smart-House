CREATE DATABASE IF NOT EXISTS smart_house;

USE smart_house;

CREATE TABLE houses (
                       id BIGINT NOT NULL AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                            PRIMARY KEY (id)
);