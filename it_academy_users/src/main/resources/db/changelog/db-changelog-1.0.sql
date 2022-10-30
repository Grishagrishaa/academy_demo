--liquibase formatted sql

--changeset grisha:1
CREATE TABLE users (
    uuid varchar(36) NOT NULL,
    create_date datetime DEFAULT NULL,
    email varchar(255) DEFAULT NULL,
    name varchar(255) DEFAULT NULL,
    patronymic varchar(255) DEFAULT NULL,
    role varchar(255) DEFAULT NULL,
    surname varchar(255) DEFAULT NULL,
    update_date datetime DEFAULT NULL,
    PRIMARY KEY (uuid)
    )


